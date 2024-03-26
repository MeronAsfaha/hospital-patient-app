package edu.miu.cs.cs544.controllers;

import edu.miu.cs.cs544.entities.Patient;
import edu.miu.cs.cs544.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;


    @GetMapping("/{id}/message")
    public void sendMessage(@PathVariable Long id){
        patientService.sendPatientName(id);
    }

    @GetMapping("/{name}")
    public ResponseEntity<?> findByName(@PathVariable String name){
        return new ResponseEntity<>(patientService.getByName(name), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> addNewPatient(@RequestBody Patient patient){
        return new ResponseEntity<>(patientService.save(patient),HttpStatus.ACCEPTED);
    }
    @PutMapping("")
    public ResponseEntity<?> updateExistingPatient(@RequestBody Patient patient){
        try {
            return new ResponseEntity<>(patientService.updateExistingPatient(patient),HttpStatus.OK);
        }catch (RuntimeException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPatientById(@PathVariable Long id){
        try{
            return new ResponseEntity<>(patientService.getPatientById(id),HttpStatus.OK);
        }catch (RuntimeException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("")
    public ResponseEntity<?> getAllPatients(){
        return new ResponseEntity<>(patientService.getAllPatients(),HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePatient(@PathVariable Long id){
        patientService.deletePatient(id);
        return new ResponseEntity<>("patient deleted",HttpStatus.OK);
    }
}
