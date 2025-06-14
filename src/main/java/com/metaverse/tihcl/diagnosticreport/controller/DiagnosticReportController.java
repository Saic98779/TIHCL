package com.metaverse.tihcl.diagnosticreport.controller;


import com.metaverse.tihcl.diagnosticreport.dto.DiagnosticReportDto;
import com.metaverse.tihcl.diagnosticreport.service.DiagnosticReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/diagnostic-reports")
@RequiredArgsConstructor
public class DiagnosticReportController {

    private final DiagnosticReportService diagnosticReportService;

    /**
     * Endpoint to save or update diagnostic report data for a specific screen.
     * The `currentScreenStatus` in the DTO determines which part of the data is being submitted.
     * `@param` `dto` DiagnosticReportDto containing data for the current screen and the currentScreenStatus.
     * @return ResponseEntity with the saved/updated DiagnosticReportDto and HTTP status.
     */
    @PostMapping("/save")
    public ResponseEntity<DiagnosticReportDto> saveScreenData(@RequestBody DiagnosticReportDto dto) {
        try {
            DiagnosticReportDto savedDto = diagnosticReportService.saveScreenData(dto);
            return new ResponseEntity<>(savedDto, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        } catch (RuntimeException e) {
            System.err.println("Error saving diagnostic report data: " + e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
