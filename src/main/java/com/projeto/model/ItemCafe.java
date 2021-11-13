package com.projeto.model;

import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class ItemCafe {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "descricao")
	private String descricao;
	
	@Column(name = "colaborador_id")
	private Long colaboradorId;
	
	@ManyToOne
	@JoinColumn(name = "colaborador_id", insertable = false, updatable = false)
	@JsonBackReference
	private Colaborador colaborador;

	public Optional<ItemCafe> buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	

}
