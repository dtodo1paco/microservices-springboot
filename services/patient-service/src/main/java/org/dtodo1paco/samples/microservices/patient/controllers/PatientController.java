/**
 * 
 */
package org.dtodo1paco.samples.microservices.patient.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.dtodo1paco.samples.microservices.patient.domain.Patient;
import org.dtodo1paco.samples.microservices.patient.exceptions.NotFoundException;
import org.dtodo1paco.samples.microservices.patient.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author pac
 *
 */
@RestController
public class PatientController {

    private final PatientRepository patientRepository;

    @Autowired
    public PatientController(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }
    
    @GetMapping("/patients/{id}")
    public Patient getPatient(@PathVariable("id") Long id) {
        // return patientRepository.findById(id);
        return patientRepository.findById(id).orElseThrow(
    		() -> new NotFoundException(String.format("Patient %d not found", id)));
    }
    @GetMapping("/patients")
    public List<Patient> getPatients() {
    	List<Patient> list = new ArrayList<>();
    	patientRepository.findAll().forEach(list::add);
        return list;
    }
    @GetMapping("/patients/area/{id}")
    public List<Patient> getPatients(@PathVariable("id") Long areaId) {
        return patientRepository.findByHospitalAreaId(areaId);
    }
    
    @PostMapping("/patients")
    public Patient addPatient(@RequestBody Patient patient) {
        return patientRepository.save(patient);
    }
}