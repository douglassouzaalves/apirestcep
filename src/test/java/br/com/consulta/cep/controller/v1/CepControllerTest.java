package br.com.consulta.cep.controller.v1;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CepControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    CepController cepController;

    @Test
    void test() throws Exception {
        mockMvc.perform(get("/v1/api/cep/00002"))
                .andExpect(status().isOk());
    }
}
