package com.fichajes.service;

import com.fichajes.model.Empleado;
import com.fichajes.model.Fichaje;
import com.fichajes.repository.FichajeRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class FichajeService {

    private final FichajeRepository fichajeRepository;

    public FichajeService(FichajeRepository fichajeRepository) {
        this.fichajeRepository = fichajeRepository;
    }

    // OBTENER TODOS
    public List<Fichaje> obtenerTodos() {
        return fichajeRepository.findAll();
    }

    // OBTENER POR ID
    public Fichaje obtenerPorId(Long id) {
        return fichajeRepository.findById(id).orElse(null);
    }

    // GUARDAR
    public Fichaje guardar(Fichaje fichaje) {
        return fichajeRepository.save(fichaje);
    }

    // ELIMINAR
    public void eliminar(Long id) {
        fichajeRepository.deleteById(id);
    }

    // BUSCAR POR EMPLEADO Y FECHAS
    public List<Fichaje> buscarPorEmpleadoYFechas(
            Empleado empleado,
            LocalDate inicio,
            LocalDate fin
    ) {

        return fichajeRepository
                .findByEmpleadoAndFechaHoraBetween(
                        empleado,
                        inicio.atStartOfDay(),
                        fin.atTime(23, 59, 59)
                );
    }
}