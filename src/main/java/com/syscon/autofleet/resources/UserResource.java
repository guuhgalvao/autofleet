package com.syscon.autofleet.resources;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.syscon.autofleet.models.ResponseData;
import com.syscon.autofleet.models.User;
import com.syscon.autofleet.repository.UserRepository;

@CrossOrigin
@RestController
@RequestMapping(path="/api")
public class UserResource {

	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/users")
	public List<User> usersList(){
		return userRepository.findAll();
	}
	
	@GetMapping("/user/{id}")
	public ResponseData getUser(@PathVariable(value="id") Integer id){
		try {
			User user = userRepository.findById(id).get();
			return new ResponseData("success", "Usuário encontrado", user);
		} catch (Exception e) {
			return new ResponseData("error", "Usuário não encontrado");	
		}
	}
	
	@PostMapping("/user")
	public ResponseData storeUser(@RequestBody User user){
		if (userRepository.findByEmail(user.getEmail()) == null) {
			if (userRepository.findByCpf(user.getCpf()) == null) {
				return new ResponseData("success", "Usuário criado", userRepository.save(user));
			} else {
				return new ResponseData("error", "Já existe um usuário com este CPF");
			}
		} else {
			return new ResponseData("error", "Já existe um usuário com este e-mail");
		}
	}
	
	@PostMapping("/user/update")
	public ResponseData updateUser(@RequestBody User user){
		if (userRepository.existsById(user.getId())) {
			User userUpdated = userRepository.save(user);
			
			return new ResponseData("success", "Usuário atualizado", userUpdated);
		} else {
		    return new ResponseData("error", "Usuário não encontrado");
		}
	}
	
	@PostMapping("/user/delete")
	public ResponseData deleteUser(@RequestBody User user){
		if (userRepository.existsById(user.getId())) {
			userRepository.deleteById(user.getId());
			
			return new ResponseData("success", "Usuário removido");
		} else {
		    return new ResponseData("error", "Usuário não encontrado");
		}
	}
	
	@PostMapping("/user/login")
	public ResponseData loginUser(@RequestBody User user){
		try {
			User dbUser = userRepository.findByEmail(user.getEmail());
			if (dbUser.getPassword().equals(user.getPassword())) {
				dbUser.setToken(UUID.randomUUID().toString());
				return new ResponseData("success", "Usuário logado", userRepository.save(dbUser));
			} else {
				return new ResponseData("error", "Senha incorreta");
			}
		} catch (Exception e) {
			return new ResponseData("error", "Usuário não encontrado");	
		}
	}
}
