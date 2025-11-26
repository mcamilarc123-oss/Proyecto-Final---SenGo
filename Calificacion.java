
package com.cami.sengo.entidades;

/**
 *
 * @author cami
 */
public class Calificacion {
    // Atributos privados
    private final double puntaje;
    private final String comentario;
    private final Cliente cliente;
    private final AdultoMayor adultoMayor;
    private final String fecha;
    
    // Constructor
    public Calificacion(double puntaje, String comentario, 
                       Cliente cliente, AdultoMayor adultoMayor) {
        this.puntaje = validarPuntaje(puntaje);
        this.comentario = comentario;
        this.cliente = cliente;
        this.adultoMayor = adultoMayor;
        this.fecha = new java.util.Date().toString();
    }
    
    // Método privado
    private double validarPuntaje(double puntaje) {
        if (puntaje < 1.0) return 1.0;
        if (puntaje > 5.0) return 5.0;
        return puntaje;
    }
    
    // Métodos públicos
    public String obtenerCalificacion() {
        if (puntaje >= 4.5) return "Excelente";
        if (puntaje >= 3.5) return "Muy Bueno";
        if (puntaje >= 2.5) return "Bueno";
        if (puntaje >= 1.5) return "Regular";
        return "Necesita Mejorar";
    }
    
    public double getPuntaje() {
        return puntaje;
    }
    
    public String getComentario() {
        return comentario;
    }
}
