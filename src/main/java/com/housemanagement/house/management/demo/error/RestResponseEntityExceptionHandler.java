package com.housemanagement.house.management.demo.error;


import com.housemanagement.house.management.demo.entity.ErrorMessage;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.stream.Collectors;

@ControllerAdvice // hata nerde olusursa olussun.
@ResponseStatus
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({HouseException.class})
    public ResponseEntity<ErrorMessage> houseException(HouseException exception, WebRequest request) {
        ErrorMessage message = exception.getErrorMessage();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }

    //Ovverride ResponseEntityExceptionHandler for validators.
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ObjectError objectError = ex.getBindingResult().getAllErrors().get(0);

        String messages = ex.getBindingResult()
                .getAllErrors()
                .stream()
                .map(err-> err.getDefaultMessage())
                .collect(Collectors.joining(" - "));

        ErrorMessage message = new ErrorMessage(HttpStatus.BAD_REQUEST,messages);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(message);
    }
}
