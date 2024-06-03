package br.itb.projeto.pizzaria3e.rest.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.itb.projeto.pizzaria3e.model.entity.Produto;
import br.itb.projeto.pizzaria3e.model.entity.Usuario;
import br.itb.projeto.pizzaria3e.service.ProdutoService;


@RestController
@RequestMapping("/produto/")
public class ProdutoController {
private ProdutoService produtoService;

	
	public ProdutoController(ProdutoService produtoService) {
		super();
		this.produtoService = produtoService;
	}


	@GetMapping("findAll")
	public ResponseEntity<List<Produto>> findAll(){
		List<Produto> produto = produtoService.findAll();
		
		return new ResponseEntity<List<Produto>>(produto, HttpStatus.OK);
		
	
	}
	
	@GetMapping("findByid/{id}")
	public ResponseEntity<Produto> findById(@PathVariable long id){
		Produto produto = produtoService.findById(id);
		
		return new ResponseEntity<Produto>(produto, HttpStatus.OK);
	}
	
	@GetMapping("findByEmail")
	public ResponseEntity<Produto> findByNome(@RequestParam String nome){
		
		Produto produto = produtoService.findByNome(nome);
		
		return new ResponseEntity<Produto>(produto, HttpStatus.OK);
	}
	
	@GetMapping("findBycodigoBarras")
	public ResponseEntity<Produto> findBycodigoBarras(@RequestParam String codigoBarras){
		
		Produto produto = produtoService.findBycodigoBarras(codigoBarras);
		
		return new ResponseEntity<Produto>(produto, HttpStatus.OK);
	}
	
	@PostMapping("create")
	public ResponseEntity<Produto> create(@RequestBody Produto produto){
		Produto _produto = produtoService.create(produto);
		
		return new ResponseEntity<Produto>(_produto, HttpStatus.OK);
	}
}
