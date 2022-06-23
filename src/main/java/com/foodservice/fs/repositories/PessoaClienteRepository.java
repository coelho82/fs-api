package com.foodservice.fs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.foodservice.fs.domain.PessoaCliente;

@Repository
public interface PessoaClienteRepository extends JpaRepository<PessoaCliente, Integer>{
	@Query("SELECT obj FROM PessoaCliente obj WHERE obj.cpf =:cpf")
	PessoaCliente findByCPF(@Param("cpf") String cpf);
}
