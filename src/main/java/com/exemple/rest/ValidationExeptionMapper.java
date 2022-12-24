package com.exemple.rest;

import jakarta.validation.ValidationException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import static jakarta.ws.rs.core.MediaType.TEXT_PLAIN;

@Provider
public class ValidationExeptionMapper implements ExceptionMapper<ValidationException> {
    @Override
    public Response toResponse(ValidationException e) {
        return Response.status(Response.Status.BAD_REQUEST)
                .type(TEXT_PLAIN)
                .entity("[ERROR] : "+e.getMessage())
                .build();
    }
}
