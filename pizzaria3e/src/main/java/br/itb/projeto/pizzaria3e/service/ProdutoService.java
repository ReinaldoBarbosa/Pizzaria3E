package br.itb.projeto.pizzaria3e.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.itb.projeto.pizzaria3e.model.entity.Produto;
import br.itb.projeto.pizzaria3e.model.repository.ProdutoRepository;
import jakarta.transaction.Transactional;


@Service
public class ProdutoService {
	private ProdutoRepository produtoRepository;

	public ProdutoService(ProdutoRepository produtoRepository) {
		super();
		this.produtoRepository = produtoRepository;
	}
	
	public List<Produto> findAll(){
		List<Produto> produto = produtoRepository.findAll();
		return produto;
	}
	
	public Produto findById(long id) {
		Produto produto = produtoRepository.findById(id).orElseThrow();
		
		return produto;
	}
	
	public Produto findByNome(String nome) {
		Produto produto = produtoRepository.findByNome(nome);
		
		return produto;
	}
	
	public Produto findBycodigoBarras(String codigoBarras) {
		Produto produto = produtoRepository.findBycodigoBarras(codigoBarras);
		
		return produto;
	}
	
	@Transactional
	public Produto create(Produto produto) {
		
		produto.setUrlFoto(null);
		produto.setStatusPRod("ATIVO");
		
		return produtoRepository.save(produto);
	}
}
