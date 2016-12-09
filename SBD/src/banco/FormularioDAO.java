package banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pesquisa.Formulario;
import pesquisa.Qmulti;
import pesquisa.Qtexto;
import pesquisa.Questao;
import pesquisa.Resposta;
import pesquisa.RespostaMulti;
import pesquisa.RespostaTexto;

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
			String sql = "INSERT INTO formulario VALUES(?,?,?,?,?,?);";
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1,"DEFAULT");
			stmt.setString(2,formulario.getTitulo());
			stmt.setString(3, formulario.getCpf());
			stmt.setInt(4, formulario.getTipo_restricao());
			stmt.setDate(5, formulario.getData_inicio());
			stmt.setDate(6, formulario.getData_fim());	
			
			stmt.execute();
			stmt.close();
			
			
			for(int i=0; i!= formulario.getQuestoes().size();i++)
			{
				if(formulario.getQuestoes().get(i) instanceof Qmulti)
				{
					String insere = "INSERT INTO multi VALUES (?,?,?);";
					stmt = connection.prepareStatement(insere);
					
					stmt.setInt(1, ((Qmulti)(formulario.getQuestoes().get(i))).getId());
					stmt.setInt(2, ((Qmulti)(formulario.getQuestoes().get(i))).getId_form());
					stmt.setString(3, ((Qmulti)(formulario.getQuestoes().get(i))).getDescricao());
					
					
				}
				else	
				{
					String insere = "INSERT INTO  texto VALUES (?,?,?);";
					stmt = connection.prepareStatement(insere);
					
					stmt.setInt(1, ((Qmulti)(formulario.getQuestoes().get(i))).getId());
					stmt.setInt(2, ((Qmulti)(formulario.getQuestoes().get(i))).getId_form());
					stmt.setString(3, ((Qmulti)(formulario.getQuestoes().get(i))).getDescricao());
					
				}
					
			}
			
			return true;			
	
		}
		catch (SQLException e)
		{
			System.out.println(e);
			return false;
		}
		
	}
	
	private Object Qmulti(Questao questao) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ArrayList<String> buscaTitulo(){
		try
		{
			ArrayList<String> titulos = new ArrayList<String>();
			
			String sql = "SELECT titulo FROM formulario;";

			PreparedStatement stmt  = connection.prepareStatement(sql);
			
			ResultSet resultado = stmt.executeQuery();
			
			while(resultado.next())
			{
				String til =  new String();
				til = resultado.getString("titulo");				
				
				titulos.add(til);
			}
			stmt.close();
			
			if(titulos.isEmpty()){
				titulos.add("Nenhum resultado");
			}
			
			return titulos;
			
		}
		catch (SQLException e)
		{
			System.out.println(e);
			
			return null;
		}
	}		
	
	
	public ArrayList<Formulario> buscaTodos() // Retorna todos os formulários possíveis e suas informações;
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
				forms.setTitulo(resultado.getString("titulo"));
				forms.setCpf(resultado.getString("cpf_criador"));
				forms.setData_inicio(resultado.getDate("data_inicial"));
				forms.setData_fim(resultado.getDate("data_final"));
				forms.setTipo_restricao(resultado.getInt("tipo_restricao"));				
				
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
	
	public Formulario buscaForm(Formulario inc) // Retorna o formulários com todas as informações(respostas, questï¿½es, tudo)
	//RECEBE um formulários incompleto;
	{
		try
		{
		
			//String subsql1 = "";";
			//String subsql2 = "SELECT * FROM texto WHERE id_form = "+resultado.getInt("id")+";"; 
			String sql = "SELECT * FROM mult WHERE id_form = "+inc.getId()+";";

			PreparedStatement stmt  = connection.prepareStatement(sql);
			
			ResultSet resultado = stmt.executeQuery();
			
			if(resultado != null){
				while(resultado.next())
				{
				//Encontrando as perguntas de multipla escolha e suas respostas e quem respondeu
					
					int id = resultado.getInt("id");
					int id_form = resultado.getInt("id_form");
					String pergunta = resultado.getString("pergunta");
					Questao quest =  new Qmulti(id_form,id,pergunta);
					quest = findResp(quest,1);
					quest = findItens((Qmulti)quest);
					inc.addQuestao(quest);
				}
			}
			
			stmt.close();
			try //Pegando todas as questões de texto, suas respostas e quem respondeu;
			{
				sql = "SELECT * FROM texto WHERE id_form = "+inc.getId()+";";

				stmt  = connection.prepareStatement(sql);
				
				resultado = stmt.executeQuery();
				
				if(resultado != null){
					while(resultado.next())
					{
					//Encontrando as perguntas de multipla escolha e suas respostas
						
						int id = resultado.getInt("id");
						int id_form = resultado.getInt("id_form");
						String pergunta = resultado.getString("pergunta");
						Questao questt =  new Qtexto(id_form,id,pergunta);	
						questt = findResp(questt,2);
						inc.addQuestao(questt);
					}
				}
				
				stmt.close();
				
				return inc;
				
			}
			catch (SQLException e)
			{
				System.out.println(e);
				
				return null;
			}
			
		}
		catch (SQLException e)
		{
			System.out.println(e);
			
			return null;
		}

	}
	private Questao findResp(Questao q,int flag) {
		if(flag == 2){
			try //Pegando as respostas de uma questão
			{
			
				String sql = "SELECT * FROM rtexto WHERE id_form = "+q.getId_form()+" AND id_texto = "+q.getId()+";";

				PreparedStatement stmt  = connection.prepareStatement(sql);
			
				ResultSet resultado = stmt.executeQuery();
			
				if(resultado != null){
					while(resultado.next())
					{
					//Encontrando as perguntas de texto  escolha e suas respostas
					
						int id = resultado.getInt("id_form");
						String resposta = resultado.getString("resposta");
						String cpf_p = resultado.getString("cpf_pessoa");
						Resposta resp =  new  RespostaTexto(id,resposta,cpf_p);	
						q.addResposta(resp);
					}
				}
			
				stmt.close();
			
				return q;
			
			}
			catch (SQLException e)
			{
				System.out.println(e);
			
				return null;
			}
		}
		else if(flag == 1){
			try //Pegando as respostas multiplaescolha de uma questão
			{
			
				String sql = "SELECT * FROM rmulti WHERE id_form = "+q.getId_form()+" AND id_mult = "+q.getId()+";";

				PreparedStatement stmt  = connection.prepareStatement(sql);
			
				ResultSet resultado = stmt.executeQuery();
			
				if(resultado != null){
					while(resultado.next())
					{
					//Encontrando as perguntas de multipla escolha e suas respostas
						int id = resultado.getInt("id_form");
						int resposta = resultado.getInt("id_item");
						String cpf_p = resultado.getString("cpf_pessoa");
						Resposta resp =  new  RespostaMulti(id,resposta,cpf_p);	
						q.addResposta(resp);
					}
				}
			
				stmt.close();
			
				return q;
			
			}
			catch (SQLException e)
			{
				System.out.println(e);
			
				return null;
			}
		}		
		return q;
	}
	private Qmulti findItens(Qmulti q){
			try //Pegando OS ITENS multiplaescolha de uma questão
			{
				q = (Qmulti)q;
				String sql = "SELECT * FROM item WHERE id_questao = "+q.getId()+";";

				PreparedStatement stmt  = connection.prepareStatement(sql);
			
				ResultSet resultado = stmt.executeQuery();
			
				if(resultado != null){
					while(resultado.next())
					{
					//Encontrando as perguntas de multipla escolha e suas respostas
					
						int id = resultado.getInt("id");
						String resposta = resultado.getString("descricacao");
						q.addItem(id, resposta);
					}
				}
			
				stmt.close();
			
				return q;
			
			}
			catch (SQLException e)
			{
				System.out.println(e);
			
				return null;
			}		
	}

	
	
}
