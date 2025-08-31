package org.cross.medicore.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String staffUserName;
    private String securedPassword;
    private String name;
    @Enumerated(EnumType.STRING)
    private Role role;
    private LocalDate dob;
    private LocalDate dateOfJoining;
    private String contactNumber;
    private String email;
    private String address;

    private String specialisation;
    private String medicalLicenseNumber;
    private String medicalLicenseValidTill;
}
