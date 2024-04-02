package com.store.retail.exceptions;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.persistence.EntityNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<String> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
        // Extract the root cause exception
        Throwable rootCause = ex.getRootCause();
        if (rootCause != null && rootCause.getMessage().contains("Unique index or primary key violation")) {
            return new ResponseEntity<>("Record already exists", HttpStatus.CONFLICT);
        }
        // Handle other cases of DataIntegrityViolationException if needed
        return new ResponseEntity<>("An error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
    }
	
	  @ExceptionHandler(EntityNotFoundException.class)
	    public ResponseEntity<String> handleEntityNotFoundException(EntityNotFoundException ex) {
	        // Extracting the entity id from the message
	        String message = ex.getMessage();
	        String entityId = message.substring(message.lastIndexOf(" ") + 1);
	        
	        // Extracting the entity name
	        String entityName = message.substring(0, message.indexOf(" "));
	        
	        // Creating a customized message with the entity name and id
	        String customMessage = entityName + " with id " + entityId + " not found.";
	        
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(customMessage);
	    }
	
	@ExceptionHandler(DuplicateItemException.class)
    public ResponseEntity<String> handleItemNameAlreadyExistsException(DuplicateItemException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
    }
}

