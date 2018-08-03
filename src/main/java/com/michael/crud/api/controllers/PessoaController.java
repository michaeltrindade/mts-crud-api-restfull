package com.michael.crud.api.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.michael.crud.api.documents.Pessoa;
import com.michael.crud.api.responses.Response;
import com.michael.crud.api.services.PessoaService;

@RestController
@RequestMapping(path = "/api/pessoas")
public class PessoaController {
	
	@Autowired
	private PessoaService pessoaService;
	
	@GetMapping
	public ResponseEntity<Response<List<Pessoa>>> list() {
		return ResponseEntity.ok(new Response<List<Pessoa>>(this.pessoaService.list()));
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Response<Pessoa>> listById(@PathVariable(name = "id") String id) {
		return ResponseEntity.ok(new Response<Pessoa>(this.pessoaService.listById(id)));
	}
	
	@PostMapping
	public ResponseEntity<Response<Pessoa>> insert(@Valid @RequestBody Pessoa pessoa, BindingResult resultado) {
		if (resultado.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			resultado.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new Response<Pessoa>(erros));
		}
		
		return ResponseEntity.ok(new Response<Pessoa>(this.pessoaService.insert(pessoa)));
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<Response<Pessoa>> update(@PathVariable(name = "id") String id, @Valid @RequestBody Pessoa pessoa, BindingResult resultado) {
		if (resultado.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			resultado.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new Response<Pessoa>(erros));
		}
		
		pessoa.setId(id);
		return ResponseEntity.ok(new Response<Pessoa>(this.pessoaService.update(pessoa)));
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Response<Integer>> delete(@PathVariable(name = "id") String id) {
		this.pessoaService.delete(id);
		return ResponseEntity.ok(new Response<Integer>(1));
	}

}
