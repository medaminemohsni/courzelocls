package com.courzelo.classroom.businesses;


import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.courzelo.classroom.businesses.iservices.IServiceInscription;
import com.courzelo.classroom.entities.Formation;
import com.courzelo.classroom.entities.Inscription;
import com.courzelo.classroom.entities.Userr;
//import com.courzelo.classroom.entities.User;
import com.courzelo.classroom.entities.dtos.InscriptionDTO;
import com.courzelo.classroom.repositories.InscriptionRepository;
import com.courzelo.classroom.serviceREST.FormationBusinesses;
//import com.courzelo.classroom.repositories.UserRepository;
import com.courzelo.classroom.serviceREST.SequenceGeneratorService;
@Service
public class InscriptionBusinesses implements IServiceInscription {
	   @Autowired
       InscriptionRepository inscriptionRepository;
	
	   @Autowired
       private ModelMapper mapper;
       @Autowired
       private  SequenceGeneratorService sequenceGeneratorService;
       @Autowired
       private FormationBusinesses formationService;
	@Override
	public InscriptionDTO addInscription(InscriptionDTO f, Long idEtudiant, Long idFormation) {
		Inscription inscription = mapper.map(f,Inscription.class);
		  inscription.setId(sequenceGeneratorService.generateSequence(Formation.SEQUENCE_NAME));
		  inscription.setIdEtudiant(idEtudiant);
		  inscription.setIdFormation(idFormation);
	      Inscription newInscri =inscriptionRepository.save(inscription);
	      
	       return mapper.map(newInscri,InscriptionDTO.class);	
	}
	
	@Override
	public List<Userr> getListInscription(Long id) {
		List<Userr> users=new  ArrayList<Userr>();
		List<Inscription> inscriptions=inscriptionRepository.findByIdFormation(id);
                for(Inscription i:inscriptions) {
                	Userr user=formationService.getUserByRestTemplate(id);
                	users.add(user);
                }
		return users;
	}
	


	



}
