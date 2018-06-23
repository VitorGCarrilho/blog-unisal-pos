package br.unisal.blogunisal.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;

import br.unisal.blogunisal.model.Post.PostBuilder;
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
public class Comment implements Serializable {
	
	public User user;
	
	public LocalDateTime date;
	
	public String comment;
}
