package banco;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import areasUniversidade.Unidade;
import membrosUniversidade.Professor;
import membrosUniversidade.Terceirizado;

public class TerceirizadoDAO {
	
private Connection connection;
	
	public TerceirizadoDAO() throws ClassNotFoundException
	{
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public boolean insereTerceirizado (Terceirizado terceirizado)
	{
		try
		{
			String sql = "SELECT insereTerceirizado(?,?,?,?,?,?,?,?);";
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1,terceirizado.getCpf());
			stmt.setString(2, terceirizado.getNome());
			stmt.setDate(3, (Date) terceirizado.getNascimento());
			stmt.setString(4, terceirizado.getEmailInstitucional());
			stmt.setString(5, terceirizado.getEmailSecundario());
			stmt.setString(6, "terceirizado");
			stmt.setString(7, terceirizado.getEmpresa());
			stmt.setString(8, terceirizado.getSetor());
			
			
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
			Terceirizado terceirizado =  new Terceirizado();	
			
			String sql = "SELECT cpf FROM terceirizado WHERE cpf=?;";
			PreparedStatement stmt  = connection.prepareStatement(sql);
			stmt.setString(1,cpf);
			
			ResultSet resultado = stmt.executeQuery();
			
			while(resultado.next())
			{
				terceirizado.setCpf(resultado.getString("cpf"));
			}
			stmt.close();
			
			if(terceirizado.getCpf()==null)
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
