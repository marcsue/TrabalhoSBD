package membrosUniversidade;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import areasUniversidade.Curso;
import areasUniversidade.UnidadeAcademica;
import banco.AlunoDAO;
import banco.CursoDAO;
import banco.FormularioDAO;
import banco.UnidadeAcademicaDAO;
import pesquisa.Formulario;
import pesquisa.Questao;
import pesquisa.Resposta;

public class Main {
	
	public static void main (String[] args) throws ClassNotFoundException, SQLException
	{
		
		AlunoDAO forD = new AlunoDAO();
		
		Date nascimento = new Date(1900, 0, 1);
		Date nascimentoj = new Date((2021-1901), 12, 12);
		
		UnidadeAcademica facom = new UnidadeAcademica("facom", "computacao", "exatas");
		Curso comp = new Curso("bcc","comp", facom);
		
		Aluno aluno1= new Aluno("222", "jose", "jose2", "jose3", nascimento, "11411", comp);
		Aluno aluno2= new Aluno("233", "jao", "jose2", "jose3", nascimentoj, "11411BCC", comp);
		
		boolean flag = forD.insereAluno(aluno2);
		
		ArrayList<Aluno> cadastrados = new ArrayList<Aluno>();
		cadastrados = forD.buscaTodos();
		
		//System.out.println(forD.buscaSigla("facom").getNome());
		
		System.out.println(cadastrados);
		
		for(int i=0;i!=cadastrados.size();i++)
			System.out.println(cadastrados.get(i).getNome());
		
		
	}

}
