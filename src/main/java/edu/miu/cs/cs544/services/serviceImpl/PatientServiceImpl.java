package edu.miu.cs.cs544.services.serviceImpl;

import edu.miu.cs.cs544.entities.Patient;
import edu.miu.cs.cs544.repositories.PatientRepository;
import edu.miu.cs.cs544.services.PatientService;
import edu.miu.cs.cs544.services.jms.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private Producer producer;

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public Patient getPatientById(Long id) {
        return patientRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Patient Not Found"));
    }

    @Override
    public Patient save(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Patient updateExistingPatient(Patient patient) {
        getPatientById(patient.getId());
        return patientRepository.save(patient);
    }

    @Override
    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }

    @Override
    public List<Patient> findAllPatientsInsuredWithBlueShieldAndTreatedAtHospitalBuiltAfter2010() {
        return patientRepository.getAllPatientsInsuredWithBlueShieldAtHospitalBuiltAfter2010();
    }

    @Override
    public void sendPatientName(Long id) {
        Patient patient = getPatientById(id);
        String name = patient.getName();
        producer.send(name);
    }

    @Override
    public Patient getByName(String name) {
        return patientRepository.getPatientByName(name);
    }
}
