package pesquisa;

import java.util.ArrayList;
import java.sql.Date;
public class Formulario 
{
	private Integer id;
	private Date data_fim;
	private Date data_inicio;
	private String cpf;
	private String titulo;
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	private boolean aluno;
	private boolean professor;
	private boolean terceirizado;
	public Date getData_fim() {
		return data_fim;
	}
	public void setData_fim(Date data_fim) {
		this.data_fim = data_fim;
	}
	public Date getData_inicio() {
		return data_inicio;
	}
	public void setData_inicio(Date data_inicio) {
		this.data_inicio = data_inicio;
	}
	public boolean isAluno() {
		return aluno;
	}
	public void setAluno(boolean aluno) {
		this.aluno = aluno;
	}
	public boolean isProfessor() {
		return professor;
	}
	public void setProfessor(boolean professor) {
		this.professor = professor;
	}
	public boolean isTerceirizado() {
		return terceirizado;
	}
	public void setTerceirizado(boolean terceirizado) {
		this.terceirizado = terceirizado;
	}
	public boolean isTecnico() {
		return tecnico;
	}
	public void setTecnico(boolean tecnico) {
		this.tecnico = tecnico;
	}

	private boolean tecnico;
	private static ArrayList<Questao> questoes = new ArrayList<>();
	
	public Formulario()
	{
		
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
		
	public boolean addQuestao(Questao questao)
	{
		try
		{
			questoes.add(questao);
			return true;
		}
		catch(NullPointerException e)
		{
			return false;
		}
	}	
	public boolean removeResposta(Questao questao) //Corrigir
	{
		try
		{
			questoes.remove(questao);
			return true;
		}
		catch(NullPointerException e)
		{
			return false;
		}
	}
	
	public void showQuestoes() //Corrigir
	{
		for(int i=0;i<questoes.size();i++)
			System.out.println(questoes.get(i).getId());
	}
	
	
}
