package org.cross.medicore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.cross.medicore.model.AppointmentType;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentRequestDto {

    private UUID patientId;
    private UUID doctorId;
    private LocalDate appointmentDate;
    private LocalTime appointmentTime;
    private AppointmentType appointmentType;
}
