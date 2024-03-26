package edu.miu.cs.cs544.services;

import edu.miu.cs.cs544.entities.Hospital;

import java.util.List;

public interface HospitalService {
    List<Hospital> getAllHospitals();
    Hospital getHospitalById(Long id);
    Hospital save(Hospital hospital);
    Hospital updateExistingHospital(Hospital hospital);
    void deleteHospital(Long id);
    List<Hospital> getAllHospitalsWithCapacityMoreThanOneFifty();
    Hospital getLargestHospital();
    List<Hospital> getAllHospitalsWithGivenCapacityAndBuiltInAGivenYear(Integer capacity, Integer year);
}
