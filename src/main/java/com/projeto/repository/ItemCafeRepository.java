package com.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.model.ItemCafe;

@Repository
public interface ItemCafeRepository extends JpaRepository<ItemCafe, Long> {

}
