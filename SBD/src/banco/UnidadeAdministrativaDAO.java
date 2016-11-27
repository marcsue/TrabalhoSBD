package banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import areasUniversidade.Curso;
import areasUniversidade.UnidadeAcademica;
import areasUniversidade.UnidadeAdministrativa;

public class UnidadeAdministrativaDAO
{
	private Connection connection;
	
	public UnidadeAdministrativaDAO() throws ClassNotFoundException
	{
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public boolean insereUnidadeAdm(UnidadeAdministrativa unidadeAdministrativa)
	{
		try
		{
			String sql = "INSERT INTO unidadeAdministrativa (siglaUADM, nome) VALUES(?,?);";
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1,unidadeAdministrativa.getSigla());
			stmt.setString(2, unidadeAdministrativa.getNome());
	
			
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
	
	public ArrayList<UnidadeAdministrativa> buscaTodas()
	{
		try
		{
			ArrayList<UnidadeAdministrativa> unidades = new ArrayList<UnidadeAdministrativa>();
			
			String sql = "SELECT * FROM unidadeAdministrativa;";
			PreparedStatement stmt  = connection.prepareStatement(sql);
			
			ResultSet resultado = stmt.executeQuery();
			
			while(resultado.next())
			{
				UnidadeAdministrativa uni =  new UnidadeAdministrativa();
				
				//o set é de unidade academica o objeto, e o get é do banco de dados o paramentro do get tem que ser igual o nome da coluna no Banco
				uni.setSigla(resultado.getString("siglaUADM"));
				uni.setNome(resultado.getString("nome"));
				
				
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
	

	
}