package com.system.model.impl;

import java.util.List;

import com.system.model.entities.Produto;

public interface ProdutoDao {
	void insert(Produto id);
	void update(Produto id);
	void deleteById(Produto id);
	Produto findById(Produto id);
	List<Produto> findAll();
}


