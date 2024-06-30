package com.javatechie.handler;

import com.javatechie.dto.ErrorDTO;
import com.javatechie.dto.ServiceResponse;
import com.javatechie.exception.CourseServiceBusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ApplicationGlobalExceptionHandler {

    //handle MethodArgumentNotValidException
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    //NOte : ServiceResponse and ErrorDtoList are user-defined class in our Application
    public ServiceResponse<?> handleMethodArgumentException(MethodArgumentNotValidException exception) {

        ServiceResponse<?> response = new ServiceResponse<>();
        List<ErrorDTO> errorDTOList = new ArrayList<>();
        exception.getBindingResult().getFieldErrors().forEach(error -> errorDTOList.add(new ErrorDTO(error.getDefaultMessage())));
        response.setError(errorDTOList);
        response.setStatus(HttpStatus.BAD_REQUEST);
        return response;
    }

    @ExceptionHandler(CourseServiceBusinessException.class)
    public ServiceResponse<?> handleServiceException(CourseServiceBusinessException exception) {
        ServiceResponse<?> response = new ServiceResponse<>();
        List<ErrorDTO> errorDTOList = new ArrayList<>();
        errorDTOList.add(new ErrorDTO(exception.getMessage()));
        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        response.setError(errorDTOList);
        return response;

    }

}
