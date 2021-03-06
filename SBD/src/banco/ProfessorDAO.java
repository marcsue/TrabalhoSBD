package banco;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import areasUniversidade.Unidade;
import membrosUniversidade.Aluno;
import membrosUniversidade.Professor;

public class ProfessorDAO {
	
private Connection connection;
	
	public ProfessorDAO() throws ClassNotFoundException
	{
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public boolean insereProfessor(Professor professor)
	{
		try
		{
			String sql = "SELECT insereProfessor(?,?,?,?,?,?,?,?,?);";
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1,professor.getCpf());
			stmt.setString(2, professor.getNome());
			stmt.setDate(3, (Date) professor.getNascimento());
			stmt.setString(4, professor.getEmailInstitucional());
			stmt.setString(5, professor.getEmailSecundario());
			stmt.setString(6, "professor");
			stmt.setString(7, professor.getSiape());
			stmt.setString(8, professor.getRegimeTrabalho());
			stmt.setString(9, professor.getUnidadeAcademica().getSigla());
			
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
			Professor prof =  new Professor();	
			
			String sql = "SELECT cpf FROM professor WHERE cpf=?;";
			PreparedStatement stmt  = connection.prepareStatement(sql);
			stmt.setString(1,cpf);
			
			ResultSet resultado = stmt.executeQuery();
			
			while(resultado.next())
			{
				
				
				prof.setCpf(resultado.getString("cpf"));
			}
			stmt.close();
			
			if(prof.getCpf()==null)
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
