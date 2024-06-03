package br.itb.projeto.pizzaria3e.service;

import java.time.LocalDateTime;
import java.util.Base64;
import java.util.List;


import org.springframework.stereotype.Service;

import br.itb.projeto.pizzaria3e.model.entity.Usuario;
import br.itb.projeto.pizzaria3e.model.repository.UsuarioRepository;
import jakarta.transaction.Transactional;

@Service
public class UsuarioService {
	private UsuarioRepository usuarioRepository;

	public UsuarioService(UsuarioRepository usuarioRepository) {
		super();
		this.usuarioRepository = usuarioRepository;
	}
	
	public List<Usuario> findAll(){
		List<Usuario> usuario = usuarioRepository.findAll();
		return usuario;
	}
	
	public Usuario findById(long id) {
		Usuario usuario = usuarioRepository.findById(id).orElseThrow();
		
		return usuario;
	}
	
	public Usuario findByEmail(String email) {
		Usuario usaurio = usuarioRepository.findByEmail(email);
		
		return usaurio;
	}
	
	@Transactional
	public Usuario create(Usuario usuario) {
		
		String senha= Base64.getEncoder().encodeToString(usuario.getSenha().getBytes());
		
		usuario.setSenha(senha);
		usuario.setDataCadastro(LocalDateTime.now());
		usuario.setStatusUsuario("ATIVO");
		
		return usuarioRepository.save(usuario);
	}
	
	@Transactional
	public Usuario singnin(String email, String senha) {
		Usuario usuario = usuarioRepository.findByEmail(email);
		
		if(usuario.getStatusUsuario().equals("ATIVO")) {
			byte[] decodePass = Base64.getDecoder()
									  .decode(usuario.getSenha());
			if(new String(decodePass).equals(senha)) {
				return usuario;
			}
		}
		
		return null;
		
	}
}