package com.example.springbootproj.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootproj.services.CryptoService;
import com.example.springbootproj.model.LogRequest;
import com.example.springbootproj.model.Model;

@RestController
@RequestMapping("/api")
public class LogController {
    
    private final CryptoService cryptoService;

    @Autowired
    public LogController(CryptoService cryptoService) {
        this.cryptoService=cryptoService;
    }

    @PostMapping("/logSearch")
    public String logSearch(@RequestBody LogRequest logRequest){
            Model model = new Model();
            model.setAction("logSearch");
            model.setDetails("Coin ID: " + logRequest.getCoinId()
             + ", Currency: " + logRequest.getVsCurrency() + ", Data Range: "
              + logRequest.getDataRange());

            System.out.println("FETCHING CRYPTO");
            System.out.println(cryptoService.getCryptoData(
                logRequest.getCoinId(), 
                logRequest.getVsCurrency(), 
                logRequest.getDataRange()));
            return cryptoService.getCryptoData(
                logRequest.getCoinId(), 
                logRequest.getVsCurrency(), 
                logRequest.getDataRange());
        }

    @PostMapping("/logSelect")
    public void logSelect(@RequestBody LogRequest logRequest) {
        Model model = new Model();
        model.setAction("logSelect");
        model.setDetails("Coin ID: " +
         logRequest.getCoinId() + ", Currency: " + 
         logRequest.getVsCurrency() + ", Data Range: " + 
         logRequest.getDataRange());
        
    }

}