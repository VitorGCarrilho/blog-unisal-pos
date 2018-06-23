package br.unisal.blogunisal.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Vitor Carrilho - 23/06/2018
 *
 */
@RestController
@RequestMapping("/api/v1/post")
public class PostController {

	@GetMapping("all")
	public String getAll(){
		return "Hello World";
	}
}
