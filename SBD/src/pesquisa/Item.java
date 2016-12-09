package pesquisa;

public class Item {
	private int id;
	private String descricao;
	public int getId() {
		return id;
	}
	public Item(){
		
	}
	public Item(int id,String desc){
		this.id = id;
		this.descricao = desc;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
