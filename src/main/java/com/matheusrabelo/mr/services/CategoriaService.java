package com.matheusrabelo.mr.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matheusrabelo.mr.Repositories.CategoriaRepository;
import com.matheusrabelo.mr.domain.Categoria;

@Service
public class CategoriaService {

	@Autowired

	private CategoriaRepository repo;

	public Categoria find(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElse(null);
	}

}
