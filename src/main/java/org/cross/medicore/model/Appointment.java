package org.cross.medicore.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private UUID patientId;
    private UUID doctorId;
    private LocalDate appointmentDate;
    private LocalTime appointmentTime;
    @Enumerated(EnumType.STRING)
    private AppointmentType appointmentType;
    @Enumerated(EnumType.STRING)
    private AppointmentStatus appointMentStatus;
    private BigDecimal fees;
    private boolean paymentDone;
    private UUID paymentReceiptId;
    private UUID appointmentReportId;
}
