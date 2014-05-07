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
public class Administrador {
    private int codigo;
    private String nombre, direccion, comuna, carrera;

    public Administrador() {
        this.codigo = 0;
        this.nombre = "";
        this.direccion = "";
        this.comuna = "";
        this.carrera ="";
    }

    public Administrador(int codigo, String nombre, String carrera, String direccion, String comuna) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.comuna = comuna;
        this.carrera = carrera;
    }

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the comuna
     */
    public String getComuna() {
        return comuna;
    }

    /**
     * @param comuna the comuna to set
     */
    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    /**
     * @return the sucursal
     */
    public String getCarrera() {
        return carrera;
    }

    /**
     * @param carrera
     */
    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getSucursal() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setSucursal(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
