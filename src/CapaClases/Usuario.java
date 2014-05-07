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
public class Usuario extends Alumno{
    private String contraseña;

    public Usuario(String contraseña) {
        this.contraseña = contraseña;
    }

    public Usuario(String contraseña, String rut, String nombre, String direccion, String comuna, int edad, String carrera) {
        super(rut, nombre, direccion, comuna, edad, carrera);
        this.contraseña = contraseña;
    }

    /**
     * @return the contraseña
     */
    public String getContraseña() {
        return contraseña;
    }

    /**
     * @param contraseña the contraseña to set
     */
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
    
}
