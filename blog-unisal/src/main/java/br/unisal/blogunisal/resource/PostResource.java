package br.unisal.blogunisal.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.unisal.blogunisal.model.Post;
import br.unisal.blogunisal.service.PostService;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Vitor Carrilho - 23/06/2018
 *
 */
@Slf4j
@RestController
@RequestMapping("/api/v1/post")
public class PostResource {

	@Autowired
	private PostService postService;
	
	@GetMapping("all")
	public ResponseEntity<List<Post>> getAll(){
		log.info("GET request to [api/v1/post/all] received");
		List<Post> posts = postService.findAll();
		log.info("GET request to [api/v1/user/all] returned");
		return ResponseEntity.ok().body(posts);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Post> findOne(@PathVariable("id") String id){
		log.info("GET request to [api/v1/post/{}] received", id);
		Post post = postService.findOne(id);
		log.info("GET request to [api/v1/user/{}] returned", id);
		return ResponseEntity.ok().body(post);
	}
	
	@PostMapping()
	public ResponseEntity<Post> save(@RequestBody Post post){
		log.info("POST request to [api/v1/post] received");
		post = postService.savePost(post);
		log.info("POST request to [api/v1/post] returned, post saved with id {}", post.getId());
		return new ResponseEntity<Post>(post, HttpStatus.CREATED);
	}
}
