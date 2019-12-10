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

import com.syscon.autofleet.models.Rent;
import com.syscon.autofleet.models.ResponseData;
import com.syscon.autofleet.models.Vehicle;
import com.syscon.autofleet.repository.RentRepository;
import com.syscon.autofleet.repository.VehicleRepository;

@CrossOrigin
@RestController
@RequestMapping(path="/api")
public class RentResource {

	@Autowired
	RentRepository rentRepository;
	
	@Autowired
	VehicleRepository vehicleRepository;
	
	@GetMapping("/rents")
	public List<Rent> rentsList(){
		return rentRepository.findAll();
	}
	
	@GetMapping("/rent/{id}")
	public Object getRent(@PathVariable(value="id") Integer id){
		try {
			Rent rent = rentRepository.findById(id).get();
			return new ResponseData("success", "Aluguel encontrado", rent);
		} catch (Exception e) {
			return new ResponseData("success", "Aluguel não encontrado");	
		}
	}
	
	@PostMapping("/rent")
	public Object storeRent(@RequestBody Rent rent){
		Vehicle vehicle = vehicleRepository.findById(rent.getVehicle_id()).get();
		vehicle.setStatus(3);
		vehicleRepository.save(vehicle);
		
		return new ResponseData("success", "Aluguel criado", rentRepository.save(rent));
	}
	
	@PostMapping("/rent/update")
	public ResponseData updaterent(@RequestBody Rent rent){
		if (rentRepository.existsById(rent.getId())) {
			Rent rentUpdated = rentRepository.save(rent);
			
			return new ResponseData("success", "Aluguel atualizado", rentUpdated);
		} else {
		    return new ResponseData("error", "Aluguel não encontrado");
		}
	}
	
	@PostMapping("/rent/delete")
	public ResponseData deleterent(@RequestBody Rent rent){
		if (rentRepository.existsById(rent.getId())) {
			rentRepository.deleteById(rent.getId());
			
			return new ResponseData("success", "Aluguel removido");
		} else {
		    return new ResponseData("error", "Aluguel não encontrado");
		}
	}
}
