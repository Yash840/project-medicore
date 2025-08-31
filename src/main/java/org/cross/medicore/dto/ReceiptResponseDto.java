package org.cross.medicore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.cross.medicore.model.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReceiptResponseDto {
    private UUID id;
    private UUID patientId;
    private UUID staffId;
    private LocalDateTime issueDateAndTime;
    private List<Service> services;
    private double netBill;
}
