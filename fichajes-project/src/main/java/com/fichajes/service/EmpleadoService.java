package com.fichajes.service;

import com.fichajes.model.Empleado;
import com.fichajes.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    public List<Empleado> listarTodos() {
        return empleadoRepository.findAll();
    }

    public Empleado obtenerPorId(Long id) {
        Optional<Empleado> emp = empleadoRepository.findById(id);
        return emp.orElseThrow(() -> new RuntimeException("Empleado no encontrado con id: " + id));
    }

    public Empleado guardar(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    public void eliminar(Long id) {
        empleadoRepository.deleteById(id);
    }
}
