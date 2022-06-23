package com.foodservice.fs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foodservice.fs.domain.VendaItem;

@Repository
public interface VendaItemRepository extends JpaRepository<VendaItem, Integer>{

}
