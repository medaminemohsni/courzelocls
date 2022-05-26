package com.courzelo.classroom.businesses.iservices;

import java.util.List;

import com.courzelo.classroom.entities.User;
import com.courzelo.classroom.entities.dtos.InscriptionDTO;

public interface IServiceInscription {
	public InscriptionDTO addInscription(InscriptionDTO f,Long idEtudiant ,Long idFormation);
	
  public List<User> getListInscription(Long id);
}
