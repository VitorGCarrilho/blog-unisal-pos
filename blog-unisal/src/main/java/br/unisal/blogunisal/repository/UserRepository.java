package br.unisal.blogunisal.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.unisal.blogunisal.model.User;

/**
 * @author Vitor Carrilho - 23/06/2018
 *
 */
public interface UserRepository extends MongoRepository<User, String> {

}
