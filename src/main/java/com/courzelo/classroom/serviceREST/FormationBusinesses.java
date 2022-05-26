package com.courzelo.classroom.serviceREST;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.courzelo.classroom.entities.Formation;
import com.courzelo.classroom.entities.Inscription;
import com.courzelo.classroom.entities.dtos.FormationDTO;
import com.courzelo.classroom.repositories.FormationRepository;
import com.courzelo.classroom.repositories.InscriptionRepository;
import com.courzelo.classroom.serviceREST.iservicesREST.IServiceFormation;


@Service
public class FormationBusinesses implements IServiceFormation {

          @Autowired
          FormationRepository formationRepository;
          @Autowired
          InscriptionRepository inscriptionRepository ;
          @Autowired
          private ModelMapper mapper;
          @Autowired
          private  SequenceGeneratorService sequenceGeneratorService;


	@Override
	public List<FormationDTO> getList() {
		List<Formation> formations= formationRepository.findAll();
		return formations.stream().map(formation -> mapper.map(formation, FormationDTO.class))
				.collect(Collectors.toList());
	}

	

	@Override
	public FormationDTO addformation(FormationDTO f, String createur) {
		  Formation formation = mapper.map(f, Formation.class);
		   formation.setIdFormation(sequenceGeneratorService.generateSequence(Formation.SEQUENCE_NAME));
		   formation.setInstructorname(createur);
		   formation.setTest(true);;
	       Formation newFormation = formationRepository.save(formation);
	       
	       FormationDTO responseFormation = mapper.map(newFormation, FormationDTO.class);
	       return responseFormation;
	}



	@Override
	public FormationDTO getFormationById(long idFormation) {
		Formation formation=formationRepository.findByIdFormation(idFormation);
		return mapper.map(formation, FormationDTO.class);
	}



	@Override
	public FormationDTO UpdateFormation(long idFormation, FormationDTO RequestFormation) {
         Formation formation = mapper.map(RequestFormation, Formation.class);
		
	
         formation.setIdFormation(idFormation);
		Formation newFormation = formationRepository.save(formation);
		FormationDTO ResponseFormation = mapper.map(newFormation, FormationDTO.class);
				
		return ResponseFormation; 
		
	
	}



	@Override
	public void DeleteFormation(long idFormation) {
		Formation formation = formationRepository.findByIdFormation(idFormation); 
		formation.setTest(false);
		 formation.setIdFormation(idFormation);
		Formation newFormation = formationRepository.save(formation);
		
		
	}



	@Override
	public List<FormationDTO> getFormationByIdStudent(Long id) {
		List<Formation> formations=new ArrayList<Formation>();
		List<Inscription> inscriptions= inscriptionRepository.findByIdEtudiant(id);
		for(Inscription i:inscriptions) {
			Formation f=formationRepository.findByIdFormation(i.getIdFormation());
			formations.add(f);
			
			
		}
		System.out.println("fghjk"+formations);
		return formations.stream().map(formation -> mapper.map(formation, FormationDTO.class))
				.collect(Collectors.toList());
		
	}



	@Override
	public List<FormationDTO> getFormtionByIdCreator(String id) {
		List<Formation> formations=formationRepository.findByinstructorname(id);
		 return formations.stream().map(formation -> mapper.map(formation, FormationDTO.class))
					.collect(Collectors.toList());
	}



	@Override
	public List<FormationDTO> getFormtionByTest(Boolean test,String id) {
	
		List<Formation> formations= formationRepository.findByTestAndInstructorname(test,id);
		return formations.stream().map(formation -> mapper.map(formation, FormationDTO.class))
				.collect(Collectors.toList());
	}

	public FormationDTO addQuiz(long id,String idQuiz) {
        
		Formation formation = formationRepository.findByIdFormation(id);
    	if(formation.getIdQuiz()==null) {
    		formation.setIdQuiz(new ArrayList<String>());
    	}
    	
    	List<String> ids =formation.getIdQuiz();
    	ids.add(idQuiz);
    	formation.setIdQuiz(ids);
    	Formation F = formationRepository.save(formation);
    	return mapper.map(F, FormationDTO.class);
   
    }
	
}
