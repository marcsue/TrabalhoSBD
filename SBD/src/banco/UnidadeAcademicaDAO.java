package banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import areasUniversidade.UnidadeAcademica;

public class UnidadeAcademicaDAO 
{
	private Connection connection;
	
	public UnidadeAcademicaDAO() throws ClassNotFoundException
	{
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public boolean insereUnidade(UnidadeAcademica unidadeAcademica)
	{
		try
		{
			String sql = "insert into unidadeAcademica (siglaUA, nome, areaConhecimento) values(?,?,?)";
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1,unidadeAcademica.getSigla());
			stmt.setString(2, unidadeAcademica.getNome());
			stmt.setString(3, unidadeAcademica.getAreaConhecimento());
			
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
}
