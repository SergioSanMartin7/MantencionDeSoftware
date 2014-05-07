/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CapaClases;

/**
 *
 * @author Serginho
 */
public class Alumno {
    private String rut, nombre, direccion, comuna, carrera;
    private int edad;

    public Alumno() {
        this.rut = "";
        this.nombre = "";
        this.direccion = "";
        this.comuna = "";
        this.edad = 0;
        this.carrera = "";
    }

    public Alumno(String rut, String nombre, String direccion, String comuna, int edad, String carrera) {
        this.rut = rut;
        this.nombre = nombre;
        this.direccion = direccion;
        this.comuna = comuna;
        this.edad = edad;
        this.carrera = carrera;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
    
    
}
