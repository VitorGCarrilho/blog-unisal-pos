package br.unisal.blogunisal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unisal.blogunisal.repository.PostRepository;

/**
 * @author Vitor Carrilho - 23/06/2018
 *
 */
@Service
public class PostService {
	@Autowired
	private PostRepository postRepository;
}
