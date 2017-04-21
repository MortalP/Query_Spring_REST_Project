package fi.bfk.kysely.dao;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class KysymystaEiLoydyPoikkeus extends RuntimeException {

	public KysymystaEiLoydyPoikkeus(Exception cause) {
		super(cause);
	}
	
}
