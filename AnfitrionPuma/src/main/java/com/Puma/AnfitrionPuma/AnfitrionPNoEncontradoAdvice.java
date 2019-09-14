package com.Puma.AnfitrionPuma;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class AnfitrionPNoEncontradoAdvice {
    @ResponseBody
    @ExceptionHandler(AnfitrionPNoEncontradoException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String anfitioPnoencontradoHandler(AnfitrionPNoEncontradoException ex) {
        return ex.getMessage();
    }
}
