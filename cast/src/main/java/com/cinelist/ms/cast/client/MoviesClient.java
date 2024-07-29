package com.cinelist.ms.cast.client;

import com.cinelist.ms.cast.dtos.client.MovieResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.UUID;

@FeignClient(value = "moviesclient", url = "http://localhost:8082")
public interface MoviesClient {
    @RequestMapping(method = RequestMethod.GET, value = "/movies/{identifier}")
    ResponseEntity<MovieResponse> findByIdentifier(@PathVariable UUID identifier);
}