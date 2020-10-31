package com.example.demo.handler;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;



@ControllerAdvice

public class ExceptionAdvice extends ResponseEntityExceptionHandler {

    @RequestBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ArenaNotFoundException.class)
    @ResponseBody String arenaNotFoundHandler(ArenaNotFoundException arenaNotFoundException){return arenaNotFoundException.getMessage();}

    @RequestBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ArenaIdAlreadyExistsExceptions.class)
    @ResponseBody String arenaIdAlreadyExists(ArenaIdAlreadyExistsExceptions arenaIdAlreadyExistsExceptions){return arenaIdAlreadyExistsExceptions.getMessage();}
    @ExceptionHandler(PlayerNotFoundException.class)
    public @ResponseBody String playerNotFoundHandler(PlayerNotFoundException p) { return p.getMessage(); }

    @RequestBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(IdPlayerAlreadyExist.class)
    public @ResponseBody String idAlreadyExist(IdPlayerAlreadyExist i) {
        return i.getMessage();
    }



}
