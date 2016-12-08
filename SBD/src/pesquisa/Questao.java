package pesquisa;

import java.util.ArrayList;

public class Questao
{
	private Integer id;
	private String pergunta;
	private static ArrayList<Resposta> respostas = new ArrayList<>();
	
	public Questao(Integer id, String pergunta) {
		this.id = id;
		this.pergunta = pergunta;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return pergunta;
	}

	public void setDescricao(String pergunta) {
		this.pergunta = pergunta;
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









