package br.com.consulta.cep.controller.v1;

import br.com.consulta.cep.controller.CepController;
import br.com.consulta.cep.model.Cep;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CepControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    CepController cepController;

    @Test
    void test_GetCep_Successful() throws Exception {
        mockMvc.perform(get("/v1/api/cep/00002"))
                .andExpect(status().isOk());
    }

    @Test
    public void test_Post() throws Exception {

        Cep cep = Cep.builder()
                .cep("teste")
                .bairro("teste")
                .complemento("teste")
                .localidade("teste")
                .logradouro("teste")
                .uf("teste")
                .ibge("teste")
                .build();

        mockMvc.perform(post("/v1/api/cep")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(cep)))
                .andExpect(status().isCreated());
    }
    @Test
    public void test_Delete() throws Exception {
        mockMvc.perform(delete("/v1/api/cep/00002"))
                .andExpect(status().isNoContent());
    }
}
