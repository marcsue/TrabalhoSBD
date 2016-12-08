package areasUniversidade;

public class Unidade 
{
	private String sigla;
	private String nome;
	private int tipo;
	
	public Unidade(String sigla, String nome, int tipo) {
		this.sigla = sigla;
		this.nome = nome;
		
		this.tipo = tipo;
	}
	
	public Unidade() {}

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
	
	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	
}
