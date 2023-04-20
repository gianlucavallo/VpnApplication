package com.example.VPN;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
@RequestMapping("")
public class Controller {

    private final RestTemplate restTemplate = new RestTemplate();


    @GetMapping("")
    public ResponseEntity<String> getResponseByHttpRequest(@RequestBody HttpRequest httpRequest) throws JsonProcessingException {

        HttpHeaders httpHeaders = new HttpHeaders();
        for(String key : httpRequest.getHeaders().keySet()){
            httpHeaders.set(key, httpRequest.getHeaders().get(key));
        }

        return restTemplate.exchange(
                httpRequest.getUrl(),
                HttpMethod.valueOf(httpRequest.getMethod()),
                new HttpEntity<>(new ObjectMapper().writeValueAsString(httpRequest.getBody()),httpHeaders),
                String.class);
    }
}
