package br.itb.projeto.pizzaria3e.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.itb.projeto.pizzaria3e.model.entity.Mensagem;
import br.itb.projeto.pizzaria3e.model.entity.Usuario;

public interface MensagemRepository extends JpaRepository<Mensagem, Long> {
	Mensagem findByEmail(String email);
}
