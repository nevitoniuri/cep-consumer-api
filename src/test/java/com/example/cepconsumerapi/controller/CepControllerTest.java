package com.example.cepconsumerapi.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

import com.example.cepconsumerapi.model.CepModel;
import com.example.cepconsumerapi.service.CepService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {CepController.class})
@ExtendWith(SpringExtension.class)
class CepControllerTest {
    @Autowired
    private CepController cepController;

    @MockBean
    private CepService cepService;

    @Test
    void testGetCep() throws Exception {
        CepModel cepModel = new CepModel();
        cepModel.setBairro("Bairro");
        cepModel.setCep("Cep");
        cepModel.setComplemento("alice.liddell@example.org");
        cepModel.setLocalidade("Localidade");
        cepModel.setLogradouro("Logradouro");
        cepModel.setUf("Uf");
        when(this.cepService.getAdressByCep((String) any())).thenReturn(cepModel);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/cep/{cep}", "Cep");
        MockMvcBuilders.standaloneSetup(this.cepController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"cep\":\"Cep\",\"logradouro\":\"Logradouro\",\"complemento\":\"alice.liddell@example.org\",\"bairro\":\"Bairro\","
                                        + "\"localidade\":\"Localidade\",\"uf\":\"Uf\"}"));
    }

    @Test
    void testGetCep2() throws Exception {
        CepModel cepModel = new CepModel();
        cepModel.setBairro("Bairro");
        cepModel.setCep("Cep");
        cepModel.setComplemento("alice.liddell@example.org");
        cepModel.setLocalidade("Localidade");
        cepModel.setLogradouro("Logradouro");
        cepModel.setUf("Uf");
        when(this.cepService.getAdressByCep((String) any())).thenReturn(cepModel);
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/cep/{cep}", "Cep");
        getResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.cepController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"cep\":\"Cep\",\"logradouro\":\"Logradouro\",\"complemento\":\"alice.liddell@example.org\",\"bairro\":\"Bairro\","
                                        + "\"localidade\":\"Localidade\",\"uf\":\"Uf\"}"));
    }
}

