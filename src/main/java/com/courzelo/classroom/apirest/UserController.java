package com.courzelo.classroom.apirest;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.courzelo.classroom.entities.dtos.UserDTO;
import com.courzelo.classroom.serviceREST.iservicesREST.IServiceUser;




@CrossOrigin(origins ="http://localhost:4200/")
@RequestMapping(value = "/api/User")
@RestController

public class UserController {
	@Autowired
	private IServiceUser iUser;
	
	

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO user){
		user=iUser.addUser(user);
		return new ResponseEntity<>(user, HttpStatus.OK);

	}
	
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public UserDTO getUserById(@PathVariable(name = "id") Long id){
		return iUser.getUserById(id);
	}
	
	
	
}
