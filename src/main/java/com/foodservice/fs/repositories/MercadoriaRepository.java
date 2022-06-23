package com.foodservice.fs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foodservice.fs.domain.Mercadoria;

@Repository
public interface MercadoriaRepository extends JpaRepository<Mercadoria, Integer>{

}
