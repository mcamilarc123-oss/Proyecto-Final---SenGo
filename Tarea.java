
package com.cami.sengo.entidades;

/**
 *
 * @author cami
 */
public class Tarea {
  
    private final String id;
    private final String tipo;
    private final String ubicacion;
    private final String fecha;
    private final String hora;
    private EstadoTarea estado;
    private final Cliente cliente;
    private AdultoMayor adultoMayorAsignado;
    private String fechaCreacion;
    
    // Constructor
    public Tarea(String descripcion, String tipo, String ubicacion, 
                 String fecha, String hora, double pago, Cliente cliente) {
        this.id = generarId();
        this.tipo = tipo;
        this.ubicacion = ubicacion;
        this.fecha = fecha;
        this.hora = hora;
        this.cliente = cliente;
        this.estado = EstadoTarea.DISPONIBLE;
        this.fechaCreacion = obtenerFechaActual();
    }
    
    
    private String generarId() {
        return "TAREA-" + System.currentTimeMillis();
    }
    
    private String obtenerFechaActual() {
        return new java.util.Date().toString();
    }
    
    
    public void asignarAdultoMayor(AdultoMayor adultoMayor) {
        this.adultoMayorAsignado = adultoMayor;
        this.estado = EstadoTarea.ACEPTADA;
    }
    
    public void iniciarTarea() {
        if (estado == EstadoTarea.ACEPTADA) {
            this.estado = EstadoTarea.EN_PROCESO;
        }
    }
    
    public void completarTarea() {
        if (estado == EstadoTarea.EN_PROCESO) {
            this.estado = EstadoTarea.COMPLETADA;
        }
    }
    
    public String obtenerDescripcionCompleta() {
        return tipo + " en " + ubicacion + " - " + fecha + " a las " + hora;
    }
    
    public String getId() {
        return id;
    }
    
    public EstadoTarea getEstado() {
        return estado;
    }
    
    public AdultoMayor getAdultoMayorAsignado() {
        return adultoMayorAsignado;
    }
    
    public void setCalificacion(Calificacion calificacion) {
    }
    
    public Cliente getCliente() {
        return cliente;
    }
}
