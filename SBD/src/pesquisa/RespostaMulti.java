package pesquisa;

public class RespostaMulti extends Resposta 
{
	//0 false / 1 true / -1 abstencao
	private Integer resp;

	public RespostaMulti( String descricao, Integer resp)  {
		super(descricao);
		this.resp = resp;
	}
	
	public RespostaMulti() {
		super();
	}

	public Integer getResp() {
		return resp;
	}

	public void setResp(Integer resp) {
		this.resp = resp;
	}
	
	
	
}
