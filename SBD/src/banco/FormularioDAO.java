package banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import areasUniversidade.UnidadeAcademica;
import pesquisa.Formulario;

public class FormularioDAO 
{
	private Connection connection;
	
	public FormularioDAO() throws ClassNotFoundException
	{
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public boolean insereForm(Formulario formulario)
	{
		try
		{
			String sql = "INSERT INTO formulario (descricao) VALUES(?);";
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1,formulario.getDescricao());
			
			
			
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
	
	public ArrayList<Formulario> buscaTodos()
	{
		try
		{
			ArrayList<Formulario> formularios = new ArrayList<Formulario>();
			
			String sql = "SELECT * FROM formulario;";
			PreparedStatement stmt  = connection.prepareStatement(sql);
			
			ResultSet resultado = stmt.executeQuery();
			
			while(resultado.next())
			{
				Formulario forms =  new Formulario();
				
				forms.setId(resultado.getInt("id"));
				forms.setDescricao(resultado.getString("descricao"));
				
				
				formularios.add(forms);
			}
			stmt.close();
			
			return formularios;
			
		}
		catch (SQLException e)
		{
			System.out.println(e);
			
			return null;
		}
	}
	
	

	
	
}
