package org.dtodo1paco.samples.microservices.hospital.repositories;

import org.dtodo1paco.samples.microservices.hospital.domain.HospitalArea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalAreaRepository extends JpaRepository<HospitalArea, Long> {
}
