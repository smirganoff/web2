package model;

import java.util.ArrayList;
import java.util.List;

public class Disciplina {
	private String codigo;
	private String professor;
	private String nomeDisciplina;
	private List<Aluno> alunos;
	private List<Aula> aulas;
	
	public Disciplina(String codigo, String nomeDisciplina, String professor) {
        this.codigo = codigo;
        this.nomeDisciplina = nomeDisciplina;
        this.setProfessor(professor);
        this.alunos = new ArrayList<>();
        this.aulas = new ArrayList<>();
    }	
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNomeDisciplina() {
		return nomeDisciplina;
	}
	public void setNomeDisciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}
	public List<Aluno> getAlunos() {
		return alunos;
	}
	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
	public List<Aula> getAulas() {
		return aulas;
	}
	public void setAulas(List<Aula> aulas) {
		this.aulas = aulas;
	}
	public void adicionarAluno(Aluno aluno) {
		this.alunos.add(aluno);
	}

	public String getProfessor() {
		return professor;
	}

	public void setProfessor(String professor) {
		this.professor = professor;
	}
}
