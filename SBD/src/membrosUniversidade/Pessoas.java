package membrosUniversidade;

import java.util.Date;

public abstract class Pessoas {
	private String cpf;
	private String nome;
	private String emailInstitucional;
	private String emailSecundario;
	private Date nascimento;
	
	public Pessoas() {
	}
	
	public Pessoas(String cpf, String nome, String emailInstitucional,
			String emailSecundario, Date nascimento) 
	{
	
		this.cpf = cpf;
		this.nome = nome;
		this.emailInstitucional = emailInstitucional;
		this.emailSecundario = emailSecundario;
		this.nascimento = nascimento;
	}



	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmailInstitucional() {
		return emailInstitucional;
	}
	public void setEmailInstitucional(String emailInstitucional) {
		this.emailInstitucional = emailInstitucional;
	}
	public String getEmailSecundario() {
		return emailSecundario;
	}
	public void setEmailSecundario(String emailSecundario) {
		this.emailSecundario = emailSecundario;
	}
	public Date getNascimento() {
		return nascimento;
	}
	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}
	
	

}
