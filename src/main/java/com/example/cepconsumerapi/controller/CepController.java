package com.example.cepconsumerapi.controller;

import com.example.cepconsumerapi.model.CepModel;
import com.example.cepconsumerapi.service.CepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CepController {

    @Autowired
    public CepService cepService;

    @GetMapping("/cep/{cep}")
    public ResponseEntity<CepModel> getCep(@PathVariable String cep) {

        CepModel adress = cepService.getAdressByCep(cep);

        return ResponseEntity.ok().body(adress);
    }
}
