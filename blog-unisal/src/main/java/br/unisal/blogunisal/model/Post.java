package br.unisal.blogunisal.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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
@Builder
@Document(collection = "post")
public class Post implements Serializable  {
	@Id
	public String id;
	
	public Author author;
	
	public String title;
	
	public String postBody;
	
	public LocalDateTime date;
	
	public List<Comment> comments;
	
	public Post() {
		date = LocalDateTime.now();
	}
	
	@Data
	public class Author {
		private String name;
		private String email;
	}
}
