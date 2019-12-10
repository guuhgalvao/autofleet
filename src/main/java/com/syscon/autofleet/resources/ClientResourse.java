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

import com.syscon.autofleet.models.Client;
import com.syscon.autofleet.models.ResponseData;
import com.syscon.autofleet.repository.ClientRepository;

@CrossOrigin
@RestController
@RequestMapping(path="/api")
public class ClientResourse {

	@Autowired
	ClientRepository clientRepository;
	
	@GetMapping("/clients")
	public List<Client> usersList(){
		return clientRepository.findAll();
	}
	
	@GetMapping("/client/{id}")
	public Object getClient(@PathVariable(value="id") Integer id){
		try {
			Client client = clientRepository.findById(id).get();
			return new ResponseData("success", "Cliente encontrado", client);
		} catch (Exception e) {
			return new ResponseData("success", "Cliente não encontrado");	
		}
	}
	
	@PostMapping("/client")
	public Object storeClient(@RequestBody Client client){
		if (clientRepository.findByCnpj(client.getCnpj()) == null) {
			return new ResponseData("success", "Cliente criado", clientRepository.save(client));
		} else {
			return new ResponseData("error", "Já existe um cliente com este CNPJ");
		}
	}
	
	@PostMapping("/client/update")
	public ResponseData updateClient(@RequestBody Client client){
		if (clientRepository.existsById(client.getId())) {
			Client clientUpdated = clientRepository.save(client);
			
			return new ResponseData("success", "Cliente atualizado", clientUpdated);
		} else {
		    return new ResponseData("error", "Cliente não encontrado");
		}
	}
	
	@PostMapping("/client/delete")
	public ResponseData deleteClient(@RequestBody Client client){
		if (clientRepository.existsById(client.getId())) {
			clientRepository.deleteById(client.getId());
			
			return new ResponseData("success", "Cliente removido");
		} else {
		    return new ResponseData("error", "Cliente não encontrado");
		}
	}
}
