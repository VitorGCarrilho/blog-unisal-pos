package br.unisal.blogunisal.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Vitor Carrilho - 23/06/2018
 *
 */
@ResponseStatus(code=HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7174706454906820305L;
	
	public NotFoundException(){
		super("Object not found");
	}

}
