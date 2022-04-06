package com.example.cepconsumerapi.client;

import com.example.cepconsumerapi.model.CepModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "https://viacep.com.br/ws/", value = "cep")
public interface CepClient {

    @GetMapping("{cep}/json")
    CepModel getAdressByCep(@PathVariable("cep") String cep);
}