package com.michael.crud.api.services;

import java.util.List;

import com.michael.crud.api.documents.Pessoa;

public interface PessoaService {
	
	List<Pessoa> list();
	
	Pessoa listById(String id);
	
	Pessoa insert(Pessoa pessoa);
	
	Pessoa update(Pessoa pessoa);
	
	void delete(String id);

}
