package com.mycompany.sistemadematriculaycalificaciones;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author fabiansanchezd
 */
public class Estudiante {
    private String id;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String correo;
    private String contrasena; // va a estar encriptada
    private String telefono;
    private String direccion; 
    private String organizacion;
    private ArrayList<String> intereses;
    private LocalDate fechaRegistro;
    
    public Estudiante(String id,
        String nombre,
        String apellido1,
        String apellido2,
        String correo,
        String contrasena,
        String telefono,
        String direccion,
        String organizacion,
        ArrayList<String> intereses) {

        // la mayoria tiene null para validar de una vez que se manden todos los datos, sino excepcion
        // nombre entre 2 y 20 caracteres
        if (nombre == null || nombre.trim().length() < 2 || nombre.trim().length() > 20) {
            throw new IllegalArgumentException("El nombre debe tener entre 2 y 20 caracteres");
        }

        // apellido1 entre 2 y 20 caracteres
        if (apellido1 == null || apellido1.trim().length() < 2 || apellido1.trim().length() > 20) {
            throw new IllegalArgumentException("El primer apellido debe tener entre 2 y 20 caracteres");
        }

        // apellido2 entre 2 y 20 caracteres
        if (apellido2 == null || apellido2.trim().length() < 2 || apellido2.trim().length() > 20) {
            throw new IllegalArgumentException("El segundo apellido debe tener entre 2 y 20 caracteres");
        }

        // id mayor a 9 caracteres
        if (id == null || id.trim().length() < 9) {
            throw new IllegalArgumentException("La identificacion debe tener al menos 9 caracteres");
        }

        // telefono mayor a 8 caracteres
        if (telefono == null || telefono.trim().length() < 8) {
            throw new IllegalArgumentException("El telefono debe tener al menos 8 caracteres");
        }

        // correo sin espacios
        if (correo == null || correo.contains(" ")) {
            throw new IllegalArgumentException("El correo no puede estar vacio ni contener espacios");
        }
        // correo tiene arroba
        if (!correo.contains("@")) {
            throw new IllegalArgumentException("El correo debe contener el simbolo @");
        }
        String[] partesCorreo = correo.split("@");
        // verificar que las 2 partes del correo sean mayores a 3 caracteres
        if (partesCorreo.length != 2 || partesCorreo[0].length() < 3 || partesCorreo[1].length() < 3) {
            throw new IllegalArgumentException("El correo debe tener el formato parte1@parte2 y ambas partes con mas de 3 caracteres");
        }

        // direccion entre 5 y 60 caracteres
        if (direccion == null || direccion.trim().length() < 5 || direccion.trim().length() > 60) {
            throw new IllegalArgumentException("La direccion debe tener entre 5 y 60 caracteres");
        }

        // organizacion menor a 40 caracteres, esta es opcional
        if (organizacion != null && organizacion.trim().length() > 40) {
            throw new IllegalArgumentException("La organizacion no puede tener mas de 40 caracteres");
        }

        // validar que cada tema de interes este entre 5 y 30 caracteres, esto es opcional
        if (intereses != null) {
            for (String tema: intereses) {
                if (tema == null || tema.trim().length() < 5 || tema.trim().length() > 30) {
                    throw new IllegalArgumentException("Cada tema de interes debe tener entre 5 y 30 caracteres");
                }
            }
        }

        // contrasena no vacia
        // TODO: implementar logica de encriptacion de contra, validaciones extra
        if (contrasena == null || contrasena.trim().isEmpty()) {
            throw new IllegalArgumentException("La contraseña no puede estar vacía");
        }

        this.id = id;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.correo = correo;
        this.contrasena = contrasena;
        this.telefono = telefono;
        this.direccion = direccion;
        this.organizacion = organizacion;
        this.intereses = new ArrayList<>(intereses);
        this.fechaRegistro = LocalDate.now(); // fecha actual para el registro
    
    }
}