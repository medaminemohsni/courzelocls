package com.courzelo.classroom.serviceREST;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.courzelo.classroom.entities.User;
import com.courzelo.classroom.entities.dtos.UserDTO;
import com.courzelo.classroom.repositories.UserRepository;
import com.courzelo.classroom.serviceREST.iservicesREST.IServiceUser;

@Service
public class UserBusinesses implements IServiceUser {

          @Autowired
          UserRepository userRepository;
          @Autowired
          private ModelMapper mapper;
          @Autowired
          private  SequenceGeneratorService sequenceGeneratorService;
         
		@Override
		public UserDTO getUserById(long idUser) {
			User user= userRepository.findByIdUser(idUser);
			return mapper.map(user, UserDTO.class);
		}

		@Override
		public UserDTO addUser(UserDTO user) {
			User newUser=mapper.map(user, User.class);
			newUser.setIdUser(sequenceGeneratorService.generateSequence(User.SEQUENCE_NAME));
			newUser=userRepository.save(newUser);
			return mapper.map(newUser, UserDTO.class);
			 
		}
}