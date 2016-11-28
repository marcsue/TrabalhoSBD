package interfaces;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import banco.AlunoDAO;
import banco.ProfessorDAO;
import banco.TerceirizadoDAO;
import membrosUniversidade.Aluno;
import membrosUniversidade.Pessoas;

public class VerificaUsuario  extends JPanel implements ActionListener{
	
	public JLabel cpf; //label p/ o combo

	public JTextField caixaCpf;

	public JButton ok;
	public JButton voltar;
	
	public VerificaUsuario () {
		super();
		this.setSize(1366, 768);		
		this.setLayout(null);
		
	
		//LABEL CPF
		cpf = new JLabel("Digite seu CPF:");
		cpf.setBounds(520, 58, 200, 30);
		cpf.setVisible(true);
		this.add(cpf);
		
		
						
		//CAIXA CPF
		caixaCpf = new JTextField();
		caixaCpf.setBounds(630, 64, 150, 20);
		caixaCpf.setVisible(true);
		this.add(caixaCpf);
		
		//BOTAO OK
		ok = new JButton("OK");
		ok.setBounds(679, 130, 100, 20);
		ok.setVisible(true);
		this.add(ok);
		ok.addActionListener(this);
			
		//BOTAO VOLTAR
		voltar = new JButton("VOLTAR");
		voltar.setBounds(520, 130, 100, 20);
		voltar.setVisible(true);
		this.add(voltar);
		voltar.addActionListener(this);
		
	}
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(ok))
		{
			try {
				int tipo = buscaPessoa(caixaCpf.getText());
				
				if (tipo==0)
				{	
					JOptionPane.showMessageDialog(null, "Você ainda não é cadastrado, vamos lá!");
					Janela.getInstance().getVerifica().setVisible(false);
					Janela.getInstance().getCriaFormulario().setVisible(false);
					Janela.getInstance().getResponderFormulario().setVisible(false);
					Janela.getInstance().getCadastrarAluno().setVisible(false);
					Janela.getInstance().getEscolhaPessoa().setVisible(true);
					
					cpf.setVisible(false);
					ok.setVisible(false);
					caixaCpf.setVisible(false);
					voltar.setVisible(false);
					
				
				}
				else
					JOptionPane.showMessageDialog(null, "Você já é cadastrado, vamos lá!");
					
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		
			
		}
		if (e.getSource().equals(voltar))
		{
			Janela.getInstance().IniciaTela();
			
			cpf.setVisible(false);
			ok.setVisible(false);
			caixaCpf.setVisible(false);
			voltar.setVisible(false);
		}	
		
	}
	
	
	public int buscaPessoa(String cpf) throws ClassNotFoundException
	{
		AlunoDAO aluno = new AlunoDAO();
		ProfessorDAO prof = new ProfessorDAO();
		TerceirizadoDAO terc = new TerceirizadoDAO();
				
		if(aluno.buscaCpf(cpf))
		{
			//System.out.println("ok");
			return 1;
		}
		else if (prof.buscaCpf(cpf))
			return 2;
		else if (terc.buscaCpf(cpf))
			return 3;
		else
			return 0;
		//falta fazer o do tecnico
		
	}
	

}
