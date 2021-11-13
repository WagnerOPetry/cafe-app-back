package com.projeto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.model.Colaborador;
import com.projeto.repository.ColaboradorRepository;


@Service
public class ColaboradorService {

	@Autowired
	private ColaboradorRepository colaboradorRepository;

		public Colaborador salvar(Colaborador colaborador) {
		return colaboradorRepository.save(colaborador);
	}

	public List<Colaborador> listarColaborador() {
		return colaboradorRepository.findAll();

	}

	public Optional<Colaborador> buscarPorId(Long id) {
		return colaboradorRepository.findById(id);
	}

	public void removerPorId(Long id) {
		colaboradorRepository.deleteById(id);
	}

}
