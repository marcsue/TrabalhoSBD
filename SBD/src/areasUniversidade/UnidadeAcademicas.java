package areasUniversidade;

public class UnidadeAcademicas 
{
	private String sigla;
	private String nome;
	private String areaConhecimento;
	
	public UnidadeAcademicas(String sigla, String nome, String areaConhecimento) {
		this.sigla = sigla;
		this.nome = nome;
		this.areaConhecimento = areaConhecimento;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAreaConhecimento() {
		return areaConhecimento;
	}

	public void setAreaConhecimento(String areaConhecimento) {
		this.areaConhecimento = areaConhecimento;
	}
	
	
	
}
