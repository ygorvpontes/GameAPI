package com.curso.gameapi.dto;

import com.curso.gameapi.models.Player;

public class PlayerMapper {

    public static Player toEntity(PlayerRequest request) {
        Player player = new Player();
        player.setNome(request.nome());
        // O jogo favorito será atribuído no Controller
        return player;
    }

    public static PlayerResponse toResponse(Player player) {
        String gameTitle = (player.getGameFav() != null) ? player.getGameFav().getTitulo() : null;
        return new PlayerResponse(
                player.getIdPlayer(),
                player.getNome(),
                gameTitle
        );
    }
}