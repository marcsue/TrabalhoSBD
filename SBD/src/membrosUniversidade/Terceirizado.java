package membrosUniversidade;

import java.util.Date;

public class Terceirizado extends Pessoas 
{
	private String empresa;
	private String setor;
	
	public Terceirizado(String cpf, String nome, String emailInstitucional,
			String emailSecundario, Date nascimento, String empresa, String setor) 
	{
		
		super(cpf, nome, emailInstitucional, emailSecundario, nascimento);
		this.empresa = empresa;
		this.setor = setor;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}
	
	
}
