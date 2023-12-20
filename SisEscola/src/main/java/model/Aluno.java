package model;

public class Aluno {
	private String id_aluno; 
	private String nome;
	private String matricula;

	 public Aluno(String id_aluno, String nome) {
	        this.id_aluno = id_aluno;
	        this.nome = nome;
	    }

	public String getId_aluno() {
		return id_aluno;
	}

	public void setId_aluno(String id_aluno) {
		this.id_aluno = id_aluno;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
		
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
}
	