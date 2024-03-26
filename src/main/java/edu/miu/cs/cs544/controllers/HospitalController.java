package edu.miu.cs.cs544.controllers;

import edu.miu.cs.cs544.entities.Hospital;
import edu.miu.cs.cs544.services.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/hospitals")
public class HospitalController {
    @Autowired
    private HospitalService hospitalService;

    @GetMapping("")
    public ResponseEntity<?> getAllHospitals(){
        return new ResponseEntity<>(hospitalService.getAllHospitals(), HttpStatus.OK);
    }

    @GetMapping("/yearandcapacity")
    public ResponseEntity<?> getAllHospitalsWithGivenCapacityAndBuiltYear(
            @RequestParam Integer capacity, @RequestParam Integer year){
        return new ResponseEntity<>(hospitalService.getAllHospitalsWithGivenCapacityAndBuiltInAGivenYear(capacity,year),
        HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getHospitalById(@PathVariable Long id){
        try{
            return new ResponseEntity<>(hospitalService.getHospitalById(id),HttpStatus.OK);
        }catch (RuntimeException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("")
    public ResponseEntity<?> addNewHospital(@RequestBody Hospital hospital){
        return new ResponseEntity<>(hospitalService.save(hospital),HttpStatus.ACCEPTED);
    }

    @PutMapping("")
    public ResponseEntity<?> updateExistingHospital(@RequestBody Hospital hospital){
        try {
            return new ResponseEntity<>(hospitalService.updateExistingHospital(hospital),HttpStatus.OK);
        }catch (RuntimeException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteHospital(@PathVariable Long id){
        hospitalService.deleteHospital(id);
        return new ResponseEntity<>("Hospital deleted", HttpStatus.OK);
    }

}
