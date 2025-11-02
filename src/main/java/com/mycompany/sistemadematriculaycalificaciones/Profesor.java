/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemadematriculaycalificaciones;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author fabiansanchezd
 */
public class Profesor {
    private String id;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String correo;
    private String contrasena; // va a estar encriptada
    private String telefono;
    private String direccion; 
    private ArrayList<String> titulos;
    private ArrayList<String> certificaciones;
    private LocalDate fechaRegistro;
    
    public Profesor(String id,
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

        // validar que cada titulo este entre 5 y 40 caracteres, esto es opcional
        if (titulos != null) {
            for (String titulo: titulos) {
                if (titulo == null || titulo.trim().length() < 5 || titulo.trim().length() > 40) {
                    throw new IllegalArgumentException("Cada titulo debe tener entre 5 y 40 caracteres");
                }
            }
        }
        
        // validar que cada certificacion este entre 5 y 40 caracteres, esto es opcional
        if (certificaciones != null) {
            for (String certificacion: certificaciones) {
                if (certificacion == null || certificacion.trim().length() < 5 || certificacion.trim().length() > 40) {
                    throw new IllegalArgumentException("Cada titulo debe tener entre 5 y 40 caracteres");
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
        this.contrasena = contrasena; //TODO: no guardar la contrasena asi
        this.telefono = telefono;
        this.direccion = direccion;
        this.titulos = titulos;
        this.certificaciones = new ArrayList<>(certificaciones);
        this.fechaRegistro = LocalDate.now(); // fecha actual para el registro

    }

    public void consultarInfo() {
        System.out.println("    INFORMACION DEL PROFESOR");
        System.out.println("ID: " + this.id);
        System.out.println("Nombre completo: " + this.nombre + " " + this.apellido1 + " " + this.apellido2);
        System.out.println("Correo: " + this.correo);
        System.out.println("Telefono: " + this.telefono);
        System.out.println("Direccion: " + this.direccion);
        System.out.println("Fecha de registro: " + this.fechaRegistro);

        if (this.titulos != null && !this.titulos.isEmpty()) {
            System.out.println("\nTitulos:");
            for (int i = 0; i < this.titulos.size(); i++) {
                System.out.println(this.titulos.get(i));
            }
        }

        if (this.certificaciones != null && !this.certificaciones.isEmpty()) {
            System.out.println("\nCertificaciones:");
            for (int i = 0; i < this.certificaciones.size(); i++) {
                System.out.println(this.certificaciones.get(i));
            }
        }
    }
}
