/**
 * 
 */
package org.dtodo1paco.samples.microservices.hospital.service;

import java.util.List;

import org.dtodo1paco.samples.microservices.hospital.domain.HospitalArea;
import org.dtodo1paco.samples.microservices.hospital.domain.Patient;
import org.dtodo1paco.samples.microservices.hospital.exceptions.NotFoundException;
import org.dtodo1paco.samples.microservices.hospital.repositories.HospitalAreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author pac
 *
 */
@Service
public class HospitalAreaService {
/*
    @Autowired
    private CacheManager cacheManager;
*/
    @Autowired
    private PatientApiClient patientApiClient;

    private final HospitalAreaRepository hospitalRepository;
    @Autowired
    public HospitalAreaService(HospitalAreaRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }
    public HospitalArea getHospitalArea(Long id) {
        return hospitalRepository.findById(id).orElseThrow(
    		() -> new NotFoundException(String.format("HospitalArea %d not found", id)));
    }
    public List<HospitalArea> getHospitalAreas() {
        return hospitalRepository.findAll();
    }
    
    public HospitalArea addHospitalArea(HospitalArea hospitalArea) {
        return hospitalRepository.save(hospitalArea);
    }
    
    public List<Patient> getPatients(HospitalArea hospitalArea) {
    	return patientApiClient.fetchPatientsList(hospitalArea.getId());
    }
    
}
