package org.cross.medicore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.cross.medicore.model.Service;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReceiptRequestDto {
    private UUID patientId;
    private UUID doctorId;
    private List<Service> services;
    private double discount;
}
