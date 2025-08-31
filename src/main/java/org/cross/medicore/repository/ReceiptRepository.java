package org.cross.medicore.repository;

import org.cross.medicore.model.Patient;
import org.cross.medicore.model.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ReceiptRepository extends JpaRepository<Receipt, UUID> {
    List<Receipt> findAllByPatientId(UUID id);
}
