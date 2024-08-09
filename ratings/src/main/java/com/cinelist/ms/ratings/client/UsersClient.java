package com.cinelist.ms.ratings.client;

import com.cinelist.ms.ratings.config.FeignClientConfiguration;
import com.cinelist.ms.ratings.dtos.client.UserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.UUID;

@FeignClient(name = "usersclient", url = "http://localhost:8081", configuration = FeignClientConfiguration.class)
public interface UsersClient {
    @RequestMapping(method = RequestMethod.GET, value = "/users/{identifier}")
    ResponseEntity<UserResponse> findByIdentifier(@PathVariable UUID identifier);
}