package interfaces;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import membrosUniversidade.Aluno;
import membrosUniversidade.Pessoas;

public class EscolhaPessoa extends JPanel implements ActionListener {

	
	public JButton aluno;
	public JButton professor;
	public JButton tecnicos;
	public JButton terceirizados;

		
	public EscolhaPessoa () {
		super();
		this.setSize(1366, 768);		
		this.setLayout(null);
	
		//BOTAO ALUNO
		aluno = new JButton("ALUNO");
		aluno.setBounds(560, 70, 200, 30);
		aluno.setVisible(true);
		this.add(aluno);
		aluno.addActionListener(this);
		
		//BOTAO PROFESSOR
		professor = new JButton("PROFESSOR");
		professor.setBounds(560, 100, 200, 30);
		professor.setVisible(true);
		this.add(professor);
		professor.addActionListener(this);
				
		//BOTAO TECNICOS
		tecnicos = new JButton("TÉCNICO");
		tecnicos.setBounds(560, 130, 200, 30);
		tecnicos.setVisible(true);
		this.add(tecnicos);
		tecnicos.addActionListener(this);
				
		//BOTAO TERCEIRIZADOS
		terceirizados = new JButton("TERCEIRIZADO");
		terceirizados.setBounds(560, 160, 200, 30);
		terceirizados.setVisible(true);
		this.add(terceirizados);
		terceirizados.addActionListener(this);
				
		
	}




	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(aluno))
		{
			Janela.getInstance().getVerifica().setVisible(false);
			Janela.getInstance().getCriaFormulario().setVisible(false);
			Janela.getInstance().getResponderFormulario().setVisible(false);
			Janela.getInstance().getCadastrarAluno().setVisible(true);
			Janela.getInstance().getEscolhaPessoa().setVisible(false);
			
			aluno.setVisible(false);
			professor.setVisible(false);
			tecnicos.setVisible(false);
			terceirizados.setVisible(false);
			
			
		}
		
	}

}
