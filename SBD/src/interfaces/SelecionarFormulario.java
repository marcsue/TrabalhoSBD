package interfaces;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import javax.swing.JPanel;


import banco.FormularioDAO;
import pesquisa.Formulario;

public class SelecionarFormulario extends JPanel implements ActionListener
{
	
	
	public ResponderFormulario responderFormulario;
	
	private static String selecionado = "lol";

	public JLabel selecionar;
	
	public JComboBox comboForms;
	
	public JButton select;
	public JButton voltar;
	
	public ResponderFormulario getResponderFormulario() {
		return responderFormulario;
	}
	public void setResponderFormulario(ResponderFormulario responderFormulario) {
		this.responderFormulario = responderFormulario;
	}
	
	public SelecionarFormulario(){
		super();
		this.setSize(1366,768);
		this.setLayout(null);
		

		
		//Label do selecione
		selecionar = new JLabel("Selecione o formulário que deseja responder:");
		selecionar.setBounds(20,1,250,30);
		selecionar.setVisible(true);
		this.add(selecionar);
		
		//ComboBox dos formularios
		comboForms = new JComboBox();
		comboForms.setBounds(150,216,200,20);
		comboForms.setVisible(true);
		try {
			for(String s : new FormularioDAO().buscaTitulo()){
				comboForms.addItem(s);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.add(comboForms);
		comboForms.addActionListener(this);
		
		//BOTAO select
		select = new JButton("Selecionar");
		select.setBounds(180, 300, 100, 30);
		select.setVisible(true);
		this.add(select);
		select.addActionListener(this);
					
		//BOTAO VOLTAR
		voltar = new JButton("Voltar");
		voltar.setBounds(20, 300, 100, 30);
		voltar.setVisible(true);
		this.add(voltar);
		voltar.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(select)){
			setSelecionado((String) comboForms.getSelectedItem());
			responderFormulario = new ResponderFormulario();
			this.getResponderFormulario().setVisible(true);
		}
		if(e.getSource().equals(voltar)){
			Janela.getInstance().getSelecionarFormulario().setVisible(false);
			Janela.getInstance().getSuperior().setVisible(true);
			Janela.getInstance().revalidate();
		}
	}
	public static String getSelecionado() {
		return selecionado;
	}
	public static void setSelecionado(String selecionado) {
		SelecionarFormulario.selecionado = selecionado;
	}
	
	
}