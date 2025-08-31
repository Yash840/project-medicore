package org.cross.medicore.mapper;

import org.cross.medicore.dto.AppointmentRequestDto;
import org.cross.medicore.dto.AppointmentResponseDto;
import org.cross.medicore.model.Appointment;
import org.cross.medicore.model.AppointmentStatus;
import org.cross.medicore.model.Staff;
import org.cross.medicore.repository.StaffRepository;
import org.cross.medicore.service.StaffService;


public class AppointmentMapper {

    public static Appointment toModel(AppointmentRequestDto dto){
        Appointment appointment  = new Appointment();
        appointment.setPatientId(dto.getPatientId());
        appointment.setDoctorId(dto.getDoctorId());
        appointment.setAppointmentType(dto.getAppointmentType());
        appointment.setAppointmentDate(dto.getAppointmentDate());
        appointment.setAppointmentTime(dto.getAppointmentTime());


        return appointment;
    }

    public static AppointmentResponseDto toDto(Appointment appointment, String patientName, String doctorName){
        AppointmentResponseDto appointmentResponseDto = new AppointmentResponseDto();

        appointmentResponseDto.setAppointmentId(appointment.getId());
        appointmentResponseDto.setAppointmentType(appointment.getAppointmentType());
        appointmentResponseDto.setAppointmentReportId(appointment.getAppointmentReportId());
        appointmentResponseDto.setAppointmentStatus(appointment.getAppointMentStatus());
        appointmentResponseDto.setAppointmentDate(appointment.getAppointmentDate());
        appointmentResponseDto.setAppointmentTime(appointment.getAppointmentTime());
        appointmentResponseDto.setPaymentReceiptId(appointment.getPaymentReceiptId());
        appointmentResponseDto.setPatientName(patientName);
        appointmentResponseDto.setDoctorName(doctorName);

        return appointmentResponseDto;
    }
}
