package com.michael.crud.api.services.principal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.michael.crud.api.documents.Pessoa;
import com.michael.crud.api.repositories.PessoaRepository;
import com.michael.crud.api.services.PessoaService;

@Service
public class PessoaServicePrincipal implements PessoaService {
	
	@Autowired
	private PessoaRepository pessoaRespository;

	@Override
	public List<Pessoa> list() {
		return this.pessoaRespository.findAll();
	}

	@Override
	public Pessoa listById(String id) {
		return this.pessoaRespository.findOne(id);
	}

	@Override
	public Pessoa insert(Pessoa pessoa) {
		return this.pessoaRespository.save(pessoa);
	}

	@Override
	public Pessoa update(Pessoa pessoa) {
		return this.pessoaRespository.save(pessoa);
	}

	@Override
	public void delete(String id) {
		this.pessoaRespository.delete(id);
	}

}
