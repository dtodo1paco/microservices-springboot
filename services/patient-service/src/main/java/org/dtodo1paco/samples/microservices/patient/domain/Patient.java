/**
 * 
 */
package org.dtodo1paco.samples.microservices.patient.domain;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author pac
 *
 */
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Patient {
	@Id
	@GeneratedValue
	private Long id;

	private String givenName;
	private String familyName;
	private LocalDate birthDate;
	private Long hospitalAreaId;	

	public Patient() {}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGivenName() {
		return givenName;
	}

	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return Objects.equals(id, patient.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

	public Long getHospitalAreaId() {
		return hospitalAreaId;
	}

	public void setHospitalAreaId(Long hospitalAreaId) {
		this.hospitalAreaId = hospitalAreaId;
	}
}