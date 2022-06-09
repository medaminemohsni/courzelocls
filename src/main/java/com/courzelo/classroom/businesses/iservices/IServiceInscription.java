package com.courzelo.classroom.businesses.iservices;

import java.util.List;

import com.courzelo.classroom.entities.Userr;
import com.courzelo.classroom.entities.dtos.InscriptionDTO;

public interface IServiceInscription {
	public InscriptionDTO addInscription(InscriptionDTO f,Long idEtudiant ,Long idFormation);
	
 public List<Userr> getListInscription(Long id);
}
