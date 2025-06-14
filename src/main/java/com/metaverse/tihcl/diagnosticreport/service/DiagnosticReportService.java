package com.metaverse.tihcl.diagnosticreport.service;

import com.metaverse.tihcl.diagnosticreport.dto.*;
import com.metaverse.tihcl.diagnosticreport.repository.*;
import com.metaverse.tihcl.model.*;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DiagnosticReportService {

    private final DiagnosticReportRepository diagnosticReportRepository;

    @Transactional
    public DiagnosticReportDto saveScreenData(DiagnosticReportDto dto) {
        if (dto.getCurrentScreenStatus() == null) {
            throw new IllegalArgumentException("currentScreenStatus must be provided.");
        }

        DiagnosticReport diagnosticReport = dto.getId() != null
                ? diagnosticReportRepository.findById(dto.getId())
                .orElseThrow(() -> new RuntimeException("Diagnostic Report not found with ID: " + dto.getId()))
                : diagnosticReportRepository.save(new DiagnosticReport());

        updateDiagnosticReportFields(diagnosticReport, dto);

        diagnosticReport.setProgressStatus(dto.getCurrentScreenStatus());
        DiagnosticReport savedReport = diagnosticReportRepository.save(diagnosticReport);

        return convertToDto(savedReport);
    }

    private void updateDiagnosticReportFields(DiagnosticReport report, DiagnosticReportDto dto) {
        copyIfNotNull(dto.getName(), report::setName);
        copyIfNotNull(dto.getContactNo(), report::setContactNo);
        copyIfNotNull(dto.getGstNumber(), report::setGstNumber);
        copyIfNotNull(dto.getProductManufactured(), report::setProductManufactured);
        copyIfNotNull(dto.getDemandForTheProduct(), report::setDemandForTheProduct);
        copyIfNotNull(dto.getReasonForStress(), report::setReasonForStress);
        copyIfNotNull(dto.getObservations(), report::setObservations);
        copyIfNotNull(dto.getApprovalStatus(), report::setApprovalStatus);

        switch (dto.getCurrentScreenStatus()) {
            case BASIC_DETAILS:
                copyCollection(dto.getShareholders(), report.getShareholders(), (source, target) -> {
                    BeanUtils.copyProperties(source, target);
                    target.setDiagnosticReport(report);
                }, Shareholder::new);
                break;

            case TOP_5_BUYERS:
                copyCollection(dto.getTopBuyers(), report.getTopBuyers(), (source, target) -> {
                    BeanUtils.copyProperties(source, target);
                    target.setDiagnosticReport(report);
                }, Buyer::new);
                break;

            case RECEIVABLES_PAYABLES:
                copyCollection(dto.getReceivables(), report.getReceivables(), (source, target) -> {
                    BeanUtils.copyProperties(source, target);
                    target.setDiagnosticReport(report);
                }, Receivable::new);

                copyCollection(dto.getPayables(), report.getPayables(), (source, target) -> {
                    BeanUtils.copyProperties(source, target);
                    target.setDiagnosticReport(report);
                }, Payable::new);
                break;

            case OPERATIONAL_STATUS:
                if (dto.getOperationalStatus() != null) {
                    OperationalStatus operationalStatus = Optional.ofNullable(report.getOperationalStatus())
                            .orElseGet(() -> {
                                OperationalStatus os = new OperationalStatus();
                                os.setDiagnosticReport(report);
                                report.setOperationalStatus(os);
                                return os;
                            });

                    BeanUtils.copyProperties(dto.getOperationalStatus(), operationalStatus, "orderBookPositions");

                    copyCollection(dto.getOperationalStatus().getOrderBookPositions(), operationalStatus.getOrderBookPositions(), (source, target) -> {
                        BeanUtils.copyProperties(source, target);
                        target.setOperationalStatus(operationalStatus);
                    }, OrderBookPosition::new);
                }
                break;

            case BALANCE_SHEET:
                copyCollection(dto.getBalanceSheets(), report.getBalanceSheets(), (source, target) -> {
                    BeanUtils.copyProperties(source, target);
                    target.setDiagnosticReport(report);
                }, BalanceSheet::new);
                break;

            default:
                break;
        }
    }

    private <S, T> void copyCollection(
            List<S> sourceList,
            List<T> targetList,
            BiConsumer<S, T> copier,
            Supplier<T> targetSupplier
    ) {
        if (sourceList != null && targetList != null) {
            targetList.clear();
            sourceList.forEach(source -> {
                T target = targetSupplier.get();
                copier.accept(source, target);
                targetList.add(target);
            });
        }
    }

    private <T> void copyIfNotNull(T value, java.util.function.Consumer<T> setter) {
        Optional.ofNullable(value).ifPresent(setter);
    }

    private DiagnosticReportDto convertToDto(DiagnosticReport report) {
        DiagnosticReportDto dto = new DiagnosticReportDto();
        BeanUtils.copyProperties(report, dto, "shareholders", "topBuyers", "receivables", "payables", "operationalStatus", "balanceSheets");

        dto.setCurrentScreenStatus(report.getProgressStatus());

        dto.setShareholders(mapCollection(report.getShareholders(), ShareholderDto.class));
        dto.setTopBuyers(mapCollection(report.getTopBuyers(), BuyerDto.class));
        dto.setReceivables(mapCollection(report.getReceivables(), ReceivableDto.class));
        dto.setPayables(mapCollection(report.getPayables(), PayableDto.class));

        if (report.getOperationalStatus() != null) {
            OperationalStatusDto osDto = new OperationalStatusDto();
            BeanUtils.copyProperties(report.getOperationalStatus(), osDto, "orderBookPositions");
            osDto.setOrderBookPositions(mapCollection(report.getOperationalStatus().getOrderBookPositions(), OrderBookPositionDto.class));
            dto.setOperationalStatus(osDto);
        }

        dto.setBalanceSheets(mapCollection(report.getBalanceSheets(), BalanceSheetDto.class));

        return dto;
    }

    private <S, T> java.util.List<T> mapCollection(java.util.List<S> sourceList, Class<T> targetClass) {
        if (sourceList == null) return null;
        return sourceList.stream().map(source -> {
            try {
                T target = targetClass.getDeclaredConstructor().newInstance();
                BeanUtils.copyProperties(source, target);
                return target;
            } catch (Exception e) {
                throw new RuntimeException("Error while mapping collection", e);
            }
        }).collect(Collectors.toList());
    }
}
