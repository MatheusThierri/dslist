package com.devsuperior.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.devsuperior.dslist.entities.Game;
import org.springframework.data.jpa.repository.Query;
import com.devsuperior.dslist.projections.GameMinProjection;
import java.util.List;

public interface GameRepository extends JpaRepository<Game, Long> { // Interface responsável por fazer a consulta, inserir, deletar no banco de dados;
    // Query responsável por retornar os games de uma determinada lista;
    @Query(nativeQuery = true, value = """
		SELECT tb_game.id, tb_game.title, tb_game.game_year AS gameYear, tb_game.img_url AS imgUrl,
		tb_game.short_description AS shortDescription, tb_belonging.position
		FROM tb_game
		INNER JOIN tb_belonging ON tb_game.id = tb_belonging.game_id
		WHERE tb_belonging.list_id = :listId
		ORDER BY tb_belonging.position
		""") // nativeQuery é usado para quando fazer uma consulta diretamente em SQL e não JPQL;
        List<GameMinProjection> searchByList(Long listId); // Passando o listID como parâmetro para a query SQL;
}
