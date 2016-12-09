package pesquisa;
import java.util.ArrayList;

public class Qmulti extends Questao{
	private ArrayList<Item> itens;
	
	public Qmulti(int id_f,int id,String pergunta){
	super(id_f,id,pergunta);
	itens = new ArrayList<Item>();
	}
	
	public Qmulti(String pergunta){
		super(pergunta);
		itens = new ArrayList<Item>();
	}
	
	public void fullyItem(Item i){
		itens.add(i);
	}
	
	public void addItem(int id, String desc){
		Item i = new Item(id,desc);
		itens.add(i);
		
	}
	public void addItemNid(String desc){
		Item i = new Item();
		i.setDescricao(desc);
		itens.add(i);
		
	}
	public ArrayList<Item> getItem(){
		return this.itens;
	}
}
