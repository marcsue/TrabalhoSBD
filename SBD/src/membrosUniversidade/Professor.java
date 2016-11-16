package membrosUniversidade;

import java.util.Date;

import areasUniversidade.UnidadeAcademicas;

public class Professor extends Pessoas 
{
	private String siape;
	private UnidadeAcademicas unidadeAcademica;
	private String regimeTrabalho;
	
	public Professor(String cpf, String nome, String emailInstitucional,
			String emailSecundario, Date nascimento, String siape, UnidadeAcademicas unidadeAcademica,
			String regimeTrabalho) 
	{
		
		super(cpf, nome, emailInstitucional, emailSecundario, nascimento);
		this.siape = siape;
		this.unidadeAcademica = unidadeAcademica;
		this.regimeTrabalho = regimeTrabalho;
	}

	public String getSiape() {
		return siape;
	}

	public void setSiape(String siape) {
		this.siape = siape;
	}

	public UnidadeAcademicas getUnidadeAcademica() {
		return unidadeAcademica;
	}

	public void setUnidadeAcademica(UnidadeAcademicas unidadeAcademica) {
		this.unidadeAcademica = unidadeAcademica;
	}

	public String getRegimeTrabalho() {
		return regimeTrabalho;
	}

	public void setRegimeTrabalho(String regimeTrabalho) {
		this.regimeTrabalho = regimeTrabalho;
	}
	
	
	
}
