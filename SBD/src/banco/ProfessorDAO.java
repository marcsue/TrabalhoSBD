package banco;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import areasUniversidade.UnidadeAcademica;
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
			String sql = "INSERT INTO professor (cpf,nome, emailInstitucional, emailSecundario, dataNascimento, siape, regimeTrabalho, siglaUAC) VALUES(?,?,?,?,?,?,?,?);";
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1,professor.getCpf());
			stmt.setString(2, professor.getNome());
			stmt.setString(3, professor.getEmailInstitucional());
			stmt.setString(4, professor.getEmailSecundario());
			stmt.setDate(5, (Date) professor.getNascimento());
			stmt.setString(6, professor.getSiape());
			stmt.setString(7, professor.getRegimeTrabalho());
			stmt.setString(8, professor.getUnidadeAcademica().getSigla());
			
			
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
	
	public ArrayList<Professor> buscaTodos() throws ClassNotFoundException
	{
		try
		{
			ArrayList<Professor> professores = new ArrayList<Professor>();
			UnidadeAcademicaDAO unidadeAcademicaDAO = new UnidadeAcademicaDAO();
			UnidadeAcademica unidadeAcademica = new UnidadeAcademica();
			
			
			String sql = "SELECT * FROM professor;";
			PreparedStatement stmt  = connection.prepareStatement(sql);
			
			ResultSet resultado = stmt.executeQuery();
			
			while(resultado.next())
			{
				Professor professor =  new Professor();
				
				
				professor.setCpf(resultado.getString("cpf"));
				professor.setNome(resultado.getString("nome"));
				professor.setEmailInstitucional(resultado.getString("emailInstitucional"));
				professor.setEmailSecundario(resultado.getString("emailSecundario"));
				professor.setNascimento(resultado.getDate("dataNascimento"));
				professor.setSiape(resultado.getString("siape"));
				professor.setRegimeTrabalho(resultado.getString("regimeTrabalho"));
				
			
				unidadeAcademica = unidadeAcademicaDAO.buscaSigla(resultado.getString("siglaUAC"));
				
				professores.add(professor);
			}
			stmt.close();
			
			return professores;
			
		}
		catch (SQLException e)
		{
			System.out.println(e);
			
			return null;
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
