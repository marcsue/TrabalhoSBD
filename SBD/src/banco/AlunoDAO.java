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
			String sql = "SELECT insereAluno(?,?,?,?,?,?,?,?,?);";
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1,aluno.getCpf());
			stmt.setString(2, aluno.getNome());
			stmt.setDate(3, (Date) aluno.getNascimento());
			stmt.setString(4, aluno.getEmailInstitucional());
			stmt.setString(5, aluno.getEmailSecundario());
			stmt.setString(6, "aluno");
			stmt.setString(7, aluno.getMatricula());
			stmt.setString(8, aluno.getCurso().getSigla());
			stmt.setString(9, aluno.getCurso().getUnidade().getSigla());
			
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
	
	public boolean buscaCpf(String cpf)
	{
		try
		{
			Aluno aluno =  new Aluno();	
			
			String sql = "SELECT cpf FROM aluno WHERE cpf=?;";
			PreparedStatement stmt  = connection.prepareStatement(sql);
			stmt.setString(1,cpf);
			
			ResultSet resultado = stmt.executeQuery();
			
			while(resultado.next())
			{				
				aluno.setCpf(resultado.getString("cpf"));
			}
			stmt.close();
			
			if(aluno.getCpf()==null)
				return false;
			else
				return true;
		}
		catch (SQLException e)
		{
			System.out.println(e);
			
			return false;
		}
		
	}
	

}

