package VIEW;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import CONTROL.DadoPf;
import DAO.ContatoDaoCliente;

import java.awt.Color;
import java.awt.Font;
import java.awt.List;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Visualizar_Clientes_Pf extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtSobrenome;
	private JTextField txtCpfCpnj;
	private JTextField txtDdd;
	private JTextField txtTel1;
	private JTextField txtTel2;
	private JTextField txtCel;
	private JTextField txtCep;
	private JTextField txtCidade;
	private JTextField txtUf;
	private JTextField txtBairro;
	private JTextField txtRua;
	private JTextField txtNo;
	private JTextField txtComplemento;
	private JTable table;
	private JTextField txtCliNome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Visualizar_Clientes_Pf frame = new Visualizar_Clientes_Pf();
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
	
	DefaultTableModel modelo = new DefaultTableModel();

	public Visualizar_Clientes_Pf() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 541);
		contentPane = new JPanel();
		this.setLocationRelativeTo(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Cadastrar_Cliente().setVisible(true);
				dispose();
			}
		});
		button.setIcon(new ImageIcon(Visualizar_Clientes_Pf.class.getResource("/imgs/Back.png")));
		button.setBounds(875, 12, 42, 41);
		contentPane.add(button);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new LineBorder(Color.GRAY));
		panel.setBounds(70, 42, 677, 173);
		contentPane.add(panel);
		
		JLabel lblCpfcnpj = new JLabel("CPF/CNPJ");
		lblCpfcnpj.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblCpfcnpj.setBounds(266, 11, 68, 14);
		panel.add(lblCpfcnpj);
		
		JLabel label_2 = new JLabel("SOBRENOME");
		label_2.setFont(new Font("Dialog", Font.PLAIN, 12));
		label_2.setBounds(126, 11, 91, 14);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("NOME");
		label_3.setFont(new Font("Dialog", Font.PLAIN, 12));
		label_3.setBounds(10, 11, 46, 14);
		panel.add(label_3);
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(10, 36, 106, 20);
		panel.add(txtNome);
		
		txtSobrenome = new JTextField();
		txtSobrenome.setColumns(10);
		txtSobrenome.setBounds(126, 36, 111, 20);
		panel.add(txtSobrenome);
		
		txtCpfCpnj = new JTextField();
		txtCpfCpnj.setColumns(10);
		txtCpfCpnj.setBounds(266, 36, 111, 20);
		panel.add(txtCpfCpnj);
		
		JLabel label_4 = new JLabel("TELEFONE1");
		label_4.setFont(new Font("Dialog", Font.PLAIN, 12));
		label_4.setBounds(49, 67, 70, 15);
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("TELEFONE2");
		label_5.setFont(new Font("Dialog", Font.PLAIN, 12));
		label_5.setBounds(167, 67, 93, 15);
		panel.add(label_5);
		
		JLabel label_6 = new JLabel("CELULAR");
		label_6.setFont(new Font("Dialog", Font.PLAIN, 12));
		label_6.setBounds(288, 67, 56, 15);
		panel.add(label_6);
		
		JLabel label_7 = new JLabel("DDD");
		label_7.setFont(new Font("Dialog", Font.PLAIN, 12));
		label_7.setBounds(10, 67, 34, 15);
		panel.add(label_7);
		
		txtDdd = new JTextField();
		txtDdd.setColumns(10);
		txtDdd.setBounds(10, 87, 29, 20);
		panel.add(txtDdd);
		
		txtTel1 = new JTextField();
		txtTel1.setColumns(10);
		txtTel1.setBounds(49, 87, 106, 20);
		panel.add(txtTel1);
		
		txtTel2 = new JTextField();
		txtTel2.setColumns(10);
		txtTel2.setBounds(165, 87, 106, 20);
		panel.add(txtTel2);
		
		txtCel = new JTextField();
		txtCel.setColumns(10);
		txtCel.setBounds(291, 87, 86, 20);
		panel.add(txtCel);
		
		JLabel label_9 = new JLabel("CEP");
		label_9.setFont(new Font("Dialog", Font.PLAIN, 12));
		label_9.setBounds(10, 118, 46, 14);
		panel.add(label_9);
		
		JLabel label_10 = new JLabel("CIDADE");
		label_10.setFont(new Font("Dialog", Font.PLAIN, 12));
		label_10.setBounds(59, 118, 46, 14);
		panel.add(label_10);
		
		JLabel label_11 = new JLabel("UF");
		label_11.setFont(new Font("Dialog", Font.PLAIN, 12));
		label_11.setBounds(151, 119, 28, 14);
		panel.add(label_11);
		
		JLabel label_12 = new JLabel("BAIRRO");
		label_12.setFont(new Font("Dialog", Font.PLAIN, 12));
		label_12.setBounds(201, 118, 46, 14);
		panel.add(label_12);
		
		txtCep = new JTextField();
		txtCep.setColumns(10);
		txtCep.setBounds(10, 138, 29, 20);
		panel.add(txtCep);
		
		txtCidade = new JTextField();
		txtCidade.setColumns(10);
		txtCidade.setBounds(57, 138, 86, 20);
		panel.add(txtCidade);
		
		txtUf = new JTextField();
		txtUf.setColumns(10);
		txtUf.setBounds(151, 138, 34, 20);
		panel.add(txtUf);
		
		txtBairro = new JTextField();
		txtBairro.setColumns(10);
		txtBairro.setBounds(195, 138, 86, 20);
		panel.add(txtBairro);
		
		JLabel label_13 = new JLabel("RUA");
		label_13.setFont(new Font("Dialog", Font.PLAIN, 12));
		label_13.setBounds(288, 119, 46, 14);
		panel.add(label_13);
		
		JLabel label_14 = new JLabel("NOº");
		label_14.setFont(new Font("Dialog", Font.PLAIN, 12));
		label_14.setBounds(391, 118, 46, 14);
		panel.add(label_14);
		
		JLabel label_15 = new JLabel("COMPLEMENTO");
		label_15.setFont(new Font("Dialog", Font.PLAIN, 12));
		label_15.setBounds(470, 118, 96, 14);
		panel.add(label_15);
		
		txtRua = new JTextField();
		txtRua.setColumns(10);
		txtRua.setBounds(293, 138, 86, 20);
		panel.add(txtRua);
		
		txtNo = new JTextField();
		txtNo.setColumns(10);
		txtNo.setBounds(391, 138, 56, 20);
		panel.add(txtNo);
		
		txtComplemento = new JTextField();
		txtComplemento.setColumns(10);
		txtComplemento.setBounds(470, 138, 159, 20);
		panel.add(txtComplemento);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 290, 905, 209);
		contentPane.add(scrollPane);
		
		table = new JTable(modelo);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setTextField();
			}
		});
		table.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				setTextField();
			}@Override
			public void keyReleased(KeyEvent e) {
				setTextField();
			}
		});
		scrollPane.setViewportView(table);
		
		JButton button_1 = new JButton("Atualizar");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_1.setBounds(323, 253, 117, 25);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("Excluir");
		button_2.setBounds(452, 253, 117, 25);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("Pesquisar");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					CarregaClientes(txtCliNome.getText());
			
			}
		});
		button_3.setBounds(742, 253, 117, 25);
		contentPane.add(button_3);
		
		txtCliNome = new JTextField();
		txtCliNome.setBounds(581, 253, 149, 25);
		contentPane.add(txtCliNome);
		txtCliNome.setColumns(10);
		
		JLabel lblNomeDoCliente = new JLabel("Nome Do Cliente");
		lblNomeDoCliente.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNomeDoCliente.setBounds(581, 227, 151, 25);
		contentPane.add(lblNomeDoCliente);
		
		JLabel lblClientePessoaFisica = new JLabel("CLIENTE PESSOA FISICA");
		lblClientePessoaFisica.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblClientePessoaFisica.setBounds(381, 12, 201, 15);
		contentPane.add(lblClientePessoaFisica);
		
		
		modelo.addColumn("CPF");
		modelo.addColumn("Cliente");
		modelo.addColumn("Sobrenome");
		modelo.addColumn("DDD");
		modelo.addColumn("Tel 1");
		modelo.addColumn("Tel 2");
		modelo.addColumn("Cel");
		modelo.addColumn("CEP");
		modelo.addColumn("Rua");
		modelo.addColumn("Cidade");
		modelo.addColumn("UF");
		modelo.addColumn("Noº");
		modelo.addColumn("Bairro");
		modelo.addColumn("Complemento");
		
	}
	
	
	//PRECHER O TEXTFIELD COM O TABLE
		public void setTextField() {
			
			int indice = table.getSelectedRow();
			
			txtCpfCpnj.setText(table.getValueAt(indice, 0).toString());
			txtNome.setText(table.getValueAt(indice, 1).toString());
			txtSobrenome.setText(table.getValueAt(indice, 2).toString());			
			txtDdd.setText(table.getValueAt(indice, 3).toString());
			txtTel1.setText(table.getValueAt(indice, 4).toString());
			txtTel2.setText(table.getValueAt(indice, 5).toString());
			txtCel.setText(table.getValueAt(indice, 6).toString());			
			txtCep.setText(table.getValueAt(indice, 7).toString());
			txtRua.setText(table.getValueAt(indice, 8).toString());
			txtCidade.setText(table.getValueAt(indice, 9).toString());
			txtUf.setText(table.getValueAt(indice, 10).toString());
			txtBairro.setText(table.getValueAt(indice, 12).toString());
			txtNo.setText(table.getValueAt(indice, 11).toString());
			txtComplemento.setText(table.getValueAt(indice, 13).toString());			
			
		}
	
	public void CarregaClientes(String descPf) {
		
		try {
			
			ContatoDaoCliente clientePf = new ContatoDaoCliente();
			java.util.List<DadoPf> pf = clientePf.getPfDesc(descPf);
			modelo.setNumRows(0);
			

			for (DadoPf Clipf : pf) {
				modelo.addRow(
						new Object[] {
								Clipf.getCpf(),
								Clipf.getNome(),
								Clipf.getSobrenome(),
								Clipf.getDdd(),
								Clipf.getTel1(),
								Clipf.getTel2(),
								Clipf.getCel(),
								Clipf.getCep(),
								Clipf.getRua(),	
								Clipf.getCidade(),															
								Clipf.getEstado(),
								Clipf.getNo(),
								Clipf.getBairro(),
								Clipf.getComplemento()
							
						});
			}
				
			
		} catch (Exception e) {
			System.out.println("Erro ao visualizar Cliente pf: " +e);
		}
	}
	
	
	
}
