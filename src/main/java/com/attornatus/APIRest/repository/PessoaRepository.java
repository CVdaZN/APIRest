package com.attornatus.APIRest.repository;

import com.attornatus.APIRest.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
