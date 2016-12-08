package pesquisa;
import java.util.ArrayList;

public class Qmulti extends Questao{
	private ArrayList<Item> itens;
	
	public Qmulti(int id,String pergunta)
	{
		super(id,pergunta);
		itens = new ArrayList<Item>();
	}
}
