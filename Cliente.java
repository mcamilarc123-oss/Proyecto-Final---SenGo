/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cami.sengo.entidades;

import java.util.ArrayList;

/**
 *
 * @author cami
 */
public class Cliente extends Usuario {
    
    private ArrayList<Tarea> tareasCreadas;
    private String direccion;
    
    
    public Cliente(String cedula, String clave, String nombre) {
        super(cedula, clave, nombre);
        this.tareasCreadas = new ArrayList<>();
    }
    
   
    public Tarea crearTarea(String descripcion, String tipo, String ubicacion, 
                           String fecha, String hora, double pago) {
        Tarea nuevaTarea = new Tarea(descripcion, tipo, ubicacion, 
                                     fecha, hora, pago, this);
        tareasCreadas.add(nuevaTarea);
        return nuevaTarea;
    }
    
    public void calificarAdultoMayor(Tarea tarea, double calificacion, 
                                     String comentario) {
        if (tarea.getEstado() == EstadoTarea.COMPLETADA) {
            Calificacion calif = new Calificacion(calificacion, comentario, 
                                                  this, tarea.getAdultoMayorAsignado());
            tarea.setCalificacion(calif);
            tarea.getAdultoMayorAsignado().actualizarCalificacion(calificacion);
        }
    }
    
    public ArrayList<Tarea> consultarTareas() {
        return tareasCreadas;
    }
    
    public ArrayList<Tarea> verHistorial() {
        ArrayList<Tarea> historial = new ArrayList<>();
        for (Tarea tarea : tareasCreadas) {
            if (tarea.getEstado() == EstadoTarea.COMPLETADA || 
                tarea.getEstado() == EstadoTarea.CANCELADA) {
                historial.add(tarea);
            }
        }
        return historial;
    }
    
    @Override
    public String getTipoUsuario() {
        return "Cliente";
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
