package com.courzelo.classroom.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.courzelo.classroom.entities.Meeting;

@Repository
public interface MeetingRepository extends MongoRepository<Meeting, Integer> {

}
