package com.gop.lfg.user;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
interface UserRepository extends MongoRepository<UserDTO, String> {
    UserDTO findByLogin( String login);
}