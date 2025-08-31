package org.cross.medicore.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(unique = true, nullable = false, updatable = false)
    private String patientNumber;
    private String name;
    private int age;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private LocalDate dob;
    private LocalDate dateOfAdmission;
    private BigDecimal feesRemaining;
    private String contactNumber;
    private String email;
    private String address;
    @Enumerated(EnumType.STRING)
    private PatientStatus status;

    @PrePersist
    public void assignPatientNumber(){
        String year = String.valueOf(java.time.Year.now().getValue());
        String suffix = Integer.toString(new SecureRandom().nextInt(99999), 36).toUpperCase();

        this.patientNumber = "P" + year + suffix;
    }
}
