package org.cross.medicore.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@MappedSuperclass
@Data
public abstract class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private UUID patientId;
    private UUID staffId;
    private LocalDateTime issueDateAndTime;
    @Enumerated(EnumType.STRING)
    private DocumentType type;
}
