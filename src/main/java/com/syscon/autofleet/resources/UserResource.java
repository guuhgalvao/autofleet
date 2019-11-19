package com.syscon.autofleet.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.syscon.autofleet.models.ResponseData;
import com.syscon.autofleet.models.User;
import com.syscon.autofleet.repository.UserRepository;

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
		return new ResponseData("success", "Usuário recuperado", userRepository.findById(id));
	}
	
	@PostMapping("/user")
	public ResponseData storeUser(@RequestBody User user){
		if (userRepository.findByEmail(user.getEmail()) == null) {
			return new ResponseData("success", "Usuário criado", userRepository.save(user));
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
}
