package guru.springframework.msscbeerservice.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

public class MvcExceptionHandler {

    public ResponseEntity<List> validationErrorHandler(ConstraintViolationException ex){
        List<String> errorsList = new ArrayList<>(ex.getConstraintViolations().size());

        ex.getConstraintViolations().forEach(e -> errorsList.add(e.toString()));

        return  new ResponseEntity<>(errorsList, HttpStatus.BAD_REQUEST);
    }
}
