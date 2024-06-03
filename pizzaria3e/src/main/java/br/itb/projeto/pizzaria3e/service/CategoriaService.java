package br.itb.projeto.pizzaria3e.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.itb.projeto.pizzaria3e.model.entity.Categoria;
import br.itb.projeto.pizzaria3e.model.repository.CategoriaRepository;

@Service
public class CategoriaService {

	private CategoriaRepository categoriaRepository;
	
	public CategoriaService(CategoriaRepository categoriaRepository) {
		super();
		this.categoriaRepository = categoriaRepository;
	}
 
	public List<Categoria> findAll(){
		List<Categoria> categoria = categoriaRepository.findAll();
		return categoria;
	}
	
	public Categoria findById(long id) {
		Categoria categoria = categoriaRepository.findById(id).orElseThrow();
		return categoria;
	}
	
	public Categoria findByNome(String nome) {
		Categoria categoria = categoriaRepository.findByNome(nome);
		return categoria;
	}

	
}
