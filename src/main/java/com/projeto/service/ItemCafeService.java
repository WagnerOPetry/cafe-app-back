package com.projeto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.model.ItemCafe;
import com.projeto.repository.ItemCafeRepository;

@Service
public class ItemCafeService {
	
	@Autowired
	private ItemCafeRepository itemCafeRepository;	

	public ItemCafe salvar(ItemCafe itemCafe) {
		return itemCafeRepository.save(itemCafe);
	}

	public List<ItemCafe> listarItemCafe() {
		return itemCafeRepository.findAll();

	}

	public Optional<ItemCafe> buscarPorId(Long id) {
		return itemCafeRepository.findById(id);
	}

	public void removerPorId(Long id) {
		itemCafeRepository.deleteById(id);
	}

}
