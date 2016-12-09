package banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pesquisa.Formulario;
import pesquisa.Item;
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
			String sql = "INSERT INTO formulario VALUES(DEFAULT,?,?,?,?,?);";
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			
			//stmt.setInt(1,"DEFAULT");
			stmt.setString(5,formulario.getTitulo());
			stmt.setString(1, formulario.getCpf());
			stmt.setInt(2, formulario.getTipo_restricao());
			stmt.setDate(3, formulario.getData_inicio());
			stmt.setDate(4, formulario.getData_fim());	
			stmt.execute();
			
			//pegar id do formulário
			sql = "SELECT MAX(id) FROM formulario";
			PreparedStatement stmt2  = connection.prepareStatement(sql);			
			ResultSet resultado = stmt2.executeQuery();
			resultado.next();
			int form_id_novo = resultado.getInt("max");
			
			for(int i=0; i!= formulario.getQuestoes().size();i++)
			{
				if(formulario.getQuestoes().get(i) instanceof Qmulti)
				{
					String insere = "INSERT INTO mult VALUES (DEFAULT,?,?);";
					PreparedStatement stmt3 = connection.prepareStatement(insere);
					
					stmt3.setInt(1, form_id_novo);
					stmt3.setString(2, ((Qmulti)(formulario.getQuestoes().get(i))).getDescricao());
					stmt3.execute();

					//pegar ultimo ID questão multipla
					sql = "SELECT MAX(id) FROM mult";
					PreparedStatement stmt4  = connection.prepareStatement(sql);	
					//ArrayList <ResultSet> resultados = new ArrayList<ResultSet>();
					//resultados.add(stmt4.executeQuery());
					//result = resultados.get(i);
					ResultSet res = stmt4.executeQuery();
					res.next();
					int q_id = res.getInt("max");
					for(Item a: ((Qmulti)(formulario.getQuestoes().get(i))).getItem()){																					
						String sqlint = "INSERT INTO item VALUES (DEFAULT,?,?);";
						PreparedStatement stmt5 = connection.prepareStatement(sqlint);
						stmt5.setInt(1, q_id);
						stmt5.setString(2, a.getDescricao());
						stmt5.execute();

					}
					
				}
				else	
				{
					
					String insere = "INSERT INTO  texto VALUES (DEFAULT,?,?);";
					PreparedStatement stmt3 = connection.prepareStatement(insere);
					
					stmt3.setInt(1, form_id_novo);
					stmt3.setString(2, ((Qtexto)(formulario.getQuestoes().get(i))).getDescricao());
					stmt3.execute();
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
			
				String sql = "SELECT * FROM rmult WHERE id_form = "+q.getId_form()+" AND id_mult = "+q.getId()+";";

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
						String resposta = resultado.getString("descri");
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
