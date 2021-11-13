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
import com.projeto.model.ItemCafe;
import com.projeto.service.ItemCafeService;

@RestController
@RequestMapping("/itemCafe")
public class ItemCafeController {
	
	
	@Autowired
	private ItemCafeService itemCafeService;

	@Autowired
	private ModelMapper modelMapper;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ItemCafe salvar(@RequestBody ItemCafe itemCafe) {
		return itemCafeService.salvar(itemCafe);
	}

	@GetMapping("/listar")
	@ResponseStatus(HttpStatus.OK)
	public List<ItemCafe> listarItemCafe() {
		return itemCafeService.listarItemCafe();

	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ItemCafe buscarItemCafePorId(@PathVariable("id") Long id) {
		return itemCafeService.buscarPorId(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Item não encontrado"));

	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void removerItemCafe(@PathVariable("id") Long id) {
		itemCafeService.buscarPorId(id).map(itemCafe -> {
			itemCafeService.removerPorId(itemCafe.getId());
			return Void.TYPE;
		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Item não encontrado"));

	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void atualizarItemCafe(@PathVariable("id") Long id, @RequestBody ItemCafe itemCafe) {
		itemCafe.buscarPorId(id).map(itemCafeBase -> {
			modelMapper.map(itemCafe, itemCafeBase);
			itemCafeService.salvar(itemCafe);
			return Void.TYPE;
		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Item não encontrado"));

	}

}


