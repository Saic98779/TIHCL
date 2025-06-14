package com.metaverse.tihcl.model;

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
@Table(name = "stress_score")
public class StressScore {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "stress_score_id")
    private Integer stressScoreId;

    @Column(name = "issues")
    private String issues;
    
    @Column(name = "risk_categorisation")
    private String riskCategorisation;

    @ManyToOne
    @JoinColumn(name = "registration_usage_id")
    private RegistrationUsage registrationUsage;

    @Column(name = "created_on", insertable = true, updatable = false)
    @CreationTimestamp
    private Date createdOn;

    @Column(name = "updated_on", insertable = false, updatable = true)
    @UpdateTimestamp
    private Date updatedOn;
}