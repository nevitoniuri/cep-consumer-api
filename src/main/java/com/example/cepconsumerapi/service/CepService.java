package com.example.cepconsumerapi.service;

import com.example.cepconsumerapi.client.CepClient;
import com.example.cepconsumerapi.model.CepModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CepService {

    @Autowired
    public CepClient cepClient;

    public CepModel getAdressByCep(String cep) {
        validaCep(cep);
        return this.cepClient.getAdressByCep(cep);
    }

    private void validaCep(String cep) {
        if (cep.length() != 8) {
            throw new IllegalArgumentException("CEP inválido");
        }
    }

}
