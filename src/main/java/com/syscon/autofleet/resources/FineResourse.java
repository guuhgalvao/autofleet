package com.syscon.autofleet.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.syscon.autofleet.models.ResponseData;
import com.syscon.autofleet.models.Fine;
import com.syscon.autofleet.repository.FineRepository;

@CrossOrigin
@RestController
@RequestMapping(path="/api")
public class FineResourse {

	@Autowired
	FineRepository fineRepository;
	
	@GetMapping("/fines")
	public List<Fine> finesList(){
		return fineRepository.findAll();
	}
	
	@GetMapping("/fine/{id}")
	public Object getFine(@PathVariable(value="id") Integer id){
		try {
			Fine fine = fineRepository.findById(id).get();
			return new ResponseData("success", "Multa encontrada", fine);
		} catch (Exception e) {
			return new ResponseData("success", "Multa não encontrada");	
		}
	}
	
	@PostMapping("/fine")
	public Object storeFine(@RequestBody Fine fine){
		return new ResponseData("success", "Multa criada", fineRepository.save(fine));
	}
	
	@PostMapping("/fine/update")
	public ResponseData updatefine(@RequestBody Fine fine){
		if (fineRepository.existsById(fine.getId())) {
			Fine fineUpdated = fineRepository.save(fine);
			
			return new ResponseData("success", "Multa atualizada", fineUpdated);
		} else {
		    return new ResponseData("error", "Multa não encontrada");
		}
	}
	
	@PostMapping("/fine/delete")
	public ResponseData deletefine(@RequestBody Fine fine){
		if (fineRepository.existsById(fine.getId())) {
			fineRepository.deleteById(fine.getId());
			
			return new ResponseData("success", "Multa removida");
		} else {
		    return new ResponseData("error", "Multa não encontrada");
		}
	}
}
