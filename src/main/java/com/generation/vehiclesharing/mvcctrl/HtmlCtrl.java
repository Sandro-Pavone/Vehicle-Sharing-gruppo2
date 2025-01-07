package com.generation.vehiclesharing.mvcctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HtmlCtrl {

    @GetMapping("/index") // Modificato da /home a /index
    public String home() {
        return "index";
    }

    @GetMapping("/inserisci")
    public String inserisci() {
        return "inserisci";
    }

    @GetMapping("/veicoli")
    public String veicoli() {
        return "veicolo";
    }

    @GetMapping("/prenota")
    public String prenota() {
        return "prenota";
    }

    // Metodo rimosso per evitare conflitti con LoginController
    // @GetMapping("/prova3")
    // public String prova3() {
    //     return "prova3";
    // }
}

