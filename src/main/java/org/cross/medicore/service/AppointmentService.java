package org.cross.medicore.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.cross.medicore.dto.AppointmentRequestDto;
import org.cross.medicore.mapper.AppointmentMapper;
import org.cross.medicore.model.Appointment;
import org.cross.medicore.model.AppointmentStatus;
import org.cross.medicore.repository.AppointmentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
@Data
@AllArgsConstructor
public class AppointmentService {

    private AppointmentRepository appointmentRepository;

    public Appointment createNewAppointment(AppointmentRequestDto dto){
        Appointment appointment = AppointmentMapper.toModel(dto);
        appointment.setAppointMentStatus(AppointmentStatus.PENDING);

        return appointmentRepository.save(appointment);
    }

    public List<Appointment> getAllAppointments(){
        return appointmentRepository.findAll();
    }

    public List<Appointment> getAppointmentsForPatient(UUID patientId){
        return appointmentRepository.findAllByPatientId(patientId);
    }

    public List<Appointment> getAppointmentsForDate(LocalDate date){
        return appointmentRepository.findAllByAppointmentDate(date);
    }
}
