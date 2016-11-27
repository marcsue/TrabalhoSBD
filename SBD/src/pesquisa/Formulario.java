package pesquisa;

import java.util.ArrayList;

public class Formulario 
{
	private Integer id;
	private String descricao;
	private static ArrayList<Questao> questoes = new ArrayList<>();
	
	public Formulario()
	{
		
	}
	public Formulario( String descricao) {
		this.descricao = descricao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
	public boolean removeResposta(Questao questao)
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
	
	public void showQuestoes()
	{
		for(int i=0;i<questoes.size();i++)
			System.out.println(questoes.get(i).getId());
	}
	
	
}
