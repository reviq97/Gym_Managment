package pl.nwaczykgym.nwaczykgym.controler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pl.nwaczykgym.nwaczykgym.service.exceptions.UserAlreadyExistsException;

@ControllerAdvice()
public class ExceptionControllerAdvice {

    @ExceptionHandler
    public ResponseEntity onUserAlreadyExists(UserAlreadyExistsException ex){
        return new ResponseEntity(HttpStatus.CONFLICT);
    }

    @ExceptionHandler
    public ResponseEntity onUserNotFound(UserNotFoundException ex){
        return ResponseEntity.notFound().build();
    }
}
