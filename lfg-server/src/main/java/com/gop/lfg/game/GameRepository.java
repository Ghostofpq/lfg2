package com.gop.lfg.game;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
interface GameRepository extends MongoRepository<GameDTO, String> {
}
