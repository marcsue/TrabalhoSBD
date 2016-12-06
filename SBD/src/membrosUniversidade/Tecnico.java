package membrosUniversidade;

import java.util.Date;

import areasUniversidade.*;

public class Tecnico extends Pessoas 
{
	private String siape;
	private Unidade unidade;
	
	public Tecnico(String cpf, String nome, String emailInstitucional,
			String emailSecundario, Date nascimento, String siape, Unidade unidade ) 
	{
		
		super(cpf, nome, emailInstitucional, emailSecundario, nascimento);
		this.siape = siape;
		this.unidade = unidade;
	}
	

	public String getSiape() {
		return siape;
	}

	public void setSiape(String siape) {
		this.siape = siape;
	}

	public Unidade getUnidade() {
		return unidade;
	}

	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}
	
	
}
