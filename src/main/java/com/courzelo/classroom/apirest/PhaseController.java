package com.courzelo.classroom.apirest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.courzelo.classroom.entities.Phase;
import com.courzelo.classroom.entities.Post;
import com.courzelo.classroom.entities.dtos.PhaseDTO;
import com.courzelo.classroom.entities.dtos.PostDTO;
import com.courzelo.classroom.entities.dtos.PhaseDTO;
import com.courzelo.classroom.serviceREST.iservicesREST.IServicePhase;
import com.courzelo.classroom.serviceREST.iservicesREST.UploadImageService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;




@CrossOrigin(origins ="http://localhost:4200/")
@RequestMapping(value = "/api/Phases")
@RestController

public class PhaseController {
	@Autowired
	private IServicePhase iPhase;
	@Autowired
	private UploadImageService uploadImageService;
	 @Autowired
     private ModelMapper mapper;

	
	@PostMapping("/{idSection}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<PhaseDTO> createPhase(@RequestParam("imageFile") MultipartFile file,@RequestParam("user") String phaseDto ,@PathVariable("idSection") long idSection) throws IOException{
		System.out.println("Original Image Byte Size - " + file.getBytes().length);
		Phase  phase= new ObjectMapper().readValue(phaseDto, Phase.class);
		phase.setFile(UploadImageService.compressBytes(file.getBytes()));
		PhaseDTO responsePhase = mapper.map(phase, PhaseDTO.class);
		   responsePhase =iPhase.addPhase(responsePhase,idSection);
		return new ResponseEntity<>(responsePhase, HttpStatus.OK);

	}
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<PhaseDTO> UpdatePhase(@RequestParam("imageFile") MultipartFile file,@RequestParam("user") String postDto ,@PathVariable("id") long id) throws IOException{
		System.out.println("Original Image Byte Size - " + file.getBytes().length);
		Phase post= new ObjectMapper().readValue(postDto, Phase.class);
		post.setFile(UploadImageService.compressBytes(file.getBytes()));
	    PhaseDTO responsePhase = mapper.map(post, PhaseDTO.class);
		responsePhase=iPhase.updatePhase(id, responsePhase);
		return new ResponseEntity<>(responsePhase, HttpStatus.OK);

	}
	@PutMapping("/updateName/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<PhaseDTO> UpdatePhaseName(@PathVariable("id") long id,@RequestBody PhaseDTO sectionDto) throws IOException{
		
		PhaseDTO responsePhase=iPhase.updatePhase(id, sectionDto);
		return new ResponseEntity<>(responsePhase, HttpStatus.OK);

	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<PhaseDTO> getAllPhases(){
		
	    return  iPhase.getList();
		
	}
	
	@GetMapping("section/{id}")
	@ResponseStatus(HttpStatus.OK)
	public List<PhaseDTO> getPhaseByFormation(@PathVariable("id") long id){
		List<PhaseDTO> postDto1=new ArrayList<PhaseDTO>();
		List<PhaseDTO> postDto= iPhase.getPhaseByIdSection(id);
		for(PhaseDTO p:postDto) {
			if(p.getFile()==null) {
				postDto1.add(p);
				System.out.println("jjjjjjjjjjjjjjjjjjjjjjjjjj"+"phase1");
			
			}
			else {
			p.setFile(uploadImageService.decompressBytes(p.getFile()));
			postDto1.add(p);
			System.out.println("jjjjjjjjjjjjjjjjjjjjjjjjjj"+"phase");
			}
			
		}
		
		return postDto;
	}	
	
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public PhaseDTO getPhaseById(@PathVariable(name = "id") Long id){
		return iPhase.getPhaseById(id);
	}
	
	
	
	
	
	@DeleteMapping(path = "/{idPhase}")
	public void deleteCourse(@PathVariable(name = "idPhase") Long idPhase) {
		iPhase.deletePhase(idPhase);
		
	}
}
