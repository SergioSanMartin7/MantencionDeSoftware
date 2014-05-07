/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CapaMetodos;
import CapaConexion.ConexionSQL;
import CapaClases.Administrador;
import CapaClases.Alumno;
import CapaClases.Usuario;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Serginho
 */
public class Metodos {
    
    private ConexionSQL cnn;
    
    public Metodos(){
          this.cnn = new ConexionSQL();
    }
    
    private void configurarConexion(String tabla){
        cnn.setNombreBaseDatos("redbanc");
        cnn.setDriver("com.mysql.jdbc.Driver");
        cnn.setUrl("jdbc:mysql://localhost:3306/redbanc");
        cnn.setNombreTabla(tabla);
        cnn.setUser("root");
        cnn.setPassword("123456");
    }
    
    //CLIENTE
    public void ingresarCliente(Alumno cl){
        this.configurarConexion("cliente");
        cnn.setEsSelect(false);
        
        cnn.setSentenciaSQL("insert into " + cnn.getNombreTabla() + " values('" +
                cl.getRut() + "','" +
                cl.getNombre() + "',"+
                cl.getEdad()+",'"+
                cl.getDireccion() + "','"+
                cl.getComuna() + "')");
        
        System.out.println("SQL: " + cnn.getSentenciaSQL());
        cnn.conectar();
        cnn.cerrarConexion();
    }
    
    public void eliminarCliente(String rut){
        
        this.configurarConexion("cliente");
        cnn.setEsSelect(false);
        
        cnn.setSentenciaSQL("delete from " + cnn.getNombreTabla() + " where rut='" + rut + "'");
        
        System.out.println("SQL: " + cnn.getSentenciaSQL());
        cnn.conectar();
        cnn.cerrarConexion();
        
        
    }
    
    public Alumno buscarCliente(String rut)
    {
        Alumno cl = new Alumno();
        this.configurarConexion("cliente");
        
        cnn.setEsSelect(true); 
               
        cnn.setSentenciaSQL("select * from " + cnn.getNombreTabla()
                + "  where rut='" + rut + "'");
                
        System.out.println("SQL: " + cnn.getSentenciaSQL());
                
        cnn.conectar();
        
        try {
            if(cnn.getRst().next())
                {
                    cl.setRut(cnn.getRst().getString("rut"));
                    cl.setNombre(cnn.getRst().getString("nombre"));
                    cl.setEdad(cnn.getRst().getInt("edad"));
                    cl.setDireccion(cnn.getRst().getString("direccion"));
                    cl.setComuna(cnn.getRst().getString("comuna"));
                }
            else
            {
                cl.setRut("");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        cnn.cerrarConexion();
        return cl;
    }
    
     public void modificarCliente(Alumno cl){
        this.configurarConexion("cliente");
        cnn.setEsSelect(false);
        
        cnn.setSentenciaSQL("update " + this.cnn.getNombreTabla() + " set nombre='" + cl.getNombre() + "', edad=" +
                cl.getEdad() + ",direccion='" +
                cl.getDireccion() + "',comuna='" +
                cl.getComuna() + 
                "' where rut='" + cl.getRut()+ "'");
        
        System.out.println("SQL: " + cnn.getSentenciaSQL());
        cnn.conectar();
        cnn.cerrarConexion();
    }
    
    
    //USUARIO
    
    public void ingresarUsuario(Usuario us){
        this.configurarConexion("usuario");
        cnn.setEsSelect(false);
        
        cnn.setSentenciaSQL("insert into " + cnn.getNombreTabla() + " values('" +
                us.getRut() + "','" +
                us.getContraseña() + "')");
       
        System.out.println("SQL: " + cnn.getSentenciaSQL());
        cnn.conectar();
        cnn.cerrarConexion();
    }
    
    public void eliminarUsuario(String rut){
        
        this.configurarConexion("usuario");
        cnn.setEsSelect(false);
        
        cnn.setSentenciaSQL("delete from " + cnn.getNombreTabla() + " where rut='" + rut + "'");
        
        System.out.println("SQL: " + cnn.getSentenciaSQL());
        cnn.conectar();
        cnn.cerrarConexion();
    }
    
    public Usuario buscarUsuario(String rut){
        Usuario us = new Usuario("");
        this.configurarConexion("usuario");
        
         cnn.setEsSelect(true);
        
        
        cnn.setSentenciaSQL("select * from " + cnn.getNombreTabla()
                + "  where rut='" + rut + "'"); 
                
        System.out.println("SQL: " + cnn.getSentenciaSQL());
                
        cnn.conectar();
        
        try {
            if(cnn.getRst().next())
                {
                    us.setRut(cnn.getRst().getString("rut"));
                    us.setContraseña(cnn.getRst().getString("contraseña"));
                }
            else
            {
                us.setRut("");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        cnn.cerrarConexion();
        return us;
    }
    
    //BANCO
    
    public void ingresarBanco(Administrador bn){
        this.configurarConexion("banco");
        cnn.setEsSelect(false);
        
        cnn.setSentenciaSQL("insert into " + cnn.getNombreTabla() + " values(" +
                bn.getCodigo() + ",'" +
                bn.getNombre() + "','"+
                bn.getSucursal()+"','"+
                bn.getDireccion() + "','"+
                bn.getComuna() + "')");
        
        System.out.println("SQL: " + cnn.getSentenciaSQL());
        cnn.conectar();
        cnn.cerrarConexion();
    }
    
    public void eliminarBanco(int codigo){
        
        this.configurarConexion("banco");
        cnn.setEsSelect(false);
        
        cnn.setSentenciaSQL("delete from " + cnn.getNombreTabla() + " where codigo=" + codigo + "");
        
        System.out.println("SQL: " + cnn.getSentenciaSQL());
        cnn.conectar();
        cnn.cerrarConexion();
        
        
    }
    
    public Administrador buscarBanco(int codigo)
    {
        Administrador bn = new Administrador();
        this.configurarConexion("banco");
        
        cnn.setEsSelect(true); 
               
        cnn.setSentenciaSQL("select * from " + cnn.getNombreTabla()
                + "  where codigo=" + codigo + "");
                
        System.out.println("SQL: " + cnn.getSentenciaSQL());
                
        cnn.conectar();
        
        try {
            if(cnn.getRst().next())
                {
                    bn.setCodigo(cnn.getRst().getInt("codigo"));
                    bn.setNombre(cnn.getRst().getString("nombre"));
                    bn.setSucursal(cnn.getRst().getString("sucursal"));
                    bn.setDireccion(cnn.getRst().getString("direccion"));
                    bn.setComuna(cnn.getRst().getString("comuna"));
                }
            else
            {
                bn.setCodigo(0);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        cnn.cerrarConexion();
        return bn;
    }
    
     public void modificarBanco(Administrador bn){
        this.configurarConexion("banco");
        cnn.setEsSelect(false);
        
        cnn.setSentenciaSQL("update " + this.cnn.getNombreTabla() + " set nombre='" + bn.getNombre() + "', sucursal='" +
                bn.getSucursal() + "',direccion='" +
                bn.getDireccion() + "',comuna='" +
                bn.getComuna()+ 
                "' where codigo=" + bn.getCodigo()+ "");
        
        System.out.println("SQL: " + cnn.getSentenciaSQL());
        cnn.conectar();
        cnn.cerrarConexion();
    }
    
}
