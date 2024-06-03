package br.itb.projeto.pizzaria3e.rest.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.itb.projeto.pizzaria3e.model.entity.Aluno;
import br.itb.projeto.pizzaria3e.service.AlunoService;

@RestController
@RequestMapping("/aluno/")
public class AlunoController {
	
	AlunoService alunoservice = new AlunoService();
	
	@GetMapping("findAll")
	public ResponseEntity<List<Aluno>> findAll(){
		
		List<Aluno> alunos = alunoservice.findAll();
		return
				new ResponseEntity<List<Aluno>>(alunos, HttpStatus.OK);
		
	}
	
	@GetMapping("find")
	public ResponseEntity<Aluno> find(){
		Aluno aluno = alunoservice.find();
		
		return
				new ResponseEntity<Aluno>(aluno, HttpStatus.OK);
	}
	
	@GetMapping("findByRm{rm}")
	public ResponseEntity<Aluno>
	findByRm(@PathVariable long rm){
		Aluno aluno = alunoservice.findByRm(rm);
		return new ResponseEntity<Aluno>(aluno, HttpStatus.OK);
	}
	
	@GetMapping("post")
	public ResponseEntity<Aluno> post(@RequestParam long rm,
									 @RequestParam String nome,
									 @RequestParam int numero)
	{
		Aluno aluno = new Aluno(rm, nome, numero);
		
		return new ResponseEntity<Aluno>(aluno, HttpStatus.OK);
		
	}
	
	
	@GetMapping("info")
	public String getInfo() {
		return "informações do aluno";
	}

}
