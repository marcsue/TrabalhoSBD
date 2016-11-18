package membrosUniversidade;

import java.util.ArrayList;

import areasUniversidade.UnidadeAcademica;
import banco.UnidadeAcademicaDAO;

public class Main {
	
	public static void main (String[] args) throws ClassNotFoundException
	{
		//UnidadeAcademica unidade = new UnidadeAcademica("famat", "facul de mat", "exatas");
		//uniDAO.insereUnidade(unidade);
		
		UnidadeAcademicaDAO uniDAO = new UnidadeAcademicaDAO();
		
		ArrayList<UnidadeAcademica> unidades = new ArrayList<UnidadeAcademica>();
		unidades = uniDAO.buscaTodas();
		
		for(int i=0;i<unidades.size();i++)
			System.out.println(unidades.get(i).getSigla()+" "+unidades.get(i).getNome());
	}

}
