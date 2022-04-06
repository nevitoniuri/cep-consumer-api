package com.example.cepconsumerapi.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CepModel {

    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;

}
