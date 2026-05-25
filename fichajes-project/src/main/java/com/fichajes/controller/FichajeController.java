package com.fichajes.controller;

import com.fichajes.model.Fichaje;
import com.fichajes.service.FichajeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fichajes")
public class FichajeController {

    private final FichajeService fichajeService;

    public FichajeController(FichajeService fichajeService) {
        this.fichajeService = fichajeService;
    }

    // GET TODOS
    @GetMapping
    public List<Fichaje> obtenerTodos() {
        return fichajeService.obtenerTodos();
    }

    // GET POR ID
    @GetMapping("/{id}")
    public Fichaje obtenerPorId(@PathVariable Long id) {
        return fichajeService.obtenerPorId(id);
    }

    // POST
    @PostMapping
    public Fichaje crear(@RequestBody Fichaje fichaje) {
        return fichajeService.guardar(fichaje);
    }

    // PUT
    @PutMapping("/{id}")
    public Fichaje actualizar(
            @PathVariable Long id,
            @RequestBody Fichaje fichaje
    ) {
        fichaje.setId(id);
        return fichajeService.guardar(fichaje);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        fichajeService.eliminar(id);
    }
}