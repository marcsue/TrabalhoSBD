package pesquisa;

public class Resposta 
{
	private Integer id; //Idformulario
	
	private String cpf_pessoa;

	public Resposta(){}
	
	public Resposta(int id ,String cpf) {
		this.id = id;
		this.cpf_pessoa = cpf;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public String getCpfp() {
		return cpf_pessoa;
	}

	public void setCpfp(String cpf_pessoa) {
		this.cpf_pessoa = cpf_pessoa;
	}
	
	

}
