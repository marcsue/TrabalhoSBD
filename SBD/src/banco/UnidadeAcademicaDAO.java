package banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
			String sql = "INSERT INTO unidadeAcademica (siglaUA, nome, areaConhecimento) VALUES(?,?,?);";
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
	
	public List<UnidadeAcademica> buscaTodas()
	{
		try
		{
			List<UnidadeAcademica> unidades = new ArrayList<UnidadeAcademica>();
			
			String sql = "SELECT * FROM unidadeAcademica;";
			PreparedStatement stmt  = connection.prepareStatement(sql);
			
			ResultSet resultado = stmt.executeQuery();
			
			while(resultado.next())
			{
				UnidadeAcademica uni =  new UnidadeAcademica();
				
				//o set é de unidade academica o objeto, e o get é do banco de dados o paramentro do get tem que ser igual o nome da coluna no Banco
				uni.setSigla(resultado.getString("siglaUA"));
				uni.setNome(resultado.getString("nome"));
				uni.setAreaConhecimento(resultado.getString("areaConhecimento"));
				
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