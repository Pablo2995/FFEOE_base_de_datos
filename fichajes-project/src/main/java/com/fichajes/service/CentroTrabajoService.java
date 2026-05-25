package com.fichajes.service;

import com.fichajes.model.CentroTrabajo;
import com.fichajes.repository.CentroTrabajoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CentroTrabajoService {

    @Autowired
    private CentroTrabajoRepository centroRepository;

    public List<CentroTrabajo> listarTodos() {
        return centroRepository.findAll();
    }

    public CentroTrabajo obtenerPorId(Long id) {

        Optional<CentroTrabajo> centro =
                centroRepository.findById(id);

        return centro.orElseThrow(() ->
                new RuntimeException(
                        "Centro no encontrado con id: " + id
                ));
    }

    public CentroTrabajo guardar(CentroTrabajo centro) {

        return centroRepository.save(centro);
    }

    public void eliminar(Long id) {

        centroRepository.deleteById(id);
    }
}