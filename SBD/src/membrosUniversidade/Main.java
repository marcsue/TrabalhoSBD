package membrosUniversidade;

import areasUniversidade.UnidadeAcademica;
import banco.UnidadeAcademicaDAO;

public class Main {
	
	public static void main (String[] args) throws ClassNotFoundException
	{
		UnidadeAcademica unidade = new UnidadeAcademica("facom", "facul de comp", "exatas");
		
		UnidadeAcademicaDAO uniDAO = new UnidadeAcademicaDAO();
		
		System.out.println(uniDAO.insereUnidade(unidade));
	}

}
