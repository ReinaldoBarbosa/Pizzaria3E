package br.itb.projeto.pizzaria3e.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.itb.projeto.pizzaria3e.model.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	Produto findByNome(String nome);
	
	Produto findBycodigoBarras(String codigoBarras);
}
