package br.unisal.blogunisal.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import br.unisal.blogunisal.model.Post.PostBuilder;
import br.unisal.blogunisal.model.enumerated.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Vitor Carrilho - 23/06/2018
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "user")
public class User implements Serializable {
	@Id
	private String id;
	
	private String name;
	
	private String email;
	
	private String password;
	
	private UserRole role;
}
