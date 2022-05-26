package com.courzelo.classroom.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


import com.courzelo.classroom.entities.Formation;


@Repository
public interface FormationRepository extends MongoRepository<Formation, Integer> {
	//this repository contain all operations of mongodb
	public  Formation findByIdFormation(long idFormation);
	public List<Formation> findByinstructorname(String idCreator);
	
	public List<Formation> findByTestAndInstructorname(Boolean test,String id);
	
	

}
