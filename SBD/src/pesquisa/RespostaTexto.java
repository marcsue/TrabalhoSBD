package pesquisa;

public class RespostaTexto extends Resposta
{
	private String resp;

	public RespostaTexto (String descricao, String resp)  {
		super( descricao);
		this.resp = resp;
	}
	
	public RespostaTexto() {
		super();
	}
	public String getResp() {
		return resp;
	}

	public void setResp(String resp) {
		this.resp = resp;
	}
	
	
}
