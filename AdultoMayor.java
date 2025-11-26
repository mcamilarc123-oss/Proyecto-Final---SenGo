
package com.cami.sengo.entidades;

import java.util.ArrayList;

/**
 *
 * @author cami
 */
public class AdultoMayor extends Usuario {
    
    private int edad;
    private String[] disponibilidad;
    private boolean tieneVehiculo;
    private String[] habilidades;
    private String fotoPerfilUrl;
    private String fotoCedulaFrontal;
    private String fotoCedulaTrasera;
    private boolean validado;
    private double calificacionPromedio;
    private int totalTareasRealizadas;
    private ArrayList<String> laboresDisponibles;

    public AdultoMayor( String cedula, String nombre,int edad,  String clave) {
        super(cedula, clave, nombre);
        this.edad = edad;
        this.cedula = cedula;
        this.nombre = nombre;
        this.clave = clave;
    }
   
    public void completarPerfil(int edad, String[] disponibilidad, 
                                boolean tieneVehiculo, String[] habilidades) {
        this.edad = edad;
        this.disponibilidad = disponibilidad;
        this.tieneVehiculo = tieneVehiculo;
        this.habilidades = habilidades;
    }
    
    public void subirFotosCedula(String frontal, String trasera) {
        this.fotoCedulaFrontal = frontal;
        this.fotoCedulaTrasera = trasera;
    }
    
    public void validarIdentidad() {
        if (fotoCedulaFrontal != null && fotoCedulaTrasera != null) {
            this.validado = true;
        }
    }
    
    public void agregarLaborDisponible(String labor) {
        laboresDisponibles.add(labor);
    }
    
    public void actualizarCalificacion(double nuevaCalificacion) {
        calificacionPromedio = ((calificacionPromedio * totalTareasRealizadas) 
                               + nuevaCalificacion) / (totalTareasRealizadas + 1);
        totalTareasRealizadas++;
    }
    
    @Override
    public String getTipoUsuario() {
        return "Adulto Mayor";
    }
    
    public double getCalificacionPromedio() {
        return calificacionPromedio;
    }
    
    public boolean isValidado() {
        return validado;
    }
    
    public void publicarTarea(Tarea tarea) {
        
        System.out.println("Tarea publicada por adulto mayor");
    }
    
    public ArrayList<Tarea> obtenerTareasDisponiblesPorZona(String zona) {
       
        return new ArrayList<>();
    }
    
    public boolean asignarTarea(Tarea tarea, AdultoMayor adultoMayor) {
        
        return true;
    }
}
