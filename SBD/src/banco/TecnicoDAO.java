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
import membrosUniversidade.Tecnico;

public class TecnicoDAO {
	
private Connection connection;
	
	public TecnicoDAO() throws ClassNotFoundException
	{
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public boolean insereTecnico(Tecnico tecnico)
	{
		try
		{
			String sql = "SELECT insereTecnico(?,?,?,?,?,?,?,?);";
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1,tecnico.getCpf());
			stmt.setString(2, tecnico.getNome());
			stmt.setDate(3, (Date) tecnico.getNascimento());
			stmt.setString(4, tecnico.getEmailInstitucional());
			stmt.setString(5, tecnico.getEmailSecundario());
			stmt.setString(6, "tecnico");
			stmt.setString(7, tecnico.getSiape());
			stmt.setString(8, tecnico.getUnidade().getSigla());
			
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
			
			String sql = "SELECT cpf FROM tecnico WHERE cpf=?;";
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
