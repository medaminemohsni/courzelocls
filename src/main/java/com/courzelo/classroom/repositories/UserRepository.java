package com.courzelo.classroom.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.courzelo.classroom.entities.User;



@Repository
public interface UserRepository extends MongoRepository<User, Integer> {
	//this repository contain all operations of mongodb
	public  User findByIdUser(long idUser);

}
