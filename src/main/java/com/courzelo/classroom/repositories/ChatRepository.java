package com.courzelo.classroom.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.courzelo.classroom.entities.Chat;

@Repository
public interface ChatRepository extends CrudRepository<Chat, Long> {

}
