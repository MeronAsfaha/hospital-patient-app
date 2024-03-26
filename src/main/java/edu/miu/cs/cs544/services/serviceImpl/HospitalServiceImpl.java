package edu.miu.cs.cs544.services.serviceImpl;

import edu.miu.cs.cs544.entities.Hospital;
import edu.miu.cs.cs544.repositories.HospitalRepository;
import edu.miu.cs.cs544.services.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HospitalServiceImpl implements HospitalService {

    @Autowired
    private HospitalRepository hospitalRepository;

    @Override
    public List<Hospital> getAllHospitals() {
        return hospitalRepository.findAll();
    }

    @Override
    public Hospital getHospitalById(Long id) {
        return hospitalRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Hospital Not Found"));
    }

    @Override
    public Hospital save(Hospital hospital) {
        return hospitalRepository.save(hospital);
    }

    @Override
    public Hospital updateExistingHospital(Hospital hospital) {
        getHospitalById(hospital.getId());
        return hospitalRepository.save(hospital);
    }

    @Override
    public void deleteHospital(Long id) {
        hospitalRepository.deleteById(id);
    }

    @Override
    public List<Hospital> getAllHospitalsWithCapacityMoreThanOneFifty() {
        return hospitalRepository.getAllHospitalsWithACapacityMoreThanOneFifty();
    }

    @Override
    public Hospital getLargestHospital() {
        return hospitalRepository.getTheLargestHospital();
    }

    @Override
    public List<Hospital> getAllHospitalsWithGivenCapacityAndBuiltInAGivenYear(Integer capacity, Integer year) {
        return hospitalRepository.getHospitalsByCapacityAndYearBuilt(capacity,year);
    }
}
