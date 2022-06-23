package com.foodservice.fs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foodservice.fs.domain.Merc_MateriaPrima;

@Repository
public interface Merc_MateriaPrimaRepository extends JpaRepository<Merc_MateriaPrima, Integer>{

}
