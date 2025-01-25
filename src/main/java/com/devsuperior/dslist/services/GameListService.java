package com.devsuperior.dslist.services;

import com.devsuperior.dslist.dto.GameListDTO;
import com.devsuperior.dslist.entities.GameList;
import com.devsuperior.dslist.repositories.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository; // Injetando uma instância do gameRepository no GameService;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        List<GameList> result = gameListRepository.findAll(); // Gera uma consulta no BD para buscar todos os games, automaticamente será converida para uma lista de games;
        return result.stream().map(x -> new GameListDTO(x)).toList(); //Transforma uma lista que era de Game para GameMinDTO
    }
}
