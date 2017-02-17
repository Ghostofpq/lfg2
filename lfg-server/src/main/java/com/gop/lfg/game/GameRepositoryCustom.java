package com.gop.lfg.game;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface GameRepositoryCustom {
    List<GameDTO> findGames(final String name, final int page, final int size);
}
