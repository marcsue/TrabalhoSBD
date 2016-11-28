package interfaces;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Janela extends JFrame
{
	//DECLARANDO PAINEIS
	public CriarFormulario criaFormulario;
	public ResponderFormulario responderFormulario;
	public VerificaUsuario verifica;
	public CadastroAluno cadastrarAluno;
	public EscolhaPessoa escolhaPessoa;
	
	public Superior painelSuperior;
	
	private static Janela instance;
	
	public Janela()
	{
		super("FINAL"); // nome na barra superior
		this.setSize(1366, 768);//definindo tamanho da janela
		
		this.setLayout(null);//para o ultimo painel n ficar em full screen
		
		IniciaTela(); //metodo inicia tela 
		
		this.setVisible(true);//deixando a janela visivel
			
		this.setDefaultCloseOperation(EXIT_ON_CLOSE); //ativando botao fechar
		
	}
	//METODO INSTANCE
	public static Janela getInstance()
	{
		if(instance==null)
		{
			instance = new Janela();
			return instance;
		}
		else
		{
			return instance;
		}
	}
	
	
	
	public CriarFormulario getCriaFormulario() {
		return criaFormulario;
	}
	public void setCriaFormulario(CriarFormulario criaFormulario) {
		this.criaFormulario = criaFormulario;
	}
	public ResponderFormulario getResponderFormulario() {
		return responderFormulario;
	}
	public void setResponderFormulario(ResponderFormulario responderFormulario) {
		this.responderFormulario = responderFormulario;
	}
	public VerificaUsuario getVerifica() {
		return verifica;
	}
	public void setVerifica(VerificaUsuario verifica) {
		this.verifica = verifica;
	}
	public Superior getPainelSuperior() {
		return painelSuperior;
	}
	public void setPainelSuperior(Superior painelSuperior) {
		this.painelSuperior = painelSuperior;
	}
	
	public CadastroAluno getCadastrarAluno() {
		return cadastrarAluno;
	}
	public void setCadastrarAluno(CadastroAluno cadastrarAluno) {
		this.cadastrarAluno = cadastrarAluno;
	}
	
	public EscolhaPessoa getEscolhaPessoa() {
		return escolhaPessoa;
	}
	public void setEscolhaPessoa(EscolhaPessoa escolhaPessoa) {
		this.escolhaPessoa = escolhaPessoa;
	}
	//METODO INICIA TELA
	public void IniciaTela()
	{
		criaFormulario = new CriarFormulario();
		criaFormulario.setBounds(10, 200, 1024, 680);
		criaFormulario.setVisible(false);
		this.getContentPane().add(criaFormulario);
				
		responderFormulario = new ResponderFormulario();
		responderFormulario.setBounds(10, 200, 1024, 680);
		responderFormulario.setVisible(false);
		this.getContentPane().add(responderFormulario);
		
		verifica = new VerificaUsuario();
		verifica.setBounds(10, 200, 1024, 680);
		verifica.setVisible(false);
		this.getContentPane().add(verifica);
		
		cadastrarAluno = new CadastroAluno();
		cadastrarAluno.setBounds(10, 200, 1024, 680);
		cadastrarAluno.setVisible(false);
		this.getContentPane().add(cadastrarAluno);
		
		escolhaPessoa = new EscolhaPessoa();
		escolhaPessoa.setBounds(10, 200, 1024, 680);
		escolhaPessoa.setVisible(false);
		this.getContentPane().add(escolhaPessoa);
		
		
		painelSuperior = new Superior();
		painelSuperior.setBounds(10, 10, 1366, 768);
		painelSuperior.setVisible(true);
		this.getContentPane().add(painelSuperior);
		
	}
}
