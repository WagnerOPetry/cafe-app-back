package com.projeto.util;

import com.projeto.dto.ColaboradorDTO;
import com.projeto.model.Colaborador;

public class ColaboradorConverter {

	public static ColaboradorDTO converterDTO(Colaborador colaborador) {
		return new ColaboradorDTO(colaborador.getId(), colaborador.getNome(), colaborador.getCpf());
	}
	
	public static Colaborador converter(ColaboradorDTO dto) {
		 Colaborador colaborador = new Colaborador();
		 colaborador.setId(dto.getId());
		 colaborador.setNome(dto.getNome());
		 colaborador.setCpf(dto.getCpf());
		 return colaborador;
	}

}
