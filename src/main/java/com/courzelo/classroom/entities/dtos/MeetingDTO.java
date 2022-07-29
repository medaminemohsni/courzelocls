package com.courzelo.classroom.entities.dtos;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class MeetingDTO {
	private long idInstructor;
	private long idFormation;
	private long id;
	private Date date;
	private String link;
}
