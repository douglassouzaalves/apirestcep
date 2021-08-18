package br.com.consulta.cep.model.repository;

import br.com.consulta.cep.model.Cep;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Mapper
public interface CepRepository {

    @Insert("INSERT INTO tabela_cep(cep, logradouro, complemento, bairro, localidade, uf, ibge) "
            + "VALUES (#{cep},#{logradouro},#{complemento},#{bairro}, #{localidade}, #{uf}, #{ibge})")
    int insert(Cep cep);


    @Select("SELECT * FROM tabela_cep WHERE cep=#{cep}")
    Optional<Cep> getByCep(String cep);

    @Delete("DELETE FROM tabela_cep WHERE cep=#{cep}")
    int delete(String cep);


}
