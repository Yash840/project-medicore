package org.cross.medicore.controller;

import org.cross.medicore.model.Patient;
import org.cross.medicore.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/patients")
public class PatientController {
    PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService){
        this.patientService = patientService;
    }

    @GetMapping("/")
    public ResponseEntity<ApiResponse<List<Patient>>> getAllPatients(){
        List<Patient> patients = patientService.getAllPatients();

        return new ResponseEntity<>(new ApiResponse<List<Patient>>("Patients Fetched Successfully", true,patients), HttpStatus.OK);
    }

    @GetMapping("/{patientNumber}")
    public ResponseEntity<ApiResponse<Patient>> getPatientByNumber(@PathVariable String patientNumber){
        Patient patient = patientService.getPatientByNumber(patientNumber);

        return new ResponseEntity<>(new ApiResponse<Patient>("Patient Fetched Successfully", true,patient), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<ApiResponse<Patient>> admitPatient(@RequestBody Patient patient){
        ApiResponse<Patient> responseBody = new ApiResponse<>();

        Patient addedPatient = patientService.addNewPatient(patient);
        responseBody.setData(addedPatient);

        if(addedPatient == null){
            responseBody.setMessage("Error Occurred In Adding Patient");
            responseBody.setSuccess(false);
            return new ResponseEntity<>(responseBody, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        responseBody.setMessage("Patient Created Successfully");
        responseBody.setSuccess(true);
        return new ResponseEntity<>(responseBody, HttpStatus.CREATED);
    }

    @PatchMapping("/{patientNumber}")
    public ResponseEntity<ApiResponse<Patient>> updatePatientDetails(@PathVariable String patientNumber,@RequestBody Map<String, Object> updates){
        ApiResponse<Patient> apiResponse = new ApiResponse<>();

        try {
            Patient updatedPatient = patientService.updatePatientDetails(patientNumber, updates);
            apiResponse.setMessage("Patient Details Updated");
            apiResponse.setSuccess(true);
            apiResponse.setData(updatedPatient);
            return new ResponseEntity<>(apiResponse, HttpStatus.OK);
        }catch (Exception e){
            apiResponse.setMessage(e.getMessage());
            apiResponse.setSuccess(false);
            apiResponse.setData(null);
            return new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{patientNumber}")
    public ResponseEntity<ApiResponse<Patient>> deletePatient(@PathVariable String patientNumber){
        ApiResponse<Patient> apiResponse = new ApiResponse<>();

        try {
            Patient deletedPatient = patientService.deletePatient(patientNumber);
            apiResponse.setMessage("Patient Deleted");
            apiResponse.setSuccess(true);
            apiResponse.setData(deletedPatient);
            return new ResponseEntity<>(apiResponse, HttpStatus.OK);
        }catch (Exception e){
            apiResponse.setMessage(e.getMessage());
            apiResponse.setSuccess(false);
            apiResponse.setData(null);
            return new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
