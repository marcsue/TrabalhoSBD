package areasUniversidade;

public class Curso 
{
	private String sigla;
	private String nome;
	private UnidadeAcademicas unidade;
	
	public Curso(String sigla, String nome, UnidadeAcademicas unidade) {
		super();
		this.sigla = sigla;
		this.nome = nome;
		this.unidade = unidade;
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

	public UnidadeAcademicas getUnidade() {
		return unidade;
	}

	public void setUnidade(UnidadeAcademicas unidade) {
		this.unidade = unidade;
	}
	
	
}
