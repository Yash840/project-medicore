package org.cross.medicore.repository;

import org.cross.medicore.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, UUID> {
    List<Appointment> findAllByPatientId(UUID patientId);

    List<Appointment> findAllByAppointmentDate(LocalDate date);
}
