package com.example.VPN;

import lombok.Data;
import org.springframework.http.HttpHeaders;
import org.springframework.util.MultiValueMap;

import java.util.Map;

@Data
public class HttpRequest {

    private String url;
    private String method;
    private Map<String, String> headers;
    private Map<String, String> body;
}
