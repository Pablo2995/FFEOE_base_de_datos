package com.fichajes;

import com.fichajes.model.CentroTrabajo;
import com.fichajes.model.Empleado;
import com.fichajes.model.Fichaje;

import com.fichajes.repository.CentroTrabajoRepository;
import com.fichajes.repository.EmpleadoRepository;
import com.fichajes.repository.FichajeRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class FichajesApplication {

    public static void main(String[] args) {

        SpringApplication.run(
                FichajesApplication.class,
                args
        );
    }

    @Bean
    CommandLineRunner init(
            EmpleadoRepository empleadoRepo,
            CentroTrabajoRepository centroRepo,
            FichajeRepository fichajeRepo
    ) {

        return args -> {

            // EVITAR DUPLICADOS
            if (empleadoRepo.count() > 0) {
                return;
            }

            // =========================
            // EMPLEADOS
            // =========================

            Empleado e1 = new Empleado(
                    null,
                    "12345678A",
                    "Ana López",
                    "ana@empresa.com",
                    "Sistemas"
            );

            Empleado e2 = new Empleado(
                    null,
                    "87654321B",
                    "Carlos Pérez",
                    "carlos@empresa.com",
                    "Ventas"
            );

            Empleado e3 = new Empleado(
                    null,
                    "11223344C",
                    "Marta Ruiz",
                    "marta@empresa.com",
                    "RRHH"
            );

            empleadoRepo.save(e1);
            empleadoRepo.save(e2);
            empleadoRepo.save(e3);

            // =========================
            // CENTROS
            // =========================

            CentroTrabajo c1 = new CentroTrabajo(
                    null,
                    "Oficina Central",
                    "Calle Mayor 1",
                    "Madrid"
            );

            CentroTrabajo c2 = new CentroTrabajo(
                    null,
                    "Delegación Norte",
                    "Avenida del Mar 45",
                    "Bilbao"
            );

            centroRepo.save(c1);
            centroRepo.save(c2);

            // =========================
            // FICHAJES
            // =========================

            Fichaje f1 = new Fichaje();

            f1.setTipo("ENTRADA");

            f1.setFechaHora(
                    LocalDateTime.now().minusHours(8)
            );

            f1.setEmpleado(e1);

            f1.setCentroTrabajo(c1);

            fichajeRepo.save(f1);

            Fichaje f2 = new Fichaje();

            f2.setTipo("SALIDA");

            f2.setFechaHora(
                    LocalDateTime.now()
            );

            f2.setEmpleado(e1);

            f2.setCentroTrabajo(c1);

            fichajeRepo.save(f2);

            System.out.println("DATOS INSERTADOS");
        };
    }
}