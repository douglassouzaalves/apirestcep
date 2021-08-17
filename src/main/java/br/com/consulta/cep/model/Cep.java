package br.com.consulta.cep.model;


import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;

@Accessors(chain = true) //todo set retorna o meu objeto
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor

public class Cep {

    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    //private String unidade;
    private String ibge;
}
