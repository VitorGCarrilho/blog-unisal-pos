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

import br.unisal.blogunisal.model.Post;
import br.unisal.blogunisal.service.PostService;

/**
 * @author Vitor Carrilho - 23/06/2018
 *
 */
@RestController
@RequestMapping("/api/v1/post")
public class PostResource {

	@Autowired
	private PostService postService;
	
	@GetMapping("all")
	public ResponseEntity<List<Post>> getAll(){
		List<Post> posts = postService.findAll();
		return ResponseEntity.ok().body(posts);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Post> findOne(@PathVariable("id") String id){
		Post post = postService.findOne(id);
		return ResponseEntity.ok().body(post);
	}
	
	@PostMapping()
	public ResponseEntity<Post> save(@RequestBody Post post){
		post = postService.savePost(post);
		return new ResponseEntity<Post>(post, HttpStatus.CREATED);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity delete(@PathVariable("id") String id) {
		postService.delete(id);
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
}
