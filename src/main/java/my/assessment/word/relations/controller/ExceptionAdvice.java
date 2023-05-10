package my.assessment.word.relations.controller;

import java.util.Map;
import my.assessment.word.relations.exception.DuplicateRelationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionAdvice {

  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  @ExceptionHandler({DuplicateRelationException.class})
  public ResponseEntity<Map<String, String>> handleException(Throwable cause) {
    return new ResponseEntity<>(Map.of("message",cause.getMessage()), HttpStatus.BAD_REQUEST);
  }
}
