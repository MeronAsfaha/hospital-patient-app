package edu.miu.cs.cs544.repositories;

import edu.miu.cs.cs544.entities.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HospitalRepository extends JpaRepository<Hospital,Long> {
    @Query("select h from Hospital h where h.capacity > 150")
    List<Hospital> getAllHospitalsWithACapacityMoreThanOneFifty();

    @Query("select h from Hospital h order by h.capacity desc limit 1")
    Hospital getTheLargestHospital();

    List<Hospital> getHospitalsByCapacityAndYearBuilt(Integer capacity, Integer year);


}
