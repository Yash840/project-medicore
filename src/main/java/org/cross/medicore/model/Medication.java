package org.cross.medicore.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Medication {
    private String medicine;
    private String intakePattern;
    private boolean preMeal;
    private int doseDuration;
}
