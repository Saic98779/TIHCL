package com.metaverse.tihcl.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="credit_facility_details")
public class CreditFacilityDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long CreditFacilityDetailsId;

    @Column(name="bank_name")
    private String bankName;

    @Column(name="limit_sanctioned")
    private Double limitSanctioned;

    @Column(name="outstanding_amount")
    private Double outstandingAmount;

    @Column(name="overdue_amount")
    private Double overdueAmount;

    @Column(name="overdue_date")
    private Date overdueDate;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "registration_id")
    private Registration registration;

    @Column(name="created_on",insertable = true,updatable = false)
    @CreationTimestamp
    private Date createdOn;

    @Column(name="updated_on",insertable = false,updatable = true)
    @UpdateTimestamp
    private Date updatedOn;
}
