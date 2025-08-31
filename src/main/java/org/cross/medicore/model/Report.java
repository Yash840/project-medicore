package org.cross.medicore.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Report extends Document {
    @ElementCollection
    @CollectionTable(
            name = "report_symptoms",
            joinColumns = @JoinColumn(name = "report_id")
    )
    private List<Symptom> symptomList;
    @ElementCollection
    @CollectionTable(
            name = "report_medications",
            joinColumns = @JoinColumn(name = "report_id")
    )
    private List<Medication> medicationList;
    private String verdict;
    private String remarks;
}
