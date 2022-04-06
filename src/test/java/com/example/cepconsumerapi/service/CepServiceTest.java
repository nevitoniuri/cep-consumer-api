package com.example.cepconsumerapi.service;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.cepconsumerapi.client.CepClient;
import com.example.cepconsumerapi.model.CepModel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {CepService.class})
@ExtendWith(SpringExtension.class)
class CepServiceTest {
    @MockBean
    private CepClient cepClient;

    @Autowired
    private CepService cepService;

    @Test
    void testGetAdressByCep() {
        assertThrows(IllegalArgumentException.class, () -> this.cepService.getAdressByCep("Cep"));
    }

    @Test
    void testGetAdressByCep2() {
        CepModel cepModel = new CepModel();
        cepModel.setBairro("Bairro");
        cepModel.setCep("Cep");
        cepModel.setComplemento("alice.liddell@example.org");
        cepModel.setLocalidade("Localidade");
        cepModel.setLogradouro("Logradouro");
        cepModel.setUf("Uf");
        when(this.cepClient.getAdressByCep((String) any())).thenReturn(cepModel);
        assertSame(cepModel, this.cepService.getAdressByCep("CepCep42"));
        verify(this.cepClient).getAdressByCep((String) any());
    }

    @Test
    void testGetAdressByCep3() {
        when(this.cepClient.getAdressByCep((String) any())).thenThrow(new IllegalArgumentException("foo"));
        assertThrows(IllegalArgumentException.class, () -> this.cepService.getAdressByCep("CepCep42"));
        verify(this.cepClient).getAdressByCep((String) any());
    }
}

