package pesquisa;

public class RespostaTexto extends Resposta
{
	private String resp;

	public RespostaTexto (int id,String resp,String cpf)  {
		super(id,cpf);
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
