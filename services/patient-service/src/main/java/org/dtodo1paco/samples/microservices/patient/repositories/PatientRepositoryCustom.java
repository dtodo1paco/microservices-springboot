/**
 * 
 */
package org.dtodo1paco.samples.microservices.patient.repositories;

import java.util.List;

import org.dtodo1paco.samples.microservices.patient.domain.Patient;

/**
 * @author pac
 *
 */
public interface PatientRepositoryCustom {
	List<Patient> getPatientsByHospitalArea(Long id);
}
