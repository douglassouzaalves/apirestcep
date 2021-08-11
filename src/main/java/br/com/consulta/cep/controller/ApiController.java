package br.com.consulta.cep.controller;

import br.com.consulta.cep.model.Cep;
import br.com.consulta.cep.service.CepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("api/viacep")
public class ApiController {

    @Autowired
    CepService cepService;


    @GetMapping("/{cep}")
    public Cep getCep(@PathVariable String cep) {

            String url = "https://viacep.com.br/ws/" + cep + "/json/";
            RestTemplate restTemplate = new RestTemplate();
            Cep cepResponse = restTemplate.getForObject(url, Cep.class);
            this.cepService.save(cepResponse);
            return cepResponse;
        }

}
