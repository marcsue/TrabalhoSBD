package banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import pesquisa.Resposta;
import pesquisa.RespostaMulti;
import pesquisa.RespostaTexto;

public class RespostaDAO {
	
	private Connection connection;
	
	public RespostaDAO() throws ClassNotFoundException
	{
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public boolean insereResposta(Resposta resp,int flag)
	{
		try{
			if(flag == 0){ //rTexto
			
				String  sql = "INSERT INTO rtexto VALUES(?,?,?,?);";
				PreparedStatement stmt = connection.prepareStatement(sql);
				
				stmt.setString(1, "DEFAULT");
				stmt.setInt(2, resp.getId());
				stmt.setString(3, resp.getCpfp());
				stmt.setString(4, ((RespostaTexto)resp).getResp());
				
				stmt.execute();
				stmt.close();
				return true;
			}
			else{ //1 = rMult
				String  sql = "INSERT INTO rmult VALUES(?,?,?,?);";
				PreparedStatement stmt = connection.prepareStatement(sql);
				
				stmt.setString(1, "DEFAULT");
				stmt.setInt(2, ((RespostaMulti)resp).getResp());
				stmt.setInt(3, resp.getId());
				stmt.setString(4, resp.getCpfp());

				
				stmt.execute();
				stmt.close();
				return true;				
			}
		}
		catch(SQLException e){
			System.out.println(e);
			return false;
		}
		
	}
}
