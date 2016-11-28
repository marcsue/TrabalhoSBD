package interfaces;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CadastroAluno extends JPanel implements ActionListener
{

	public JLabel cpf; 
	public JLabel nome;
	public JLabel email1;
	public JLabel email2;
	public JLabel dtaNasc;
	public JLabel matricula;
	public JLabel siglaCurso;//label p/ o combo
	
	
	public JTextField caixaCpf;
	public JTextField caixaNome;
	public JTextField caixaEmail1;
	public JTextField caixaEmail2;
	public JTextField caixaDia;//dta de nascimento
	public JTextField caixaMes;
	public JTextField caixaAno;
	public JTextField caixaCatricula;
	//public JTextField caixaSiglaCurso;

	public JComboBox comboSiglaCurso;//combo p/ o label
	
	public JButton salvar;
	public JButton voltar;
	
	public CadastroAluno () {
		super();
		this.setSize(1366, 768);		
		this.setLayout(null);
		
		//LABEL CPF
		cpf = new JLabel("CPF:");
		cpf.setBounds(20, 1, 200, 30);
		cpf.setVisible(true);
		this.add(cpf);
				
		//LABEL NOME
		nome = new JLabel("NOME:");
		nome.setBounds(20, 30, 200, 30);
		nome.setVisible(true);
		this.add(nome);
				
		//LABEL EMAIL INSTITUCIONAL
		email1 = new JLabel("E-MAIL INSTITUCIONAL:");
		email1.setBounds(20, 60, 200, 30);
		email1.setVisible(true);
		this.add(email1);
				
		//LABEL EMAIL SECUNDARIO
		email2 = new JLabel("E-MAIL SECUNDARIO:");
		email2.setBounds(20, 90, 200, 30);
		email2.setVisible(true);
		this.add(email2);
				
		//LABEL DTA DE NASCIMENTO
		dtaNasc = new JLabel("DATA DE NASCIMENTO:");
		dtaNasc.setBounds(20, 120, 200, 30);
		dtaNasc.setVisible(true);
		this.add(dtaNasc);
		
		//LABEL MATRICULA
		matricula = new JLabel("MATRICULA:");
		matricula.setBounds(20, 150, 200, 30);
		matricula.setVisible(true);
		this.add(matricula);
		
		//LABEL SIGLA CURSO
		siglaCurso = new JLabel("SIGLA DO CURSO:");
		siglaCurso.setBounds(20, 180, 200, 30);
		siglaCurso.setVisible(true);
		this.add(siglaCurso);
	
		//COMBO SIGLA CURSO
		comboSiglaCurso = new JComboBox();
		comboSiglaCurso.setBounds(150, 186, 200, 20);
		comboSiglaCurso.setVisible(true);
		comboSiglaCurso.addItem("BCC");
		comboSiglaCurso.addItem("BSI");
		this.add(comboSiglaCurso);
		comboSiglaCurso.addActionListener(this);
		
		//CAIXA CPF
		caixaCpf = new JTextField();
		caixaCpf.setBounds(60, 7, 150, 20);
		caixaCpf.setVisible(true);
		this.add(caixaCpf);
		
		//CAIXA NOME
		caixaNome = new JTextField();
		caixaNome.setBounds(74, 37, 150, 20);
		caixaNome.setVisible(true);
		this.add(caixaNome);
		
		//CAIXA EMAIL INSTITUCIONAL
		caixaEmail1 = new JTextField();
		caixaEmail1.setBounds(188, 67, 150, 20);
		caixaEmail1.setVisible(true);
		this.add(caixaEmail1);
		
		//CAIXA EMAIL SECUNDARIO
		caixaEmail2 = new JTextField();
		caixaEmail2.setBounds(173, 97, 150, 20);
		caixaEmail2.setVisible(true);
		this.add(caixaEmail2);
		
		//DTA DE NASCIMENTO
		//CAIXA DIA
		caixaDia = new JTextField("D");
		caixaDia.setBounds(186, 127, 20, 20);
		caixaDia.setVisible(true);
		this.add(caixaDia);
		
		//CAIXA MES
		caixaMes = new JTextField("M");
		caixaMes.setBounds(216, 127, 20, 20);
		caixaMes.setVisible(true);
		this.add(caixaMes);
				
		//CAIXA ANO
		caixaAno = new JTextField("A");
		caixaAno.setBounds(246, 127, 20, 20);
		caixaAno.setVisible(true);
		this.add(caixaAno);
		
		//CAIXA MATRICULA
		caixaCatricula = new JTextField();
		caixaCatricula.setBounds(110, 157, 150, 20);
		caixaCatricula.setVisible(true);
		this.add(caixaCatricula);
		
		//CAIXA SIGLA CURSO
		/*caixaSiglaCurso = new JTextField();
		caixaSiglaCurso.setBounds(100, 187, 150, 20);
		caixaSiglaCurso.setVisible(true);
		this.add(caixaSiglaCurso);*/
				
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
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
