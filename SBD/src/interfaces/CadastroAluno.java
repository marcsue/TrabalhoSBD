package interfaces;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import banco.AlunoDAO;
import banco.CursoDAO;
import areasUniversidade.Curso;
import membrosUniversidade.Aluno;

public class CadastroAluno extends JPanel implements ActionListener
{
	
	public JLabel titulo;
	public JLabel cpf; 
	public JLabel nome;
	public JLabel emailInstitucional;
	public JLabel emailSecundario;
	public JLabel dtaNasc;
	public JLabel matricula;
	public JLabel siglaCurso;
	
	public JTextField caixaCpf;
	public JTextField caixaNome;
	public JTextField caixaEmailInstitucional;
	public JTextField caixaEmailSecundario;
	public JTextField caixaDia;
	public JTextField caixaMes;
	public JTextField caixaAno;
	public JTextField caixaMatricula;
	
	public JComboBox comboSiglaCurso;
	
	public JButton salvar;
	public JButton voltar;
	

	public ArrayList<Curso> listaCursos;
	public CursoDAO cursoBanco;
	
	
	public CadastroAluno ()  
	{
		super();
		this.setSize(1366, 768);		
		this.setLayout(null);
		
		//LABEL TITULO
		titulo = new JLabel("CADASTRO DE ALUNO");
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
		
		//LABEL MATRICULA
		matricula = new JLabel("MATRICULA:");
		matricula.setBounds(20, 180, 200, 30);
		matricula.setVisible(true);
		this.add(matricula);
		
		//LABEL SIGLA CURSO
		siglaCurso = new JLabel("SIGLA DO CURSO:");
		siglaCurso.setBounds(20, 210, 200, 30);
		siglaCurso.setVisible(true);
		this.add(siglaCurso);
	
		//COMBO SIGLA CURSO
		comboSiglaCurso = new JComboBox();
		comboSiglaCurso.setBounds(150, 216, 200, 20);
		comboSiglaCurso.setVisible(true);
		comboSiglaCurso.addItem("");
		comboSiglaCurso.addItem("BCC");
		comboSiglaCurso.addItem("BSI");
		comboSiglaCurso.addItem("LMA");
		this.add(comboSiglaCurso);
		comboSiglaCurso.addActionListener(this);
		
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
		
		//CAIXA MATRICULA
		caixaMatricula = new JTextField();
		caixaMatricula.setBounds(110, 187, 150, 20);
		caixaMatricula.setVisible(true);
		this.add(caixaMatricula);
		
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
		


	}
		
		
	
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource().equals(salvar))
		{
			if (salvar())
			{
				Janela.getInstance().getSuperior().setVisible(true);
				Janela.getInstance().getSuperior().cpf = caixaCpf.getText();
				Janela.getInstance().getCadastrarAluno().setVisible(false);
			}
			
		}
		if(e.getSource().equals(voltar))
		{
			Janela.getInstance().getCadastrarAluno().setVisible(false);
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
				Aluno aluno = new Aluno();
				Curso curso= new CursoDAO().buscaSigla(comboSiglaCurso.getSelectedItem().toString());
				
				Date data = new Date (Integer.parseInt(caixaAno.getText())-1900,Integer.parseInt(caixaMes.getText()) -1 , 
									  Integer.parseInt(caixaDia.getText()));
				
				aluno.setCpf(caixaCpf.getText());
				aluno.setNome(caixaNome.getText());
				aluno.setNascimento(data);
				aluno.setEmailInstitucional(caixaEmailInstitucional.getText());
				aluno.setEmailSecundario(caixaEmailSecundario.getText());
				aluno.setMatricula(caixaMatricula.getText());		
				aluno.setCurso(curso);
			
				
				AlunoDAO alunoInsere = new AlunoDAO();
				
				if(alunoInsere.insereAluno(aluno))
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

