package pesquisa;

public class Resposta 
{
	private Integer id;
	private String descricao;

	public Resposta(){}
	
	public Resposta( String descricao ) {
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
	
	

}
