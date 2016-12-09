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
	private int tipo_restricao;
	private static ArrayList<Questao> questoes = new ArrayList<>();
	
	public Formulario()
	{
		
	}
	
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
	
	public int getTipo_restricao() {
		return tipo_restricao;
	}
	public void setTipo_restricao(int tipo_restricao) {
		this.tipo_restricao = tipo_restricao;
	}

	

	public static ArrayList<Questao> getQuestoes() {
		return questoes;
	}

	public static void setQuestoes(ArrayList<Questao> questoes) {
		Formulario.questoes = questoes;
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
