package pesquisa;

public class RespostaSNA extends Resposta 
{
	//0 false / 1 true / -1 abstencao
	private Integer resp;

	public RespostaSNA( String descricao, Integer resp)  {
		super(descricao);
		this.resp = resp;
	}
	
	public RespostaSNA() {
		super();
	}

	public Integer getResp() {
		return resp;
	}

	public void setResp(Integer resp) {
		this.resp = resp;
	}
	
	
	
}
