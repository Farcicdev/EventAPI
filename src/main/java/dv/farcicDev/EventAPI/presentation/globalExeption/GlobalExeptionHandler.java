package dv.farcicDev.EventAPI.presentation.globalExeption;

import dv.farcicDev.EventAPI.aplication.exeption.EventAlreadyExistsException;
import dv.farcicDev.EventAPI.aplication.exeption.EventNotFoundExeption;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExeptionHandler {

    @ExceptionHandler(EventNotFoundExeption.class)
    public ResponseEntity<String> handleNotFound(EventNotFoundExeption exeption){
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(exeption.getMessage());
    }

    @ExceptionHandler(EventAlreadyExistsException.class)
    public ResponseEntity<String> handlerAlreadyExists(EventAlreadyExistsException existsException){
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(existsException.getMessage());
    }

}
