package membrosUniversidade;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import areasUniversidade.Curso;
import areasUniversidade.UnidadeAcademica;
import areasUniversidade.UnidadeAdministrativa;
import banco.AlunoDAO;
import banco.CursoDAO;
import banco.FormularioDAO;
import banco.ProfessorDAO;
import banco.TerceirizadoDAO;
import banco.UnidadeAcademicaDAO;
import banco.UnidadeAdministrativaDAO;
import interfaces.Janela;
import pesquisa.Formulario;
import pesquisa.Questao;
import pesquisa.Resposta;

public class Main {
	
	public static void main (String[] args) throws ClassNotFoundException, SQLException
	{
		
		Janela.getInstance();
		
		
		/*TerceirizadoDAO forD = new TerceirizadoDAO();
		
		Date nascimentoj = new Date(1901, 0, 1);
		
		UnidadeAdministrativaDAO unidao= new UnidadeAdministrativaDAO();
		UnidadeAdministrativa unida = new UnidadeAdministrativa("progr", "pro grad ");
		//Curso comp = new Curso("bcc","comp", facom);
		
		
		unidao.insereUnidadeAdm(unida);
		
		
		//Aluno aluno1= new Aluno("222", "jose", "jose2", "jose3", nascimento, "11411", comp);
	//	Aluno aluno2= new Aluno("233", "jao", "jose2", "jose3", nascimentoj, "11411BCC", comp);
		
		Terceirizado prof = new Terceirizado("233", "jao", "jose2", "jose3", nascimentoj, "mm","adm");
		
		//boolean flag = forD.insereTerceirizado(prof);
		
		ArrayList<UnidadeAdministrativa> cadastrados = new ArrayList<UnidadeAdministrativa>();
		cadastrados = unidao.buscaTodas();
		
		//System.out.println(forD.buscaSigla("facom").getNome());
		
		System.out.println(cadastrados);
		
		for(int i=0;i!=cadastrados.size();i++)
			System.out.println(cadastrados.get(i).getNome()+" "+cadastrados.get(i).getSigla());
		*/
		
		
	}

}
