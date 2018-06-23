package br.unisal.blogunisal.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.unisal.blogunisal.model.Post;

/**
 * @author Vitor Carrilho - 23/06/2018
 *
 */
public interface PostRepository extends MongoRepository<Post, String>{

}
