package org.cross.medicore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.cross.medicore.model.Medication;
import org.cross.medicore.model.Symptom;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReportResponseDto {
    private UUID patientId;
    private UUID staffId;
    private LocalDateTime issueDateAndTime;
    private List<Symptom> symptomList;
    private List<Medication> medicationList;
    private String verdict;
    private String remarks;
}
