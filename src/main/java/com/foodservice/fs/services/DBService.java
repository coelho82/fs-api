package com.foodservice.fs.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodservice.fs.domain.Merc_Produto;
import com.foodservice.fs.domain.PessoaCliente;
import com.foodservice.fs.domain.Venda;
import com.foodservice.fs.domain.VendaItem;
import com.foodservice.fs.repositories.Merc_ProdutoRepository;
import com.foodservice.fs.repositories.PessoaClienteRepository;
import com.foodservice.fs.repositories.VendaItemRepository;
import com.foodservice.fs.repositories.VendaRepository;

@Service
public class DBService {

	@Autowired
	private PessoaClienteRepository pessoaclienteRepository;
	@Autowired
	private Merc_ProdutoRepository merc_produtoRepository;
	@Autowired
	private VendaRepository vendaRepository;
	@Autowired
	private VendaItemRepository vendaitemRepository;

	public void instaciaDB() {
		PessoaCliente c1 = new PessoaCliente(null, "Jose", null, "Rio de Janeiro", "m", "601.556.050-97");
		Merc_Produto p1 = new Merc_Produto(null, "batata", "kg", 10, null, null);
		Venda v1 = new Venda(null, null, c1, null, "vista", "n", null, "nao entregar", "f", null);
		VendaItem vi1 = new VendaItem(null, v1, p1, null, null, null);

		c1.getList().add(v1); //relaciona o cliente à venda
		p1.getList().add(vi1); //relaciona o produto à venda
 
		pessoaclienteRepository.saveAll(Arrays.asList(c1));
		merc_produtoRepository.saveAll(Arrays.asList(p1));
		vendaRepository.saveAll(Arrays.asList(v1));
		vendaitemRepository.saveAll(Arrays.asList(vi1));
	}
}
