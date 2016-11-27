package pesquisa;

import java.util.ArrayList;

public class Questao
{
	private Integer id;
	private String descricao;
	private static ArrayList<Resposta> respostas = new ArrayList<>();
	
	public Questao(Integer id, String descricao) {
		super();
		this.id = id;
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
	
	public boolean addResposta(Resposta reposta)
	{
		try
		{
			respostas.add(reposta);
			return true;
		}
		catch(NullPointerException e)
		{
			return false;
		}
	}
	
	public boolean removeResposta(Resposta reposta)
	{
		try
		{
			respostas.remove(reposta);
			return true;
		}
		catch(NullPointerException e)
		{
			return false;
		}
	}
	
	public void showRespostas()
	{
		for(int i=0;i<respostas.size();i++)
			System.out.println(respostas.get(i).getId());
	}
	
}









