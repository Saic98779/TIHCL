package com.metaverse.tihcl.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="registration")
public class Registration {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "registration_id")
    private Long registrationId;

    @Column(name = "enterprise_name")
    private String enterpriseName;

    @Column(name = "promoter_name")
    private String promoterName;

    @Column(name = "constitution")
    private String constitution;

    @Column(name = "production_date")
    private Date productionDate;

    @Column(name = "udyam_reg_number")
    private String udyamRegNumber;

    @Column(name = "contact_number")
    private Long contactNumber;

    @Column(name="industrial_park")
    private String industrialPark;

    @Column(name = "state")
    private String state;

    @Column(name = "district")
    private String district;

    @Column(name = "mandal")
    private String mandal;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    @Column(name = "enterprise_category")
    private String enterpriseCategory;//Micro, Small, Medium, Large

    @Column(name = "nature_of_activity")
    private String natureOfActivity;//Manufacturing, services, Trading

    @Column(name = "sector")
    private String sector;

    @Column(name = "operation_status")
    private Boolean operationStatus;
    //if yes
    @Column(name = "operating_satisfactorily")
    private String operatingSatisfactorily;

    @Column(name = "operating_difficulties")
    private String operatingDifficulties;
    //if no
    @Column(name = "issue_date")
    private Date issueDate;

    @Column(name = "reason_for_not_operating")
    private String reasonForNotOperating;

    @Column(name = "restart_support")
    private String restartSupport;

    @Column(name = "restart_intent")
    private Boolean restartIntent;

    @Column(name = "existing_credit")
    private Boolean existingCredit;

    //if yes
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "registration_id")
    private List<CreditFacilityDetails> creditFacilityDetails;

    @Column(name = "unit_status")
    private String unitStatus;
    //if no
    @Column(name = "required_credit_limit")
    private Double requiredCreditLimit;

    @Column(name = "investment_subsidy")
    private Boolean investmentSubsidy;

    //if yes
    @Column(name = "total_amount_sanctioned")
    private Double totalAmountSanctioned;

    @Column(name = "amount_released")
    private Double amountReleased;

    @Column(name = "amount_to_be_released")
    private Double amountToBeReleased;

    @Column(name = "maintaining_account_by")
    private String maintainingAccountBy;

    @Column(name="help_msg")
    private String helpMsg;

    @Column(name="application_no")
    private String applicationNo;

    @Column(name="status")
    private String status;

    @Column(name="created_on",insertable = true,updatable = false)
    @CreationTimestamp
    private Date createdOn;

    @Column(name="updated_on",insertable = false,updatable = true)
    @UpdateTimestamp
    private Date updatedOn;

}
