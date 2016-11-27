package banco;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import areasUniversidade.Curso;
import membrosUniversidade.Aluno;
import pesquisa.Formulario;

public class AlunoDAO 
{
	private Connection connection;
	
	public AlunoDAO() throws ClassNotFoundException
	{
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public boolean insereAluno(Aluno aluno)
	{
		try
		{
			String sql = "INSERT INTO aluno (cpf,nome, emailInstitucional, emailSecundario, dataNascimento, matricula,siglaCurso) VALUES(?,?,?,?,?,?,?);";
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1,aluno.getCpf());
			stmt.setString(2, aluno.getNome());
			stmt.setString(3, aluno.getEmailInstitucional());
			stmt.setString(4, aluno.getEmailSecundario());
			stmt.setDate(5, (Date) aluno.getNascimento());
			stmt.setString(6, aluno.getMatricula());
			stmt.setString(7, aluno.getCurso().getSigla());	
			
			stmt.execute();
			stmt.close();
			
			return true;
		}
		catch (SQLException e)
		{
			System.out.println(e);
			return false;
		}
	}
	
	public ArrayList<Aluno> buscaTodos() throws ClassNotFoundException
	{
		try
		{
			ArrayList<Aluno> alunos = new ArrayList<Aluno>();
			CursoDAO cursoDAO = new CursoDAO();
			
			
			String sql = "SELECT * FROM aluno;";
			PreparedStatement stmt  = connection.prepareStatement(sql);
			
			ResultSet resultado = stmt.executeQuery();
			
			while(resultado.next())
			{
				Aluno aluno =  new Aluno();
				
				aluno.setCpf(resultado.getString("cpf"));
				aluno.setNome(resultado.getString("nome"));
				aluno.setEmailInstitucional(resultado.getString("emailInstitucional"));
				aluno.setEmailSecundario(resultado.getString("emailSecundario"));
				aluno.setNascimento(resultado.getDate("dataNascimento"));
				aluno.setMatricula(resultado.getString("matricula"));
				
				
				Curso curso = new Curso();
				curso = cursoDAO.buscaSigla(resultado.getString("siglaCurso"));
				
				alunos.add(aluno);
			}
			stmt.close();
			
			return alunos;
			
		}
		catch (SQLException e)
		{
			System.out.println(e);
			
			return null;
		}
	}
	

}

