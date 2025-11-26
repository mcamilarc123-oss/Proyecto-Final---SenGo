

package sengo;
import java.util.HashMap;
import java.util.ArrayList;


 

public class SistemaGestion {
    
    private String usuario;
    private ArrayList<Tarea> tareasDisponibles;
    private ArrayList<Notificacion> notificaciones;
    
   
    public SistemaGestion() {
        this.tareasDisponibles = new ArrayList<>();
        this.notificaciones = new ArrayList<>();
    }
    
    
    public boolean registrarUsuario(Usuario usuario) {
        
        return true;
    }
    
    public Usuario iniciarSesion(String cedula, String clave) {
        
        return null;
    }
    
    public void publicarTarea(Tarea tarea) {
        tareasDisponibles.add(tarea);
        notificarNuevaTarea(tarea);
    }
    
    public ArrayList<Tarea> obtenerTareasDisponiblesPorZona(String zona) {
        ArrayList<Tarea> tareasFiltradas = new ArrayList<>();
        for (Tarea tarea : tareasDisponibles) {
            if (tarea.getEstado() == EstadoTarea.DISPONIBLE) {
                tareasFiltradas.add(tarea);
            }
        }
        return tareasFiltradas;
    }
    
    public boolean asignarTarea(Tarea tarea, AdultoMayor adultoMayor) {
        if (tarea.getEstado() == EstadoTarea.DISPONIBLE && 
            adultoMayor.isValidado()) {
            tarea.asignarAdultoMayor(adultoMayor);
            tareasDisponibles.remove(tarea);
            return true;
        }
        return false;
    }
    
    
    private void notificarNuevaTarea(Tarea tarea) {
        
        System.out.println("Nueva tarea disponible: " + tarea.obtenerDescripcionCompleta());
    }
    
    public void enviarNotificacion(String titulo, String mensaje, 
                                   String tipo, Usuario destinatario) {
        Notificacion notif = new Notificacion(titulo, mensaje, destinatario, tipo);
        notificaciones.add(notif);
    }
    
    public ArrayList<Notificacion> obtenerNotificacionesUsuario(Usuario usuario) {
        ArrayList<Notificacion> notifUsuario = new ArrayList<>();
        
        return notifUsuario;
    }
}
