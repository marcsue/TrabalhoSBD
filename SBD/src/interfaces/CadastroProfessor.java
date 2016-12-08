package interfaces;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import membrosUniversidade.Aluno;
import membrosUniversidade.Professor;
import areasUniversidade.Curso;
import areasUniversidade.Unidade;
import banco.AlunoDAO;
import banco.CursoDAO;
import banco.ProfessorDAO;
import banco.UnidadeDAO;

public class CadastroProfessor extends JPanel implements ActionListener{

	public JLabel titulo;
	public JLabel cpf; 
	public JLabel nome;
	public JLabel emailInstitucional;
	public JLabel emailSecundario;
	public JLabel dtaNasc;
	public JLabel siape;
	public JLabel regimeTrabalho;//label p/ o combo
	public JLabel unidadeTrabalho;//label p/ o combo
	
	public JTextField caixaCpf;
	public JTextField caixaNome;
	public JTextField caixaEmailInstitucional;
	public JTextField caixaEmailSecundario;
	public JTextField caixaDia;//dta de nascimento
	public JTextField caixaMes;
	public JTextField caixaAno;
	public JTextField caixaSiape;
	
	
	//public JTextField caixaSiglaCurso;

	public JComboBox comboRegimeTrab;//combo p/ o label
	public JComboBox comboUnidadeTrab;//combo p/ o label
	
	public JButton salvar;
	public JButton voltar;
	
