package br.com.consulta.cep.controller;


import br.com.consulta.cep.dto.request.CepRequestDTO;
import br.com.consulta.cep.dto.response.CepResponseDTO;
import br.com.consulta.cep.model.Cep;
import br.com.consulta.cep.service.CepService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Api(value = "Api para consulta de Cep")
@RestController
@RequestMapping("v1/api/cep")
public class CepController {

     private final CepService cepService;

    public CepController(CepService cepService) {
        this.cepService = cepService;
    }

    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Retorna um registro de Cep")
    @GetMapping("/{cep}")
    public CepResponseDTO getCep(@PathVariable String cep) {
        return new CepResponseDTO(cepService.getByCep(cep));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Adiciona um registro de Cep")
    @PostMapping
    public Cep postCep(@RequestBody CepRequestDTO cepRequestDTO) {
        Cep cep = this.cepService.save(cepRequestDTO.build());
        return cep;
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation("Deleta um registro de Cep")
    @DeleteMapping(path = "/{cep}")
    public void delete(@PathVariable("cep") String cep) {
        cepService.delete(cep);
    }


}
