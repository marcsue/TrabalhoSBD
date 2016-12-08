package interfaces;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import membrosUniversidade.Aluno;
import areasUniversidade.Curso;
import banco.CursoDAO;

public class CadastroTecnico extends JPanel implements ActionListener {
	
	public JLabel titulo;
	public JLabel cpf; 
	public JLabel nome;
	public JLabel emailInstitucional;
	public JLabel emailSecundario;
	public JLabel dtaNasc;
	public JLabel siape;
	public JLabel unidadeTrabalho;
	
	public JTextField caixaCpf;
	public JTextField caixaNome;
	public JTextField caixaEmailInstitucional;
	public JTextField caixaEmailSecundario;
	public JTextField caixaDia;
	public JTextField caixaMes;
	public JTextField caixaAno;
	public JTextField caixasiape;
	
	public JComboBox comboUnidadeTrab;
	
	public JButton salvar;
	public JButton voltar;
	
	public CadastroTecnico () {
		super();
		this.setSize(1366, 768);		
		this.setLayout(null);
		

		//LABEL TITULO
		titulo = new JLabel("CADASTRO DE TÉCNICO");
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
		caixasiape = new JTextField();
		caixasiape.setBounds(73, 187, 150, 20);
		caixasiape.setVisible(true);
		this.add(caixasiape);
		
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
//			salvar();
			Janela.getInstance().getSuperior().setVisible(true);
			Janela.getInstance().getCadastrarTecnico().setVisible(false);
		}
		if(e.getSource().equals(voltar))
		{
			Janela.getInstance().getCadastrarTecnico().setVisible(false);
			Janela.getInstance().getEscolhaPessoa().setVisible(true);
		}
		
	}
	
	
/*	public void salvar()
	{
		//falta inserir no banco e arrumar o curso
		try 
		{
			Aluno aluno = new Aluno();
			Curso curso;
			Date data = new Date (Integer.parseInt(caixaAno.getText())-1900,Integer.parseInt(caixaMes.getText()) -1 , 
					  Integer.parseInt(caixaDia.getText()));
	
			
			curso = new CursoDAO().buscaSigla(comboSiglaCurso.getSelectedItem().toString());
			
			
			aluno.setCpf(caixaCpf.getText());
			aluno.setNome(caixaNome.getText());
			aluno.setEmailInstitucional(caixaEmailInstitucional.getText());
			aluno.setEmailSecundario(caixaEmailSecundario.getText());
			aluno.setMatricula(caixaMatricula.getText());		
			aluno.setNascimento(data);
		//	aluno.setCurso(curso);
			
			System.out.println(aluno.getCpf() + " " + aluno.getNascimento()+" "+aluno.getNome());
			System.out.println(aluno.getEmailInstitucional());
			System.out.println(aluno.getEmailSecundario());
			//System.out.println(aluno.getCurso().getNome());
			System.out.println(aluno.getMatricula());
		
		} 
		catch (ClassNotFoundException e1) 
		{
			e1.printStackTrace();
		} 
		catch (SQLException e1) 
		{
			e1.printStackTrace();
		}
		
	}

		*/
}