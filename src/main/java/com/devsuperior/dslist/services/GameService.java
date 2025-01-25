package com.devsuperior.dslist.services;

import java.util.List;

import com.devsuperior.dslist.repositories.GameRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.dto.GameDTO;

@Service //Responsável por registrar o GameService como componente do sistema;
public class GameService {

    @Autowired
    private GameRepository gameRepository; // Injetando uma instância do gameRepository no GameService;

    @Transactional(readOnly = true) // Garante que vai obedecer os padrões das transações, ACID: Atômica, consistente, isolada e durável;
    public GameDTO findById(Long id) {
        Game result = gameRepository.findById(id).get();
        return new GameDTO(result);
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll() {
        List<Game> result = gameRepository.findAll(); // Gera uma consulta no BD para buscar todos os games, automaticamente será converida para uma lista de games;
        return result.stream().map(x -> new GameMinDTO(x)).toList(); //Transforma uma lista que era de Game para GameMinDTO
    }
}
