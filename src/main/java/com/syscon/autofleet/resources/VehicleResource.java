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
import com.syscon.autofleet.models.Vehicle;
import com.syscon.autofleet.repository.VehicleRepository;

@CrossOrigin
@RestController
@RequestMapping(path="/api")
public class VehicleResource {
	
	@Autowired
	VehicleRepository vehicleRepository;
	
	@GetMapping("/vehicles")
	public List<Vehicle> vehiclesList(){
		return vehicleRepository.findAll();
	}
	
	@GetMapping("/vehicle/{id}")
	public Object getVehicle(@PathVariable(value="id") Integer id){
		try {
			Vehicle vehicle = vehicleRepository.findById(id).get();
			return new ResponseData("success", "Veículo encontrado", vehicle);
		} catch (Exception e) {
			return new ResponseData("success", "Veículo não encontrado");	
		}
	}
	
	@PostMapping("/vehicle")
	public Object storeVehicle(@RequestBody Vehicle vehicle){
		if (vehicleRepository.findByPlate(vehicle.getPlate()) == null) {
			return new ResponseData("success", "Veículo criado", vehicleRepository.save(vehicle));
		} else {
			return new ResponseData("error", "Já existe um veículo com esta placa");
		}
	}
	
	@PostMapping("/vehicle/update")
	public ResponseData updatevehicle(@RequestBody Vehicle vehicle){
		if (vehicleRepository.existsById(vehicle.getId())) {
			Vehicle vehicleUpdated = vehicleRepository.save(vehicle);
			
			return new ResponseData("success", "Veículo atualizado", vehicleUpdated);
		} else {
		    return new ResponseData("error", "Veículo não encontrado");
		}
	}
	
	@PostMapping("/vehicle/delete")
	public ResponseData deletevehicle(@RequestBody Vehicle vehicle){
		if (vehicleRepository.existsById(vehicle.getId())) {
			vehicleRepository.deleteById(vehicle.getId());
			
			return new ResponseData("success", "Veículo removido");
		} else {
		    return new ResponseData("error", "Veículo não encontrado");
		}
	}

}
