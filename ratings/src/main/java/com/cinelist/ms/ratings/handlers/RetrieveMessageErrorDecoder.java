package com.cinelist.ms.ratings.handlers;

import com.cinelist.ms.ratings.dtos.handler.CustomErrorResponse;
import com.cinelist.ms.ratings.handlers.exceptions.ResourceNotFoundException;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.apache.coyote.BadRequestException;

import java.io.IOException;
import java.io.InputStream;

public class RetrieveMessageErrorDecoder implements ErrorDecoder {
    private final ErrorDecoder errorDecoder = new Default();

    @Override
    public Exception decode(String methodKey, Response response) {
        CustomErrorResponse message = null;
        try (InputStream bodyIs = response.body().asInputStream()) {
            ObjectMapper mapper = new ObjectMapper();
            message = mapper.readValue(bodyIs, CustomErrorResponse.class);
        } catch (IOException ex) {
            return new Exception(ex.getMessage());
        }

        return switch (response.status()) {
            case 400 -> new BadRequestException(message.getError());
            case 404 -> new ResourceNotFoundException(message.getError());
            default -> errorDecoder.decode(methodKey, response);
        };
    }
}