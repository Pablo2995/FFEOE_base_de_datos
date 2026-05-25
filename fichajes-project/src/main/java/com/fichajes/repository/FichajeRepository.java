package com.fichajes.repository;

import com.fichajes.model.Empleado;
import com.fichajes.model.Fichaje;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface FichajeRepository extends JpaRepository<Fichaje, Long> {

    List<Fichaje> findByEmpleado(Empleado empleado);

    List<Fichaje> findByEmpleadoAndFechaHoraBetween(
            Empleado empleado,
            LocalDateTime inicio,
            LocalDateTime fin
    );
}