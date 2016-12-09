package pesquisa;

import java.util.ArrayList;

public class RespostaMulti extends Resposta 
{
	//0 false / 1 true / -1 abstencao
	private int resp_id;
	
	public RespostaMulti(int id, int resp,String cpf)  {
		super(id,cpf);
		this.resp_id = resp;
	}
	
	public RespostaMulti() {
		super();
	}

	public Integer getResp() {
		return resp_id;
	}

	public void setResp(Integer resp) {
		this.resp_id = resp;
	}
	
	
	
}
