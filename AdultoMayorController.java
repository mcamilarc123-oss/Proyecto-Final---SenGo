
package com.cami.sengo.controlador;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.cami.sengo.entidades.AdultoMayor;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author cami
 */
@RestController
@RequestMapping("/adultos")
public class AdultoMayorController {
    
    List<AdultoMayor> viejitos = new ArrayList<>();
   
    @GetMapping("/ListarTodos")
    public List<AdultoMayor> listarTodos (){
        return this.viejitos;
    }

    @GetMapping("/buscar")
    public List<AdultoMayor> buscarAdulto (@RequestParam String cedula){
        List<AdultoMayor> encontrados = new ArrayList<>();
        
        for (AdultoMayor a:viejitos) {
            if (a.cedula.equals(cedula)) {
                encontrados.add(a);
            }
        }
        
        return encontrados;
    }
    
    @PostMapping("/insertar")
    public String crearUsuario(@RequestBody AdultoMayor adulto) {
        this.viejitos.add(adulto);
        
        return ("insertado correctamente");
    }
    
    @DeleteMapping("/borrar")
    public String crearUsuario(@RequestParam String cedula) {
        
        for (AdultoMayor a:viejitos) {
            if (a.cedula.equals(cedula)) {
                viejitos.remove(a);
                
                return ("eliminado correctamente");
            }
        }
        
        return ("No se encontró la cédula");
    }
}
