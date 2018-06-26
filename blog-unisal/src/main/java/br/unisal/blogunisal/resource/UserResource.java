package br.unisal.blogunisal.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.unisal.blogunisal.model.User;
import br.unisal.blogunisal.service.UserService;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Vitor Carrilho - 23/06/2018
 *
 */
@Slf4j
@RestController
@RequestMapping("api/v1/user")
public class UserResource {
	@Autowired
	private UserService userService;
	
	@GetMapping("{id}")
	public ResponseEntity<User> findOne(@PathVariable("id") String id){
		log.info("GET request to [api/v1/user/{}] received",id);
		User user = userService.findOne(id);
		log.info("GET request to [api/v1/user/{}] returned",id);
		return ResponseEntity.ok().body(user);
	}
	
	@PostMapping()
	public ResponseEntity<User> save(@RequestBody User user) {
		log.info("POST request to [api/v1/user] received");
		user = userService.save(user);
		log.info("POST request to [api/v1/user] returned");
		return new ResponseEntity<User>(user, HttpStatus.CREATED);
	}
	
	@GetMapping("all")
	public ResponseEntity<List<User>> findAll(){
		log.info("GET request to [api/v1/user/all] received");
		List<User> user = userService.findAll();
		log.info("GET request to [api/v1/user/all] returned");
		return ResponseEntity.ok().body(user);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity delete(@PathVariable("id") String id) {
		userService.delete(id);
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	
}
