package com.example.springbootproj.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootproj.services.CryptoService;
import com.example.springbootproj.model.LogRequest;
import com.example.springbootproj.model.Model;
import com.example.springbootproj.model.ModelRepository;


@RestController
@RequestMapping("/api")
public class LogController {
    
    private final CryptoService cryptoService;
    private final ModelRepository modelRepository;
    @Autowired
    public LogController(CryptoService cryptoService, ModelRepository modelRepository) {
        this.cryptoService=cryptoService;
        this.modelRepository=modelRepository;
    }

    @GetMapping("/logSearch")
    public String logSearch(@RequestBody LogRequest logRequest){
            Model model = new Model();
            model.setAction("logSearch");
            model.setDetails("Coin ID: " + logRequest.getCoinId()
             + ", Currency: " + logRequest.getVsCurrency() + ", Data Range: "
              + logRequest.getDataRange());

            modelRepository.save(model);
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

        modelRepository.save(model);
    }

}