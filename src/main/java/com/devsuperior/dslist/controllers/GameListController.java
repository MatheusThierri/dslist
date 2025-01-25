package com.devsuperior.dslist.controllers;

import com.devsuperior.dslist.dto.GameListDTO;
import com.devsuperior.dslist.services.GameListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // Transformando a classe em controladora;
@RequestMapping(value = "/lists") // Configurando o caminho da API;
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @GetMapping // GET para obter os objetos;
    public List<GameListDTO> findAll() {
        return gameListService.findAll();
    }
}
