package br.edu.infnet.andressa_guerra_dr1_at.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/private")
public class PrivateUsuarioController {

    @GetMapping("/area-restrita")
    public String areaRestrita() {
        return "Usuário está logado e com acesso à área restrita e protegida por senha da API.";
    }
}
