package org.dtodo1paco.samples.microservices.patient.repositories;

import java.util.List;

import org.dtodo1paco.samples.microservices.patient.domain.Patient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends CrudRepository<Patient, Long> {
	List<Patient> findByHospitalAreaId(Long id);
}
