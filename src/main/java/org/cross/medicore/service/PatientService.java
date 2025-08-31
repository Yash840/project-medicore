package org.cross.medicore.service;

import org.cross.medicore.model.Patient;
import org.cross.medicore.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository){
        this.patientRepository = patientRepository;
    }


    public String getIdByNumber(String patientNumber){
        try {
            Patient patient = patientRepository.findByPatientNumber(patientNumber)
                    .orElseThrow(() -> new ChangeSetPersister.NotFoundException());

            return patient.getId().toString();
        } catch (ChangeSetPersister.NotFoundException e) {
            throw new RuntimeException("Invalid Patient Number");
        }
    }

    public Patient addNewPatient(Patient patient){
        try{
            return patientRepository.save(patient);
        }catch (Exception e){
            System.out.println("Something Went Wrong");
            e.printStackTrace();
            return null;
        }
    }

    public List<Patient> getAllPatients() {
        try{
            return patientRepository.findAll();
        }catch (Exception e){
            System.out.println("Something Went Wrong");
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public Patient getPatientByNumber(String patientNumber) {
        try{
            return patientRepository.findByPatientNumber(patientNumber).orElse(null);
        } catch (Exception e) {
            System.out.println("Something Went Wrong");
            e.printStackTrace();
            return null;
        }
    }

    public String getPatientName(UUID patientId){
        try {
            Patient patient = patientRepository.findById(patientId).orElse(null);

            return patient.getName();
        } catch (NullPointerException e) {
            throw new RuntimeException("Invalid Patient Number");
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public Patient updatePatientDetails(String patientNumber, Map<String, Object> updates){

        try {
            Patient patient = patientRepository.findByPatientNumber(patientNumber)
                    .orElseThrow(ChangeSetPersister.NotFoundException::new);

            updates.forEach( (fieldName, value) -> {
                Field field = null;
                try {
                    field = Patient.class.getDeclaredField(fieldName);
                    field.setAccessible(true);
                    field.set(patient, value);
                } catch (NoSuchFieldException | IllegalAccessException e) {
                    throw new RuntimeException("Field does not exist : " + fieldName);
                }
            });

            return patientRepository.save(patient);
        } catch (ChangeSetPersister.NotFoundException e){
            throw new RuntimeException("Invalid Patient Number");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Patient deletePatient(String patientNumber) {
        try {
            Patient patient = patientRepository.findByPatientNumber(patientNumber)
                    .orElseThrow(() -> new ChangeSetPersister.NotFoundException());

            patientRepository.delete(patient);
            return  patient;
        } catch (ChangeSetPersister.NotFoundException e) {
            throw new RuntimeException("Invalid Patient Number");
        }

    }
}
