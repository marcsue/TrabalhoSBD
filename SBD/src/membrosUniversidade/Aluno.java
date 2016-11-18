package membrosUniversidade;

import java.util.Date;

import areasUniversidade.Curso;

public class Aluno extends Pessoas
{
	private String matricula;
	private Curso curso;
	
	
	public Aluno(String cpf, String nome, String emailInstitucional,
			String emailSecundario, Date nascimento, String matricula, Curso curso ) 
	{
		
		super(cpf, nome, emailInstitucional, emailSecundario, nascimento);
		this.matricula = matricula;
		this.curso = curso;
	}
	
	public Aluno() {
		super();

	}
	
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}

}
