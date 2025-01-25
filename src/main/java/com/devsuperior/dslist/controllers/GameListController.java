package com.devsuperior.dslist.controllers;

import com.devsuperior.dslist.dto.GameListDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.dto.ReplacementDTO;
import com.devsuperior.dslist.services.GameListService;
import com.devsuperior.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Transformando a classe em controladora;
@RequestMapping(value = "/lists") // Configurando o caminho da API;
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @Autowired
    private GameService gameService;

    @GetMapping // GET para obter os objetos;
    public List<GameListDTO> findAll() {
        return gameListService.findAll();
    }

    @GetMapping(value = "/{listId}/games") // GET para obter os objetos;
    public List<GameMinDTO> findByList(@PathVariable Long listId) {
        return gameService.findByList(listId);
    }

    @PostMapping(value = "/{listId}/replacement") // GET para obter os objetos;
    public void move(@PathVariable Long listId, @RequestBody ReplacementDTO body) { // Recebe o corpo enviado pela API;
        gameListService.move(listId, body.getSourceIndex(), body.getDestinationIndex());
    }
}
