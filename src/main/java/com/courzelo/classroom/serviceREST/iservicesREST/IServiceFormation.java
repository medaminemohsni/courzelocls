package com.courzelo.classroom.serviceREST.iservicesREST;

import java.util.List;

import com.courzelo.classroom.entities.Formation;
import com.courzelo.classroom.entities.dtos.FormationDTO;








public interface IServiceFormation {
	public FormationDTO addformation(FormationDTO f,Long idUserr );
	public List<FormationDTO>getList();
	public List<FormationDTO>getFormtionByIdCreator(Long id);
	public List<FormationDTO>getFormtionByTest(Boolean test,Long id);
	public List<Formation> getFormationByIdStudent(Long id);
	public FormationDTO getFormationById(long idFormation); 
	public FormationDTO UpdateFormation(long idFormation , FormationDTO RequestFormation); 
	public void DeleteFormation(long idFormation); 
	public FormationDTO addQuiz(long id,String idQuiz);
	

}
