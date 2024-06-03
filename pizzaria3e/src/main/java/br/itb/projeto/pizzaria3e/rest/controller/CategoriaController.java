package br.itb.projeto.pizzaria3e.rest.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.itb.projeto.pizzaria3e.model.entity.Categoria;
import br.itb.projeto.pizzaria3e.service.CategoriaService;

@RestController
@RequestMapping("/categoria/")
public class CategoriaController {
	private CategoriaService categoriaService;

	public CategoriaController(CategoriaService categoriaService) {
		super();
		this.categoriaService = categoriaService;
	}
	
	@GetMapping("findAll")
	public ResponseEntity<List<Categoria>> findAll(){
		
		List<Categoria> categoria = categoriaService.findAll();
		
		return new ResponseEntity<List<Categoria>>(categoria, HttpStatus.OK);
	}
	
	@GetMapping("findById/{id}")
	public ResponseEntity<Categoria> findById(@PathVariable long id){
		Categoria categoria = categoriaService.findById(id);
		
		return new ResponseEntity<Categoria>(categoria, HttpStatus.OK);
	}
	
	@GetMapping("findByNome")
	public ResponseEntity<Categoria> findByNome(@RequestParam String nome){
		Categoria categoria = categoriaService.findByNome(nome);
		
		return new ResponseEntity<Categoria>(categoria, HttpStatus.OK);
	}
}
