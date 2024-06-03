package br.itb.projeto.pizzaria3e.service;

import java.util.ArrayList;
import java.util.List;

import br.itb.projeto.pizzaria3e.model.entity.Aluno;
import br.itb.projeto.pizzaria3e.model.repository.AlunoRepository;

public class AlunoService implements AlunoRepository {

	@Override
	public Aluno find() {
		Aluno aluno = new Aluno(85548, "asobrab odlanier", 35);
		return aluno;
	}

	@Override
	public List<Aluno> findAll() {
		List<Aluno> alunos = new ArrayList<Aluno>();
		alunos.add(new Aluno(86683,"marcelo", 67));
		alunos.add(new Aluno(85573,"carla", 84));
		alunos.add(new Aluno(45566,"burna", 22));
		return alunos;
	}

	@Override
	public Aluno findByRm(long rm) {
		List<Aluno> alunos = new ArrayList<Aluno>();
		alunos.add(new Aluno(86683,"marcelo", 67));
		alunos.add(new Aluno(85573,"carla", 84));
		alunos.add(new Aluno(45566,"burna", 22));
		
		for (int i = 0; i < alunos.size(); i++) {
			if (alunos.get(i).getRm() == rm) {
				return alunos.get(i);
			}
		}
		
		return null;
	}
	
	

}
