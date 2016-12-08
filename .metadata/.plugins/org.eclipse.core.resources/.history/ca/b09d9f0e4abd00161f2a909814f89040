package banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import areasUniversidade.Curso;
import areasUniversidade.Unidade;
import pesquisa.Formulario;

public class CursoDAO 
{
private Connection connection;
	
	public CursoDAO() throws ClassNotFoundException
	{
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public boolean insereCurso(Curso curso)
	{
		try
		{
			String sql = "INSERT INTO curso (sigla, nome, unidade_academica) VALUES(?,?,?);";
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1,curso.getSigla());
			stmt.setString(2,curso.getNome());
			stmt.setString(3,curso.getUnidade().getSigla());
			
			
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
	
	public ArrayList<Curso> buscaTodos() throws SQLException, ClassNotFoundException
	{
		
		try
		{
			UnidadeDAO uniDAO = new UnidadeDAO();
			Curso curso = new Curso();
			
			ArrayList<Curso> cursos = new ArrayList<Curso>();
			
			String sql = "SELECT * FROM curso;";
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			ResultSet resultado = stmt.executeQuery();
			
			while(resultado.next())
			{
				
				curso.setSigla(resultado.getString("sigla"));
				curso.setNome(resultado.getString("nome"));
				
				Unidade unidade = uniDAO.buscaSigla(resultado.getString("unidadeAC"));
				
				curso.setUnidade(unidade);
				cursos.add(curso);
			}
			
			stmt.close();
			
			return cursos;
		}
		catch (SQLException e)
		{
			return null;
		}
	}
	
	
	
	
	public Curso buscaSigla(String sigla) throws SQLException, ClassNotFoundException
	{
		
		try
		{
			UnidadeDAO uniDAO = new UnidadeDAO();
			Curso curso = new Curso();
			
			String sql = "SELECT * FROM curso WHERE sigla = ?;";
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1,sigla);
			
			ResultSet resultado = stmt.executeQuery();
			
			while(resultado.next())
			{
				
				curso.setSigla(resultado.getString("sigla"));
				curso.setNome(resultado.getString("nome"));
				
				Unidade unidade = uniDAO.buscaSigla(resultado.getString("unidadeAC"));
				
				curso.setUnidade(unidade);
			}
			
			stmt.close();
			
			return curso;
		}
		catch (SQLException e)
		{
			return null;
		}
	}
}







