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

import com.syscon.autofleet.models.Reservation;
import com.syscon.autofleet.models.ResponseData;
import com.syscon.autofleet.models.Vehicle;
import com.syscon.autofleet.repository.ReservationRepository;
import com.syscon.autofleet.repository.VehicleRepository;

@CrossOrigin
@RestController
@RequestMapping(path="/api")
public class ReservationResource {

	@Autowired
	ReservationRepository reservationRepository;
	
	@Autowired
	VehicleRepository vehicleRepository;
	
	@GetMapping("/reservations")
	public List<Reservation> reservationsList(){
		return reservationRepository.findAll();
	}
	
	@GetMapping("/reservation/{id}")
	public Object getReservation(@PathVariable(value="id") Integer id){
		try {
			Reservation reservation = reservationRepository.findById(id).get();
			return new ResponseData("success", "Reserva encontrada", reservation);
		} catch (Exception e) {
			return new ResponseData("success", "Reserva não encontrada");	
		}
	}
	
	@PostMapping("/reservation")
	public Object storeReservation(@RequestBody Reservation reservation){
		Vehicle vehicle = vehicleRepository.findById(reservation.getVehicle_id()).get();
		vehicle.setStatus(2);
		vehicleRepository.save(vehicle);
		
		return new ResponseData("success", "Reserva criada", reservationRepository.save(reservation));
	}
	
	@PostMapping("/reservation/update")
	public ResponseData updatereservation(@RequestBody Reservation reservation){
		if (reservationRepository.existsById(reservation.getId())) {
			Reservation reservationUpdated = reservationRepository.save(reservation);
			
			return new ResponseData("success", "Reserva atualizada", reservationUpdated);
		} else {
		    return new ResponseData("error", "Reserva não encontrada");
		}
	}
	
	@PostMapping("/reservation/delete")
	public ResponseData deletereservation(@RequestBody Reservation reservation){
		if (reservationRepository.existsById(reservation.getId())) {
			reservationRepository.deleteById(reservation.getId());
			
			return new ResponseData("success", "Reserva removida");
		} else {
		    return new ResponseData("error", "Reserva não encontrada");
		}
	}
}
