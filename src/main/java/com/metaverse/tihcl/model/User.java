package com.metaverse.tihcl.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Table(name="user")
public class User {

    @Id
    @Column(name="user_id")
    private String userId;

    @Column(name="email")
    private String email;

    @Column(name="password")
    private String password;

    @Column(name="user_role")
    private String userRole;

    @Column(name="status")
    private String status;

    @Column(name="mobile_no")
    private Long mobileNo;

    @Column(name="created_on",insertable = true,updatable = false)
    @CreationTimestamp
    private Date createdOn;

    @Column(name="updated_on",insertable = false,updatable = true)
    @UpdateTimestamp
    private Date updatedOn;

    @Column(name = "last_login")
    private LocalDateTime lastLogin;

    @OneToOne
    @JoinColumn(name = "registration_id")
    private Registration registrationId;

}

