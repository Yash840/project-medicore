package org.cross.medicore.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.cross.medicore.model.AppointmentStatus;
import org.cross.medicore.model.AppointmentType;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;


@Data
@NoArgsConstructor
public class AppointmentResponseDto {
    UUID appointmentId;
    String patientName;
    String doctorName;
    LocalDate appointmentDate;
    LocalTime appointmentTime;
    AppointmentType appointmentType;
    AppointmentStatus appointmentStatus;
    BigDecimal fees;
    boolean paymentDone;
    UUID paymentReceiptId;
    UUID appointmentReportId;
}
