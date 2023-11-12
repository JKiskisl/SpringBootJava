package com.example.springbootproj.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootproj.services.CryptoService;

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
    public String logSearch(
        @RequestParam String coinId,
        @RequestParam String vsCurrency,
        @RequestParam String dataRange){
            Model model = new Model();
            model.setAction("logSearch");
            model.setDetails("Coin ID: " + coinId + ", Currency: " + vsCurrency + ", Data Range: " + dataRange);
            return cryptoService.getCryptoData(coinId, vsCurrency, dataRange);
        }

    @PostMapping("/logSelect")
    public void logSelect(
        @RequestParam String coinId,
        @RequestParam String vsCurrency,
        @RequestParam String dataRange
    ){
        Model model = new Model();
        model.setAction("logSelect");
        model.setDetails("Coin ID: " + coinId + ", Currency: " + vsCurrency + ", Data Range: " + dataRange);
    }
}
        
