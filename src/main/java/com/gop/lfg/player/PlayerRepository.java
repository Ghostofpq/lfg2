package com.gop.lfg.player;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
interface PlayerRepository extends MongoRepository<PlayerDTO, String> {
}
