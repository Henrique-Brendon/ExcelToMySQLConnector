package com.system.model.impl;

import java.util.List;

import com.system.model.entities.Setor;

public interface SetorDao {
	void insert(Setor id);
	void update(Setor id);
	void deleteById(Setor id);
	Setor findById(Setor id);
	List<Setor> findAll();
}
