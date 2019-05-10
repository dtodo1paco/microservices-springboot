/**
 * 
 */
package org.dtodo1paco.samples.microservices.hospital.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author pac
 *
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 542704406859347270L;

	public NotFoundException() {
        super();
    }
    
    public NotFoundException(String message) {
        super(message);
    }
}
