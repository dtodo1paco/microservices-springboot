/**
 * 
 */
package org.dtodo1paco.samples.microservices.hospital.controllers;

import java.util.List;

import org.dtodo1paco.samples.microservices.hospital.domain.HospitalArea;
import org.dtodo1paco.samples.microservices.hospital.domain.Patient;
import org.dtodo1paco.samples.microservices.hospital.service.HospitalAreaService;
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
public class HospitalController {

	@Autowired
	private HospitalAreaService hospitalAreaService; 
	
    @GetMapping("/hospitalArea/{id}/patients")
    public List<Patient> getHospitalAreaPatients(@PathVariable("id") Long id) {
        return hospitalAreaService.getPatients(hospitalAreaService.getHospitalArea(id));
    }
	
    @GetMapping("/hospitalArea/{id}")
    public HospitalArea getHospitalAreas(@PathVariable("id") Long id) {
        return hospitalAreaService.getHospitalArea(id);
    }    
   
    @GetMapping("/hospitalArea")
    public List<HospitalArea> getHospitalAreas() {
        return hospitalAreaService.getHospitalAreas();
    }
   
    @PostMapping("/hospitalArea/add")
    public HospitalArea addHospitalArea(@RequestBody HospitalArea hospitalArea) {
        return hospitalAreaService.addHospitalArea(hospitalArea);
    }
}