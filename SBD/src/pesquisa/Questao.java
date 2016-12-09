package pesquisa;

import java.util.ArrayList;

public class Questao
{
	private Integer id;
	private int id_form;
	private String pergunta;
	private static ArrayList<Resposta> respostas = new ArrayList<>();
	public Questao(String pergunta){
		this.pergunta = pergunta;
	}
	public Questao(int id_form, Integer id, String pergunta) {
		this.id = id;
		this.setId_form(id_form);
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

	public int getId_form() {
		return id_form;
	}

	public void setId_form(int id_form) {
		this.id_form = id_form;
	}
	
}









