package com.gop.lfg.event;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
interface EventRepository extends MongoRepository<EventDTO,String> {
}
