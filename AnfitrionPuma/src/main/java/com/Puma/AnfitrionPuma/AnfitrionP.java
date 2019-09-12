package com.Puma.AnfitrionPuma;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class AnfitrionP {
    private @Id @GeneratedValue Long id;
    private String nombre;
    private String email;
    private int telefono;
    private String ci;


    AnfitrionP() {}

    AnfitrionP(String nombre, String email, int telefono, String ci) {
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.ci = ci;

    }

}
