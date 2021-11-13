package com.projeto.util;

import com.projeto.dto.ItemCafeDTO;
import com.projeto.model.ItemCafe;

public class ItemCafeConverter {
	
	public static ItemCafeDTO converterDTO(ItemCafe itemCafe) {
		return new ItemCafeDTO(itemCafe.getId(), itemCafe.getDescricao(), itemCafe.getColaboradorId());
	}
	
	public static ItemCafe converter(ItemCafeDTO dto) {
		ItemCafe itemCafe = new ItemCafe();
		 itemCafe.setId(dto.getId());
		 itemCafe.setDescricao(dto.getDescricao());
		 itemCafe.setColaboradorId(dto.getColaboradorId());
		 return itemCafe;
	}

}
