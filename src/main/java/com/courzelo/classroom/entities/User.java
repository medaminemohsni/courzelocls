package com.courzelo.classroom.entities;



import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Document(collection="User")

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
	
	

	   @Transient
     public static final String SEQUENCE_NAME = "databaseUser_sequences";
	    
	    @Id
	    @Field(value = "IdUser")
	    private long idUser;
	    public String name;
	    public String image;
	
}
