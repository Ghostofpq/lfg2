package com.gop.lfg.game;

import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

public class GameRepositoryImpl implements GameRepositoryCustom {
    @Autowired
    private MongoTemplate mongoTemplate;

    public List<GameDTO> findGames(final String name, final int page, final int size) {
        Query query = new Query();
        query.with(new PageRequest(page, size));
        if (!Strings.isNullOrEmpty(name))
            query.addCriteria(Criteria.where("name").regex(name));
        return mongoTemplate.find(query, GameDTO.class);
    }
}
