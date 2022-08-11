package com.courzelo.classroom.entities;



import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document()
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Chat {
	
	@Transient
	public static final String SEQUENCE_NAME = "database_sequences";
	
	@Id
	private long chatId;
	@Field("userId")
	private Userr userId;
	@Field("message")
	private String message;
	@Field("date")
	private Date sendDate;

}
