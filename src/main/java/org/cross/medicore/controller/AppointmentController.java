package org.cross.medicore.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.cross.medicore.dto.AppointmentRequestDto;
import org.cross.medicore.dto.AppointmentResponseDto;
import org.cross.medicore.mapper.AppointmentMapper;
import org.cross.medicore.model.Appointment;
import org.cross.medicore.service.AppointmentService;
import org.cross.medicore.service.PatientService;
import org.cross.medicore.service.StaffService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@RestController
@RequestMapping("/api/appointment")
public class AppointmentController {
    private AppointmentService appointmentService;
    private StaffService staffService;
    private PatientService patientService;


    @GetMapping("/")
    public ResponseEntity<ApiResponse<List<AppointmentResponseDto>>> getAllAppointments(){
        ApiResponse<List<AppointmentResponseDto>> apiResponse = new ApiResponse<>();

       List<AppointmentResponseDto> appointmentResponseDtos = appointmentService.getAllAppointments().stream()
               .map(app -> {
                   String doctorName = staffService.getStaffName(app.getDoctorId());
                   String patientName = patientService.getPatientName(app.getPatientId());

                   return AppointmentMapper.toDto(app, patientName, doctorName);
               })
               .collect(Collectors.toCollection(ArrayList::new));

       apiResponse.setData(appointmentResponseDtos);

       return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/{patientId}")
    public ResponseEntity<ApiResponse<List<AppointmentResponseDto>>> getAllAppointmentsForPatient(@PathVariable UUID patientId){
        ApiResponse<List<AppointmentResponseDto>> apiResponse = new ApiResponse<>();

        List<AppointmentResponseDto> appointmentResponseDtos = appointmentService.getAppointmentsForPatient(patientId).stream()
                .map(app -> {
                    String doctorName = staffService.getStaffName(app.getDoctorId());
                    String patientName = patientService.getPatientName(app.getPatientId());

                    return AppointmentMapper.toDto(app, patientName, doctorName);
                })
                .collect(Collectors.toCollection(ArrayList::new));

//        apiResponse.setMessage("Appointments Fetched");
//        apiResponse.setSuccess(true);
//        apiResponse.setData(appointmentResponseDtos);

        return ResponseEntity.ok(apiResponse);
    }

    @PostMapping("/")
    public ResponseEntity<ApiResponse<AppointmentResponseDto>> addAppointment(@RequestBody AppointmentRequestDto dto){
        ApiResponse<AppointmentResponseDto> apiResponse = new ApiResponse<>();

        Appointment createdAppointment = appointmentService.createNewAppointment(dto);

        String doctorName = staffService.getStaffName(createdAppointment.getDoctorId());
        String patientName = patientService.getPatientName(createdAppointment.getPatientId());

        AppointmentResponseDto appointmentResponseDto = AppointmentMapper.toDto(createdAppointment, patientName, doctorName);

        apiResponse.setData(appointmentResponseDto);

        return ResponseEntity.ok(apiResponse);
    }

}
