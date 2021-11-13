package com.projeto.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.projeto.model.Colaborador;
import com.projeto.service.ColaboradorService;

@RestController
@RequestMapping("/colaborador")
public class ColaboradorController {

	@Autowired
	private ColaboradorService colaboradorService;

	@Autowired
	private ModelMapper modelMapper;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Colaborador salvar(@RequestBody Colaborador colaborador) {
		return colaboradorService.salvar(colaborador);
	}

	@GetMapping("/listar")
	@ResponseStatus(HttpStatus.OK)
	public List<Colaborador> listarColaborador() {
		return colaboradorService.listarColaborador();

	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Colaborador buscarColaboradorPorId(@PathVariable("id") Long id) {
		return colaboradorService.buscarPorId(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));

	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void removerColaborador(@PathVariable("id") Long id) {
		colaboradorService.buscarPorId(id).map(colaborador -> {
			colaboradorService.removerPorId(colaborador.getId());
			return Void.TYPE;
		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));

	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void atualizarColaborador(@PathVariable("id") Long id, @RequestBody Colaborador colaborador) {
		colaboradorService.buscarPorId(id).map(colaboradorBase -> {
			modelMapper.map(colaborador, colaboradorBase);
			colaboradorService.salvar(colaborador);
			return Void.TYPE;
		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));

	}
}
