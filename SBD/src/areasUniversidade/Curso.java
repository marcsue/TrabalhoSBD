package areasUniversidade;

public class Curso 
{
	private String sigla;
	private String nome;
	private Unidade unidade;
	
	
	public Curso (){}
	
	public Curso(String sigla, String nome, Unidade unidade) {
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

	public Unidade getUnidade() {
		return unidade;
	}

	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}
	
	
}
