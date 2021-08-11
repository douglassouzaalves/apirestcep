package br.com.consulta.cep.service;

import br.com.consulta.cep.error.ResourceNotFoundException;
import br.com.consulta.cep.model.Cep;
import br.com.consulta.cep.model.repository.CepRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service
public class CepService {

    //utilizando pra injetar a dependência
    CepRepository cepRepository;

    public Cep getByCep(String cep) {
        return cepRepository.getByCep(cep).orElseThrow(() -> new ResourceNotFoundException("Not Found"));
    }

    public Cep save(Cep cep) {
        this.cepRepository.insert(cep);
        return cep;
    }

    public void delete(String cep) {
        this.cepRepository.delete(cep);
    }

}