	public CadastroProfessor () {
		super();
		this.setSize(1366, 768);		
		this.setLayout(null);
		

		//LABEL TITULO
		titulo = new JLabel("CADASTRO DE PROFESSOR");
		titulo.setBounds(20, 1, 200, 30);
		titulo.setVisible(true);
		this.add(titulo);
		
		//LABEL CPF
		cpf = new JLabel("CPF:");
		cpf.setBounds(20, 30, 200, 30);
		cpf.setVisible(true);
		this.add(cpf);
				
		//LABEL NOME
		nome = new JLabel("NOME:");
		nome.setBounds(20, 60, 200, 30);
		nome.setVisible(true);
		this.add(nome);
				
		//LABEL EMAIL INSTITUCIONAL
		emailInstitucional = new JLabel("E-MAIL INSTITUCIONAL:");
		emailInstitucional.setBounds(20, 90, 200, 30);
		emailInstitucional.setVisible(true);
		this.add(emailInstitucional);
				
		//LABEL EMAIL SECUNDARIO
		emailSecundario = new JLabel("E-MAIL SECUNDARIO:");
		emailSecundario.setBounds(20, 120, 200, 30);
		emailSecundario.setVisible(true);
		this.add(emailSecundario);
				
		//LABEL DTA DE NASCIMENTO
		dtaNasc = new JLabel("DATA DE NASCIMENTO:");
		dtaNasc.setBounds(20, 150, 200, 30);
		dtaNasc.setVisible(true);
		this.add(dtaNasc);
		
		//LABEL SIAPE
		siape = new JLabel("SIAPE:");
		siape.setBounds(20, 180, 200, 30);
		siape.setVisible(true);
		this.add(siape);
		
		//LABEL REGIME DE TRABALHO
		regimeTrabalho = new JLabel("REGIME DE TRABALHO:");
		regimeTrabalho.setBounds(20, 240, 200, 30);
		regimeTrabalho.setVisible(true);
		this.add(regimeTrabalho);
		
		//COMBO REGIME DE TRABALHO
		comboRegimeTrab = new JComboBox();
		comboRegimeTrab.setBounds(182, 246, 200, 20);
		comboRegimeTrab.setVisible(true);
		comboRegimeTrab.addItem("");
		comboRegimeTrab.addItem("20H");
		comboRegimeTrab.addItem("40H");
		comboRegimeTrab.addItem("DEX");
		this.add(comboRegimeTrab);
		comboRegimeTrab.addActionListener(this);
		
		//LABEL UNIDADE DE TRABALHO
		unidadeTrabalho = new JLabel("UNIDADE DE TRABALHO:");
		unidadeTrabalho.setBounds(20, 210, 200, 30);
		unidadeTrabalho.setVisible(true);
		this.add(unidadeTrabalho);
				
		//COMBO UNIDADE DE TRABALHO
		comboUnidadeTrab = new JComboBox();
		comboUnidadeTrab.setBounds(195, 216, 200, 20);
		comboUnidadeTrab.setVisible(true);
		comboUnidadeTrab.addItem("");
		comboUnidadeTrab.addItem("FACOM");
		comboUnidadeTrab.addItem("FEELT");
		comboUnidadeTrab.addItem("FAMAT");
		comboUnidadeTrab.addItem("PROGR");
		comboUnidadeTrab.addItem("PROPO");
		this.add(comboUnidadeTrab);
		comboUnidadeTrab.addActionListener(this);
		
		//CAIXA CPF
		caixaCpf = new JTextField();
		caixaCpf.setBounds(60, 37, 150, 20);
		caixaCpf.setVisible(true);
		this.add(caixaCpf);
		
		//CAIXA NOME
		caixaNome = new JTextField();
		caixaNome.setBounds(74, 67, 150, 20);
		caixaNome.setVisible(true);
		this.add(caixaNome);
		
		//CAIXA EMAIL INSTITUCIONAL
		caixaEmailInstitucional = new JTextField();
		caixaEmailInstitucional.setBounds(188, 97, 150, 20);
		caixaEmailInstitucional.setVisible(true);
		this.add(caixaEmailInstitucional);
		
		//CAIXA EMAIL SECUNDARIO
		caixaEmailSecundario = new JTextField();
		caixaEmailSecundario.setBounds(173, 127, 150, 20);
		caixaEmailSecundario.setVisible(true);
		this.add(caixaEmailSecundario);
		
		//DTA DE NASCIMENTO
		//CAIXA DIA
		caixaDia = new JTextField("D");
		caixaDia.setBounds(186, 157, 20, 20);
		caixaDia.setVisible(true);
		this.add(caixaDia);
		
		//CAIXA MES
		caixaMes = new JTextField("MM");
		caixaMes.setBounds(216, 157, 30, 20);
		caixaMes.setVisible(true);
		this.add(caixaMes);
				
		//CAIXA ANO
		caixaAno = new JTextField("AAAA");
		caixaAno.setBounds(256, 157, 60, 20);
		caixaAno.setVisible(true);
		this.add(caixaAno);
		
		//CAIXA SIAPE
		caixaSiape = new JTextField();
		caixaSiape.setBounds(73, 187, 150, 20);
		caixaSiape.setVisible(true);
		this.add(caixaSiape);
		
		//BOTAO SALVAR
		salvar = new JButton("SALVAR");
		salvar.setBounds(180, 300, 100, 30);
		salvar.setVisible(true);
		this.add(salvar);
		salvar.addActionListener(this);
					
		//BOTAO VOLTAR
		voltar = new JButton("VOLTAR");
		voltar.setBounds(20, 300, 100, 30);
		voltar.setVisible(true);
		this.add(voltar);
		voltar.addActionListener(this);
		
	/*	public void atualizacombo()
		{
			//tem que criar lista de alunos Array lits blablba
			  
			comboAluno.removeAllItems();
			listaAlunos = alunoBanco.selecionarTodos();
			int tamanhoBD = listaAlunos.size()-1;
			Aluno aluno = new Aluno();
			comboAluno.addItem("");
			while (tamanhoBD>=0)
			{
				aluno = listaAlunos.get(tamanhoBD);
				comboAluno.addItem(aluno.getNome());
				
				tamanhoBD--;
			}
		}*/
		
		
	}
	
	
	
	
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource().equals(salvar))
		{
			if (salvar())
			{
				Janela.getInstance().getSuperior().setVisible(true);
				Janela.getInstance().getCadastrarProfessor().setVisible(false);
			}
			
		}
		if(e.getSource().equals(voltar))
		{
			Janela.getInstance().getCadastrarProfessor().setVisible(false);
			Janela.getInstance().getEscolhaPessoa().setVisible(true);
		}
		
	}
	
	public boolean salvar()
	{
		//falta inserir no banco e arrumar o curso
		try 
		{
			if(caixaCpf.getText()!=null)
			{
				Professor professor = new Professor();
				Unidade unidade = new UnidadeDAO().buscaSigla(comboUnidadeTrab.getSelectedItem().toString());
				
				Date data = new Date (Integer.parseInt(caixaAno.getText())-1900,Integer.parseInt(caixaMes.getText()) -1 , 
									  Integer.parseInt(caixaDia.getText()));
				
				professor.setCpf(caixaCpf.getText());
				professor.setNome(caixaNome.getText());
				professor.setNascimento(data);
				professor.setEmailInstitucional(caixaEmailInstitucional.getText());
				professor.setEmailSecundario(caixaEmailSecundario.getText());
				professor.setSiape(caixaSiape.getText());
				professor.setRegimeTrabalho(comboRegimeTrab.getSelectedItem().toString());
				professor.setUnidadeAcademica(unidade);
				
				
				//System.out.println(aluno.getCpf() + " " + aluno.getNascimento()+" "+aluno.getNome());
				//System.out.println(aluno.getEmailInstitucional());
				//System.out.println(aluno.getEmailSecundario());
				
				//System.out.println(aluno.getMatricula());
				
				ProfessorDAO professorInsere = new ProfessorDAO();
				
				if(professorInsere.insereProfessor(professor))
					return true;
				else
					JOptionPane.showMessageDialog(null, "Ops algo deu erroado, confirme seus dados!");
			}
			
			
		
		} 
		catch (ClassNotFoundException e1) 
		{
			
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, "Ops algo deu erroado, confirme seus dados!");
		} 
		catch (SQLException e1) 
		{
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, "Ops algo deu erroado, confirme seus dados!");
		}
		catch (NumberFormatException e)
		{
			JOptionPane.showMessageDialog(null, "Ops algo deu erroado, confirme seus dados!");
		}
		return false;
	}


		
}