package interfaces;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import banco.FormularioDAO;
import pesquisa.Formulario;
import pesquisa.Item;
import pesquisa.Qmulti;
import pesquisa.Qtexto;
import pesquisa.pergunta_temp;

import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class CriarFormulario extends JInternalFrame {
	JLabel lblRestries = new JLabel("Restri\u00E7\u00F5es");
	
	JCheckBox ck_pf = new JCheckBox("Professores");
	
	JCheckBox ck_tec = new JCheckBox("T\u00E9cnicos");
	
	JCheckBox ck_al = new JCheckBox("Alunos");
	
	JCheckBox ck_tr = new JCheckBox("Terceirizados");
	private JTextField textField;
	private JTable table;
	private JTable table_1;
	ArrayList<pergunta_temp> psave = new ArrayList<pergunta_temp>();
	int idcount = 0;
	ArrayList<Item> opcoes = new ArrayList<Item>();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CriarFormulario frame = new CriarFormulario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CriarFormulario() {
		setTitle("Criar Formul\u00E1rio");
		setBounds(100, 100, 609, 532);
		DefaultTableModel model = new DefaultTableModel();
		DefaultTableModel model2 = new DefaultTableModel();

		JLabel lblTtulo = new JLabel("T\u00EDtulo: ");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JPanel restriPanel = new JPanel();
		
		JLabel lblQuestesDeTexto = new JLabel("Quest\u00F5es de Texto: ");
		
		JLabel lblQuestesDeMultiplaescolha = new JLabel("Quest\u00F5es de Multipla-Escolha:");
		
		JScrollPane SQuestPanel = new JScrollPane();
		
		JButton btnAdd = new JButton("+");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Ao usar o ID de questão, lembrar que o ID vinculado a ela não será inserido! é somente para checagem das questões!!!
				String pergunta= JOptionPane.showInputDialog("Digite sua pergunta.");
				pergunta_temp perguntas = new pergunta_temp();
				perguntas.setPergunta(pergunta);
				perguntas.setTipo(1);
				perguntas.setId(idcount);
				psave.add(perguntas);
				model.addRow(new String [] {perguntas.getPergunta(), "Texto"} );
				idcount++;
			}
		});
		
		JButton button = new JButton("+");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int op = JOptionPane.YES_OPTION;
				//Ao usar o ID de item, lembrar que o ID vinculado a ele não será inserido! é somente para checagem das questões!!!
				String pergunta= JOptionPane.showInputDialog("Digite sua pergunta.");
				pergunta_temp perguntas = new pergunta_temp();
				perguntas.setPergunta(pergunta);
				perguntas.setTipo(2);
				perguntas.setId(idcount);
				psave.add(perguntas);
				model.addRow(new String [] {perguntas.getPergunta(), "MultiplaEscolha"} );
				while(op != JOptionPane.NO_OPTION){
					String opcao= JOptionPane.showInputDialog("Digite uma opção: ");
					model2.addRow(new String[] {opcao,perguntas.getPergunta()});
					Item i = new Item(perguntas.getId(),opcao);//ID DA QUESTÃO, PARA CONTROLE NO BOTÃO GRAVAR FICAR FACIL! -- IMPORTANTE, Não È USADO COMO NO DAO!!!!
					opcoes.add(i);
					op = JOptionPane.showConfirmDialog(null,"Adicionar mais opções? ","Sim",JOptionPane.YES_NO_OPTION);   
				}
				idcount++;
			}
		});
		
		JButton btnGravar = new JButton("GRAVAR");
		btnGravar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Formulario novo = new Formulario();
				//if()
				int rest = 0;
				if(ck_pf.isSelected())
					rest += 2;
				if(ck_al.isSelected())
					rest++;
				if(ck_tr.isSelected())
					rest += 4;
				if(ck_tec.isSelected())
					rest += 3;
			novo.setTipo_restricao(rest); // adiciona restrição ao formulário
			novo.setTitulo("algum");
			/*datas*/
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");;		
			java.util.Date dataUtil = new java.util.Date();
			dateFormat.format(dataUtil);
			Date inicio = new Date(dataUtil.getTime());
			//Fim data de inicio
			//Data fim
			Date fim = new Date(dataUtil.getTime() + 31l*24l*60l*60l*1000l);
			//fim data fim
			novo.setData_inicio(inicio);
			novo.setData_fim(fim);
			novo.setCpf("1111");//CPF do criador;
            for(pergunta_temp p : psave){//Adiciona as questões ao formulário!
            		if(p.getTipo() == 1){ //texto
            			Qtexto q = new Qtexto(p.getPergunta());
            			//q.setId_form(id_form);
            			novo.addQuestao(q);
            		}
            		else{ //multipla escolha
            			Qmulti q = new Qmulti(p.getPergunta());
            			for(Item i: opcoes){
            				if(i.getId() == p.getId())
            					q.addItemNid(i.getDescricao());
            			}
            			novo.addQuestao(q);
            		}
            }
			try {
				FormularioDAO conexao = new FormularioDAO();
				conexao.insereForm(novo);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			}
		});
		
		JButton btnCancelar = new JButton("Cancelar");
		
		JScrollPane scrollPaneMulti = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(SQuestPanel, GroupLayout.DEFAULT_SIZE, 573, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(135)
							.addComponent(lblTtulo)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 285, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(restriPanel, GroupLayout.DEFAULT_SIZE, 573, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblQuestesDeTexto)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnAdd))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblQuestesDeMultiplaescolha)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(button))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(199)
							.addComponent(btnGravar, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnCancelar))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPaneMulti, GroupLayout.DEFAULT_SIZE, 573, Short.MAX_VALUE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(23)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTtulo)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(30)
					.addComponent(restriPanel, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblQuestesDeTexto)
						.addComponent(btnAdd))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblQuestesDeMultiplaescolha)
						.addComponent(button))
					.addPreferredGap(ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
					.addComponent(SQuestPanel, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPaneMulti, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnGravar)
						.addComponent(btnCancelar))
					.addGap(6))
		);
		
		table_1 = new JTable();
		/*table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Op\u00E7\u00E3o", "Quest\u00E3o"
			}
		));*/
		model2.addColumn("Opção");
		model2.addColumn("Questão");
		scrollPaneMulti.setViewportView(table_1);
		table_1.setModel(model2);

		groupLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] {btnGravar, btnCancelar});
		
		table = new JTable();
		/*table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Tipo", "Pergunta"
			}
		));*/
		model.addColumn("Pergunta");
		model.addColumn("Tipo");
		table.setModel(model);
		SQuestPanel.setViewportView(table);
		
		JLabel lblRestries = new JLabel("Restri\u00E7\u00F5es");
		
		ck_pf = new JCheckBox("Professores");
		
		ck_tec = new JCheckBox("T\u00E9cnicos");
		
		ck_al = new JCheckBox("Alunos");
		
		ck_tr = new JCheckBox("Terceirizados");
		GroupLayout gl_restriPanel = new GroupLayout(restriPanel);
		gl_restriPanel.setHorizontalGroup(
			gl_restriPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_restriPanel.createSequentialGroup()
					.addGroup(gl_restriPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_restriPanel.createSequentialGroup()
							.addGap(138)
							.addComponent(ck_pf)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(ck_tec)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(ck_al)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(ck_tr))
						.addGroup(gl_restriPanel.createSequentialGroup()
							.addGap(261)
							.addComponent(lblRestries)))
					.addContainerGap(139, Short.MAX_VALUE))
		);
		gl_restriPanel.setVerticalGroup(
			gl_restriPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_restriPanel.createSequentialGroup()
					.addGap(5)
					.addComponent(lblRestries)
					.addGap(7)
					.addGroup(gl_restriPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(ck_pf)
						.addComponent(ck_tec)
						.addComponent(ck_al)
						.addComponent(ck_tr))
					.addContainerGap(38, Short.MAX_VALUE))
		);
		restriPanel.setLayout(gl_restriPanel);
		getContentPane().setLayout(groupLayout);

	}
}
