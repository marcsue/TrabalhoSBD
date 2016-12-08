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
			String sql = "INSERT INTO terceirizado (cpf,nome, emailInstitucional, emailSecundario, dataNascimento, empresa, setor) VALUES(?,?,?,?,?,?,?);";
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1,terceirizado.getCpf());
			stmt.setString(2, terceirizado.getNome());
			stmt.setString(3, terceirizado.getEmailInstitucional());
			stmt.setString(4, terceirizado.getEmailSecundario());
			stmt.setDate(5, (Date) terceirizado.getNascimento());
			stmt.setString(6, terceirizado.getEmpresa());
			stmt.setString(7, terceirizado.getSetor());
			
			
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
	
	public ArrayList<Terceirizado> buscaTodos() throws ClassNotFoundException
	{
		try
		{
			ArrayList<Terceirizado> terceirizados = new ArrayList<Terceirizado>();		
			
			String sql = "SELECT * FROM terceirizado;";
			PreparedStatement stmt  = connection.prepareStatement(sql);
			
			ResultSet resultado = stmt.executeQuery();
			
			while(resultado.next())
			{
				Terceirizado terceirizado =  new Terceirizado();
				
				
				terceirizado.setCpf(resultado.getString("cpf"));
				terceirizado.setNome(resultado.getString("nome"));
				terceirizado.setEmailInstitucional(resultado.getString("emailInstitucional"));
				terceirizado.setEmailSecundario(resultado.getString("emailSecundario"));
				terceirizado.setNascimento(resultado.getDate("dataNascimento"));
				terceirizado.setEmpresa(resultado.getString("empresa"));
				terceirizado.setSetor(resultado.getString("setor"));
		
				
				terceirizados.add(terceirizado);
			}
			stmt.close();
			
			return terceirizados;
			
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
