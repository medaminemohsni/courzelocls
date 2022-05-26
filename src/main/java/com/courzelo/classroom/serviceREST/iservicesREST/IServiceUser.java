package com.courzelo.classroom.serviceREST.iservicesREST;

import java.util.List;

import com.courzelo.classroom.entities.User;
import com.courzelo.classroom.entities.dtos.FormationDTO;
import com.courzelo.classroom.entities.dtos.UserDTO;








public interface IServiceUser {
	
	public UserDTO getUserById(long idUser); 
	public UserDTO addUser(UserDTO user); 

	

}
