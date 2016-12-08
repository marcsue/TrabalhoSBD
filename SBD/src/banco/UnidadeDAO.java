package banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import areasUniversidade.Curso;
import areasUniversidade.Unidade;

public class UnidadeDAO 
{
	private Connection connection;
	
	public UnidadeDAO() throws ClassNotFoundException
	{
		this.connection = new ConnectionFactory().getConnection();
	}
	
	
	public ArrayList<Unidade> buscaTodas()
	{
		try
		{
			ArrayList<Unidade> unidades = new ArrayList<Unidade>();
			
			String sql = "SELECT * FROM unidade;";
			PreparedStatement stmt  = connection.prepareStatement(sql);
			
			ResultSet resultado = stmt.executeQuery();
			
			while(resultado.next())
			{
				Unidade uni =  new Unidade();
				
				//o set é de unidade academica o objeto, e o get é do banco de dados o paramentro do get tem que ser igual o nome da coluna no Banco
				uni.setSigla(resultado.getString("sigla"));
				uni.setNome(resultado.getString("nome"));
				uni.setTipo(resultado.getInt("tipo_unidade"));
				
				unidades.add(uni);
			}
			stmt.close();
			
			return unidades;
			
		}
		catch (SQLException e)
		{
			System.out.println(e);
			
			return null;
		}
	}
	
	public Unidade buscaSigla(String sigla) throws SQLException
	{
		
		try
		{
			Unidade unidadeAC = new Unidade();
			
			String sql = "SELECT * FROM unidade WHERE sigla = ?;";
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1,sigla);
			
			ResultSet resultado = stmt.executeQuery();
			
			while(resultado.next())
			{
				unidadeAC.setSigla(resultado.getString("sigla"));
				unidadeAC.setNome(resultado.getString("nome"));
				unidadeAC.setTipo(resultado.getInt("tipo_unidade"));
			}
			stmt.close();
			
			return unidadeAC;
		}
		catch (SQLException e)
		{
			return null;
		}
	}
	
}