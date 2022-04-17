package com.multipleton.spring.controller.rest;

import com.multipleton.spring.service.exception.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FrontRestController {

    @ExceptionHandler
    public void handleEntityNotFoundException(final EntityNotFoundException ex,
                                              final HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.NOT_FOUND.value(), ex.getMessage());
    }

}
