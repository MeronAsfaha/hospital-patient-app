package edu.miu.cs.cs544.repositories;

import edu.miu.cs.cs544.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient,Long> {

    @Query("select h.patients from Hospital h join h.patients p where p.insurance= 'Blue Shield'" +
            "and h.yearBuilt > 2010")
    List<Patient> getAllPatientsInsuredWithBlueShieldAtHospitalBuiltAfter2010();

//    @Query("Select p from Patient p where p.name = :name")
    Patient getPatientByName(String name);


}
