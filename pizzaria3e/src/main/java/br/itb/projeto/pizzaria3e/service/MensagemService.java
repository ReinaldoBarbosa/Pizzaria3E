package br.itb.projeto.pizzaria3e.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import br.itb.projeto.pizzaria3e.model.entity.Mensagem;
import br.itb.projeto.pizzaria3e.model.repository.MensagemRepository;
import jakarta.transaction.Transactional;

@Service
public class MensagemService {
private MensagemRepository mensagemRepository;
	
	public MensagemService(MensagemRepository mensagemRepository) {
		super();
		this.mensagemRepository = mensagemRepository;
	}
 
	public List<Mensagem> findAll(){
		List<Mensagem> mensagem = mensagemRepository.findAll();
		return mensagem;
	}
	
	public Mensagem findById(long id) {
		Mensagem mensagem = mensagemRepository.findById(id).orElseThrow();
		return mensagem;
	}
	
	public Mensagem findByEmail(String email) {
		Mensagem mensagem = mensagemRepository.findByEmail(email);
		
		return mensagem;
	}
	
	@Transactional
	public Mensagem create(Mensagem mensagem) {
		
		mensagem.setDataMensagem(LocalDateTime.now());
		mensagem.setStatusMensagem("ATIVO");
		
		return mensagemRepository.save(mensagem);
	}
	
	@Transactional
	public Mensagem update(long id) {
		Optional<Mensagem> _mensagem = mensagemRepository.findById(id);
			
		if(_mensagem.isPresent()) {
			Mensagem mensagemAtualizada = _mensagem.get();
			mensagemAtualizada.setStatusMensagem("LIDA");
			
			return mensagemRepository.save(mensagemAtualizada);
		}
		
		return null; 
	}
	
	@Transactional
	public Mensagem inativar(long id) {
		Optional<Mensagem> _mensagem = mensagemRepository.findById(id);
			
		if(_mensagem.isPresent()) {
			Mensagem mensagemAtualizada = _mensagem.get();
			mensagemAtualizada.setStatusMensagem("INATIVO");
			
			return mensagemRepository.save(mensagemAtualizada);
		}
		
		return null; 
	}
	
	
}
