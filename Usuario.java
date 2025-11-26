
package com.cami.sengo.entidades;

import java.util.ArrayList;

/**
 *
 * @author cami
 */
public class Usuario {
   
    public String cedula;
    public String clave;
    public String nombre;
    public String telefono;
    public String email;
    private final boolean activo;
    

    public Usuario(String cedula, String clave, String nombre) {
        this.cedula = cedula;
        this.clave = clave;
        this.nombre = nombre;
        this.activo = true;
    }
    
    
    public String getCedula() {
        return cedula;
    }
    
    public boolean validarClave(String clave) {
        return this.clave.equals(clave);
    }
    
    public void setClave(String nuevaClave) {
        if (nuevaClave.length() == 4) {
            this.clave = nuevaClave;
        }
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getTipoUsuario() {
        return "Usuario";
    }
    
    public ArrayList<Notificacion> obtenerNotificacionesUsuario(Usuario usuario) {
        
        return new ArrayList<>();
    }
}
