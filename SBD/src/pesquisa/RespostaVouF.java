package pesquisa;

public class RespostaVouF extends Resposta 
{
	private boolean resp;

	public RespostaVouF( String descricao, boolean resp)  {
		super(descricao);
		this.resp = resp;
	}
	
	public RespostaVouF() {
		super();
	}

	public boolean isResp() {
		return resp;
	}

	public void setResp(boolean resp) {
		this.resp = resp;
	}
	
	
	
	
}
