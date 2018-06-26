package br.unisal.blogunisal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import br.unisal.blogunisal.exeption.NotFoundException;
import br.unisal.blogunisal.model.Post;
import br.unisal.blogunisal.repository.PostRepository;

/**
 * @author Vitor Carrilho - 23/06/2018
 *
 */
@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;
	
	public List<Post> findAll() {
		return postRepository.findAll();
	}
	
	public Post savePost(Post post) {
		return postRepository.save(post);
	}
	
	public Post findOne(String id){
		Post post = Post.builder().id(id).build();
		return postRepository.findOne(Example.of(post)).orElseThrow(NotFoundException::new);
	}

	public void delete(String id) {
		postRepository.delete(this.findOne(id));
	}
}
