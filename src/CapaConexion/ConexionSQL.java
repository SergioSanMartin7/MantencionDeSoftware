/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CapaConexion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Serginho
 */
public class ConexionSQL {
    
    private String nombreBaseDatos;
    private String nombreTabla;
    private String sentenciaSQL;
    private String driver;
    private String url;
    private String user;
    private String password;
    private boolean esSelect;//ejecutar query o update
    
    private Connection cnn;
    private Statement stm;
    private ResultSet rst;

    public ConexionSQL(){ 
        this.nombreBaseDatos = "";
        this.nombreTabla = "";
        this.sentenciaSQL = "";
        this.driver = "";
        this.url = "";
        this.user = "";
        this.password = "";
        this.esSelect = false;
    }

    public ConexionSQL(String nombreBaseDatos, String nombreTabla, String sentenciaSQL, String driver, String url, String user, String password, boolean esSelect) {
        this.nombreBaseDatos = nombreBaseDatos;
        this.nombreTabla = nombreTabla;
        this.sentenciaSQL = sentenciaSQL;
        this.driver = driver;
        this.url = url;
        this.user = user;
        this.password = password;
        this.esSelect = esSelect;
    }

    /**
     * @return the nombreBaseDatos
     */
    public String getNombreBaseDatos() {
        return nombreBaseDatos;
    }

    /**
     * @param nombreBaseDatos the nombreBaseDatos to set
     */
    public void setNombreBaseDatos(String nombreBaseDatos) {
        this.nombreBaseDatos = nombreBaseDatos;
    }

    /**
     * @return the nombreTabla
     */
    public String getNombreTabla() {
        return nombreTabla;
    }

    /**
     * @param nombreTabla the nombreTabla to set
     */
    public void setNombreTabla(String nombreTabla) {
        this.nombreTabla = nombreTabla;
    }

    /**
     * @return the sentenciaSQL
     */
    public String getSentenciaSQL() {
        return sentenciaSQL;
    }

    /**
     * @param sentenciaSQL the sentenciaSQL to set
     */
    public void setSentenciaSQL(String sentenciaSQL) {
        this.sentenciaSQL = sentenciaSQL;
    }

    /**
     * @return the driver
     */
    public String getDriver() {
        return driver;
    }

    /**
     * @param driver the driver to set
     */
    public void setDriver(String driver) {
        this.driver = driver;
    }

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the esSelect
     */
    public boolean isEsSelect() {
        return esSelect;
    }

    /**
     * @param esSelect the esSelect to set
     */
    public void setEsSelect(boolean esSelect) {
        this.esSelect = esSelect;
    }

    /**
     * @return the cnn
     */
    public Connection getCnn() {
        return cnn;
    }

    /**
     * @param cnn the cnn to set
     */
    public void setCnn(Connection cnn) {
        this.cnn = cnn;
    }

    /**
     * @return the stm
     */
    public Statement getStm() {
        return stm;
    }

    /**
     * @param stm the stm to set
     */
    public void setStm(Statement stm) {
        this.stm = stm;
    }

    /**
     * @return the rst
     */
    public ResultSet getRst() {
        return rst;
    }

    /**
     * @param rst the rst to set
     */
    public void setRst(ResultSet rst) {
        this.rst = rst;
    }
    
    public void cerrarConexion(){
        
        try
        {
            this.cnn.close();
        }catch(SQLException ex)
        {
            Logger.getLogger(ConexionSQL.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    
    
    //Metodo Principal para la conexion
    public void conectar(){
        
        try
        {
            Class.forName(this.getDriver());
            
        }catch(ClassNotFoundException ex)
        {
            Logger.getLogger(ConexionSQL.class.getName()).log(Level.SEVERE,null,ex);
            return; //se detiene y tira el mensaje de error
        }
        
        try{
            
            //Crear Conexion
            this.setCnn(DriverManager.getConnection(this.getUrl(), this.getUser(), this.getPassword()));
            
            //Crear objeto para ejecutar sentencias SQL
            this.setStm(this.getCnn().createStatement());
        
        }catch(SQLException ex){
            
            Logger.getLogger(ConexionSQL.class.getName()).log(Level.SEVERE,null,ex);
            return;
        }
        
        //Verificar si ejecutar una QUERY o un UPDATE
        if(this.isEsSelect() == true)
        {
            try
            {
                //Ejecutar una QUERY
            this.setRst(this.getStm().executeQuery(this.getSentenciaSQL()));
            
            }catch(SQLException ex)
            {
               Logger.getLogger(ConexionSQL.class.getName()).log(Level.SEVERE,null,ex);
            }
        }
        else
        {
            try
            {
                //ejecutar un UPDATE
                this.getStm().executeUpdate(this.getSentenciaSQL());
            
            }catch(SQLException ex)
            {
               Logger.getLogger(ConexionSQL.class.getName()).log(Level.SEVERE,null,ex);
            }
        }
        
    }
    
    
}
