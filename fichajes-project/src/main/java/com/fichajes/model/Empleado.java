package com.fichajes.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String dni;

    private String nombre;

    private String email;

    private String departamento;

    @JsonIgnore
    @OneToMany(mappedBy = "empleado")
    private List<Fichaje> fichajes;

    // CONSTRUCTOR VACÍO
    public Empleado() {
    }

    // CONSTRUCTOR COMPLETO
    public Empleado(Long id,
                    String dni,
                    String nombre,
                    String email,
                    String departamento) {

        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.email = email;
        this.departamento = departamento;
    }

    // GETTERS Y SETTERS

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public List<Fichaje> getFichajes() {
        return fichajes;
    }

    public void setFichajes(List<Fichaje> fichajes) {
        this.fichajes = fichajes;
    }
}