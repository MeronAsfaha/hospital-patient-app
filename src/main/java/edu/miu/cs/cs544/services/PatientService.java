package edu.miu.cs.cs544.services;

import edu.miu.cs.cs544.entities.Patient;

import java.util.List;

public interface PatientService {

    List<Patient> getAllPatients();
    Patient getPatientById(Long id);
    Patient save(Patient patient);
    Patient updateExistingPatient(Patient patient);
    void deletePatient(Long id);
    List<Patient> findAllPatientsInsuredWithBlueShieldAndTreatedAtHospitalBuiltAfter2010();
    void sendPatientName(Long id);
    Patient getByName(String name);

}
