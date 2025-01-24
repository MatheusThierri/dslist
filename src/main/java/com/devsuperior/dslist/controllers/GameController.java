package com.devsuperior.dslist.controllers;

import com.devsuperior.dslist.dto.GameMinDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.services.GameService;
import java.util.List;

@RestController // Transformando a classe em controladora;
@RequestMapping(value = "/games") // Configurando o caminho da API;
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping // GET para obter os objetos;
    public List<GameMinDTO> findAll() {
        return gameService.findAll();
    }
}
