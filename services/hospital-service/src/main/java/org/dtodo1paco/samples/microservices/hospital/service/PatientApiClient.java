/**
 * 
 */
package org.dtodo1paco.samples.microservices.hospital.service;

import java.util.Arrays;
import java.util.List;

import org.dtodo1paco.samples.microservices.hospital.domain.Patient;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class PatientApiClient {

	private final RestTemplate restTemplate;
	private static final String PATIENTS_SERVICE = "http://localhost:8081/patients";
	private static final String PATIENTS_BY_AREA_SERVICE = "http://localhost:8081/patients/area/{id}";

	public PatientApiClient(RestTemplateBuilder builder) {
		this.restTemplate = builder.build();
	}

	public ResponseEntity<Patient[]> fetchPatients() {
		return this.restTemplate.getForEntity(PATIENTS_SERVICE, Patient[].class);
	}
	public ResponseEntity<Patient[]> fetchPatientsByArea(Long areaId) {
		return this.restTemplate.getForEntity(PATIENTS_BY_AREA_SERVICE, Patient[].class, areaId);
	}
	@Cacheable("patients")
	public List<Patient> fetchPatientsList(Long areaId) {
		if (areaId != null) {
			return Arrays.asList(fetchPatientsByArea(areaId).getBody());			
		}
		return Arrays.asList(fetchPatients().getBody());
	}
}
