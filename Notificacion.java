
package com.cami.sengo.entidades;

/**
 *
 * @author cami
 */
public class Notificacion {
    
    private final String id;
    private final String titulo;
    private final String mensaje;
    private final Usuario destinatario;
    private final String fecha;
    private boolean leida;
    private final String tipo;
    
   
    public Notificacion(String titulo, String mensaje, 
                       Usuario destinatario, String tipo) {
        this.id = generarId();
        this.titulo = titulo;
        this.mensaje = mensaje;
        this.destinatario = destinatario;
        this.tipo = tipo;
        this.fecha = new java.util.Date().toString();
        this.leida = false;
    }
    
    
    private String generarId() {
        return "NOTIF-" + System.currentTimeMillis();
    }
    
    
    public void marcarComoLeida() {
        this.leida = true;
    }
    
    public String obtenerMensajeCompleto() {
        return titulo + ": " + mensaje;
    }
    
    public boolean isLeida() {
    return leida;

    }
}

