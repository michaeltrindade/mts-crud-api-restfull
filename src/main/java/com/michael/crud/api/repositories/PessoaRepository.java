package com.michael.crud.api.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.michael.crud.api.documents.Pessoa;

public interface PessoaRepository extends MongoRepository<Pessoa, String> {

}
