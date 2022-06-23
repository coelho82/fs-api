package com.foodservice.fs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foodservice.fs.domain.Merc_Produto;

@Repository
public interface Merc_ProdutoRepository extends JpaRepository<Merc_Produto, Integer>{

}
