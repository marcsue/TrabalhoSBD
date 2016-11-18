package membrosUniversidade;

import java.util.Date;

import areasUniversidade.*;

public class Tecnico extends Pessoas 
{
	private String siape;
	private UnidadeAcademica unidadeAcademica;
	private UnidadeAdministrativa unidadeAdministrativa;
	
	
	public Tecnico(String cpf, String nome, String emailInstitucional,
			String emailSecundario, Date nascimento, String siape, UnidadeAcademica unidadeAcademica ) 
	{
		
		super(cpf, nome, emailInstitucional, emailSecundario, nascimento);
		this.siape = siape;
		this.unidadeAcademica = unidadeAcademica;
	}

	public Tecnico(String cpf, String nome, String emailInstitucional,
			String emailSecundario, Date nascimento, String siape, UnidadeAdministrativa unidadeAdministrativa ) 
	{
		
		super(cpf, nome, emailInstitucional, emailSecundario, nascimento);
		this.siape = siape;
		this.unidadeAdministrativa = unidadeAdministrativa;
	}
	
	
	

	public String getSiape() {
		return siape;
	}


	public void setSiape(String siape) {
		this.siape = siape;
	}

	public UnidadeAcademica getUnidadeAcademica() {
		return unidadeAcademica;
	}

	public void setUnidadeAcademica(UnidadeAcademica unidadeAcademica) {
		this.unidadeAcademica = unidadeAcademica;
	}

	public UnidadeAdministrativa getUnidadeAdministrativa() {
		return unidadeAdministrativa;
	}

	public void setUnidadeAdministrativa(UnidadeAdministrativa unidadeAdministrativa) {
		this.unidadeAdministrativa = unidadeAdministrativa;
	}
	
	
	
	
	
	
	
}
