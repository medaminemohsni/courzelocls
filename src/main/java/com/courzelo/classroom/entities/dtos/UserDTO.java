package com.courzelo.classroom.entities.dtos;

import java.sql.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class UserDTO {
	
	
	public long idUser ;
	public String name ;
	public String image;
	
}
