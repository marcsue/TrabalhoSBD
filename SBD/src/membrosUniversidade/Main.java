package membrosUniversidade;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import areasUniversidade.Curso;
import areasUniversidade.Unidade;
import areasUniversidade.Unidade;
import banco.AlunoDAO;
import banco.CursoDAO;
import banco.FormularioDAO;
import banco.ProfessorDAO;
import banco.TerceirizadoDAO;
import banco.UnidadeDAO;
import banco.UnidadeDAO;
import interfaces.Janela;
import interfaces.Superior;
import pesquisa.Formulario;
import pesquisa.Questao;
import pesquisa.Resposta;

public class Main {
	
	public static void main (String[] args) throws ClassNotFoundException, SQLException
	{
		
		//Janela.getInstance();
		
		Unidade uni = new Unidade();
		
		UnidadeDAO unidao = new UnidadeDAO ();
		
		
		ArrayList<Unidade> cadastrados = new ArrayList<Unidade>();
		cadastrados = unidao.buscaTodas();
		
		//System.out.println(forD.buscaSigla("facom").getNome());
		
		System.out.println(cadastrados);
		
		for(int i=0;i!=cadastrados.size();i++)
			System.out.println(cadastrados.get(i).getNome()+" "+cadastrados.get(i).getSigla());
		
		
		
	}

}
