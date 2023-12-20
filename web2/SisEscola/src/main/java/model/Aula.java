package model;

import java.sql.Date;
import java.util.List;

public class Aula {
    private int id_aula;
    private Date data;
    private Disciplina disciplina;
    private List<Aluno> alunosPresentes;

    public Aula(int id, Date data, Disciplina disciplina) {
        this.id_aula = id;
        this.data = data;
        this.disciplina = disciplina;
    }

	public Aula(java.util.Date data2) {
		// TODO Auto-generated constructor stub
	}

	public int getId_aula() {
		return id_aula;
	}

	public void setId_aula(int id_aula) {
		this.id_aula = id_aula;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public List<Aluno> getAlunosPresentes() {
		return alunosPresentes;
	}

	public void setAlunosPresentes(List<Aluno> alunosPresentes) {
		this.alunosPresentes = alunosPresentes;
	}
}