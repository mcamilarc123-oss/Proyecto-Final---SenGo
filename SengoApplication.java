package com.cami.sengo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SengoApplication {
    
    
    @GetMapping("/")
    public String hola (){
      return "bien";
    }
    
    @GetMapping("/error")
    public String Error (){
        return "Algo falló al gestionar la petición";
    }
    

    public static void main(String[] args) {
            SpringApplication.run(SengoApplication.class, args);
    }

}
