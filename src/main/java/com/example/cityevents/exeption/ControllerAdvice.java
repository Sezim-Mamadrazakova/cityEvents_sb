package com.example.cityevents.exeption;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> catchException(Exception e) {

        ErrorMessage errorMessage = new ErrorMessage("An error occurred: " + e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
    }
}
