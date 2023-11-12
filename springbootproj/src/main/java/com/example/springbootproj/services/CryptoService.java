package com.example.springbootproj.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class CryptoService {
    @Value("${coingecko.api.url}")
    private String apiUrl;

    private final RestTemplate restTemplate;

    @Autowired
    public CryptoService(RestTemplate restTemplate) {
        this.restTemplate=restTemplate;
    }

    public String getCryptoData(String coindId, String vsCurrency, String dataRange) {

        String endpoint= apiUrl + "/coins/" + coindId + "/ohlc";
        String params = "?vs_currency=" + vsCurrency + "&days=" + dataRange;

        String result = restTemplate.getForObject(endpoint+params, String.class);

        return result;
    }
}