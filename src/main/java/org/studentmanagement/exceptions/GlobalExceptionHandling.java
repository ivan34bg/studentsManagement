package org.studentmanagement.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandling {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handleNoSuchElementException(EntityNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserEntityUniqueConstraintViolationException.class)
    public ResponseEntity<Void> handleUserEntitySaveFailureException(UserEntityUniqueConstraintViolationException ex) {
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    @ExceptionHandler(FieldConstraintViolationException.class)
    public ResponseEntity<String[]> handleFieldConstraintViolationException(FieldConstraintViolationException ex) {
        return new ResponseEntity<>(ex.getMessages(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RoleRequirementViolationException.class)
    public ResponseEntity<String> handleRoleRequirementViolationException(RoleRequirementViolationException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
