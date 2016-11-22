package membrosUniversidade;

import java.util.ArrayList;
import java.util.List;

import areasUniversidade.UnidadeAcademica;
import banco.UnidadeAcademicaDAO;

public class Main {
	
	public static void main (String[] args) throws ClassNotFoundException
	{
		
		UnidadeAcademicaDAO uniDAO = new UnidadeAcademicaDAO();
	
		
		
		List<UnidadeAcademica> unidades = new ArrayList<UnidadeAcademica>();
		
		unidades=uniDAO.buscaTodas();
		
		for (int i = 0;i<unidades.size();i++)
			System.out.println(unidades.get(i).getSigla());
	
	}

}
