package com.fichajes.repository;

import com.fichajes.model.CentroTrabajo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CentroTrabajoRepository extends JpaRepository<CentroTrabajo, Long> {
}
