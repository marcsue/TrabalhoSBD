package interfaces;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import interfaces.*;

public class Superior extends JPanel implements ActionListener
{

	public JButton criarFormulario;
	public JButton resFormulario;
	public JButton resultados;
	public Integer opcao=0;
	
	public Superior() {
		//CRIANDO A JANELA SEM LAYOUT E DEFININDO O TAMANHO
		super();
		this.setLayout(null);
		this.setSize(1366, 768);//definindo tamanho da janela
		
		//BOTAO CRIAR FORMULARIO
		criarFormulario = new JButton("Criar Formulário");
		criarFormulario.setBounds(570, 200, 200, 30);
		criarFormulario.setVisible(true);
		criarFormulario.addActionListener(this);
		this.add(criarFormulario);
		
		//BOTAO RESPONDER FORMULARIO
		resFormulario = new JButton("Responder Formulário");
		resFormulario.setBounds(570, 270, 200, 30);
		resFormulario.setVisible(true);
		resFormulario.addActionListener(this);
		this.add(resFormulario);
		
		//BOTAO RESULTADOS
		resultados = new JButton("Resultados");
		resultados.setBounds(570, 340, 200, 30);
		resultados.setVisible(true);
		resultados.addActionListener(this);
		this.add(resultados);		
		this.setVisible(true);
		
	}
	
	

	public Integer getOpcao() {
		return opcao;
	}



	public void setOpcao(Integer opcao) {
		this.opcao = opcao;
	}



	@Override
	public void actionPerformed(ActionEvent e) 
	{	
		if(e.getSource().equals(criarFormulario))
		{
			Janela.getInstance().getCriaFormulario().setVisible(true);
			Janela.getInstance().getSuperior().setVisible(false);
		}
		
		else if (e.getSource().equals(resFormulario))
		{			
			Janela.getInstance().getResponderFormulario().setVisible(true);
			Janela.getInstance().getSuperior().setVisible(false);
		}
		else if (e.getSource().equals(resultados))
		{
			Janela.getInstance().getResultadoFormulario().setVisible(true);
			Janela.getInstance().getSuperior().setVisible(false);
		}
		
	}
	

}
