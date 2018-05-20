package VIEW;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import CONTROL.DadoPf;
import CONTROL.DadoPj;
import DAO.ContatoDaoCliente;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Visualizar_Clientes_Pj extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtCnpj;
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
	private JTextField txtPesquisar;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Visualizar_Clientes_Pj frame = new Visualizar_Clientes_Pj();
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

	public Visualizar_Clientes_Pj() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 588);
		contentPane = new JPanel();
		this.setLocationRelativeTo(null);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(87, 83, 755, 173);
		panel.setLayout(null);
		panel.setBorder(new LineBorder(Color.GRAY));
		contentPane.add(panel);
		
		JLabel label = new JLabel("CPF/CNPJ");
		label.setFont(new Font("Dialog", Font.PLAIN, 12));
		label.setBounds(266, 11, 68, 14);
		panel.add(label);
		
		JLabel label_1 = new JLabel("SOBRENOME");
		label_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		label_1.setBounds(126, 11, 91, 14);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("NOME");
		label_2.setFont(new Font("Dialog", Font.PLAIN, 12));
		label_2.setBounds(10, 11, 46, 14);
		panel.add(label_2);
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(10, 36, 106, 20);
		panel.add(txtNome);
		
		JTextField txtSobrenome = new JTextField();
		txtSobrenome.setColumns(10);
		txtSobrenome.setBounds(126, 36, 111, 20);
		panel.add(txtSobrenome);
		
		txtCnpj = new JTextField();
		txtCnpj.setColumns(10);
		txtCnpj.setBounds(266, 36, 111, 20);
		panel.add(txtCnpj);
		
		JLabel label_3 = new JLabel("TELEFONE1");
		label_3.setFont(new Font("Dialog", Font.PLAIN, 12));
		label_3.setBounds(49, 67, 70, 15);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("TELEFONE2");
		label_4.setFont(new Font("Dialog", Font.PLAIN, 12));
		label_4.setBounds(167, 67, 93, 15);
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("CELULAR");
		label_5.setFont(new Font("Dialog", Font.PLAIN, 12));
		label_5.setBounds(288, 67, 56, 15);
		panel.add(label_5);
		
		JLabel label_6 = new JLabel("DDD");
		label_6.setFont(new Font("Dialog", Font.PLAIN, 12));
		label_6.setBounds(10, 67, 34, 15);
		panel.add(label_6);
		
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
		
		JLabel label_7 = new JLabel("CEP");
		label_7.setFont(new Font("Dialog", Font.PLAIN, 12));
		label_7.setBounds(10, 118, 46, 14);
		panel.add(label_7);
		
		JLabel label_8 = new JLabel("CIDADE");
		label_8.setFont(new Font("Dialog", Font.PLAIN, 12));
		label_8.setBounds(107, 118, 46, 14);
		panel.add(label_8);
		
		JLabel label_9 = new JLabel("UF");
		label_9.setFont(new Font("Dialog", Font.PLAIN, 12));
		label_9.setBounds(203, 118, 28, 14);
		panel.add(label_9);
		
		JLabel label_10 = new JLabel("BAIRRO");
		label_10.setFont(new Font("Dialog", Font.PLAIN, 12));
		label_10.setBounds(248, 118, 46, 14);
		panel.add(label_10);
		
		txtCep = new JTextField();
		txtCep.setColumns(10);
		txtCep.setBounds(10, 138, 87, 20);
		panel.add(txtCep);
		
		txtCidade = new JTextField();
		txtCidade.setColumns(10);
		txtCidade.setBounds(107, 138, 86, 20);
		panel.add(txtCidade);
		
		txtUf = new JTextField();
		txtUf.setColumns(10);
		txtUf.setBounds(203, 138, 34, 20);
		panel.add(txtUf);
		
		txtBairro = new JTextField();
		txtBairro.setColumns(10);
		txtBairro.setBounds(248, 138, 86, 20);
		panel.add(txtBairro);
		
		JLabel label_11 = new JLabel("RUA");
		label_11.setFont(new Font("Dialog", Font.PLAIN, 12));
		label_11.setBounds(353, 118, 46, 14);
		panel.add(label_11);
		
		JLabel lblNo = new JLabel("No\u00BA");
		lblNo.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNo.setBounds(465, 118, 46, 14);
		panel.add(lblNo);
		
		JLabel label_13 = new JLabel("COMPLEMENTO");
		label_13.setFont(new Font("Dialog", Font.PLAIN, 12));
		label_13.setBounds(556, 118, 96, 14);
		panel.add(label_13);
		
		txtRua = new JTextField();
		txtRua.setColumns(10);
		txtRua.setBounds(353, 138, 86, 20);
		panel.add(txtRua);
		
		txtNo = new JTextField();
		txtNo.setColumns(10);
		txtNo.setBounds(465, 138, 56, 20);
		panel.add(txtNo);
		
		txtComplemento = new JTextField();
		txtComplemento.setColumns(10);
		txtComplemento.setBounds(555, 138, 159, 20);
		panel.add(txtComplemento);
		
		JLabel label_14 = new JLabel("Nome Do Cliente");
		label_14.setBounds(564, 267, 151, 25);
		label_14.setFont(new Font("Dialog", Font.PLAIN, 12));
		contentPane.add(label_14);
		
		JButton button = new JButton("Atualizar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(table.getSelectedRow() != -1) {
					int yes = JOptionPane.showConfirmDialog(null, "Você realmente deseja ATUALIZAR esse Cliente ?","ATUALIZAR",JOptionPane.YES_NO_OPTION);	
					 if(yes == 0) {
						 
						 DadoPj dadoPj = new DadoPj();
						 ContatoDaoCliente daoPj = new ContatoDaoCliente();
						 
						 dadoPj.setCnpj(txtCnpj.getText().toUpperCase());
						 dadoPj.setNome(txtNome.getText().toUpperCase());
						 dadoPj.setSobrenome(txtSobrenome.getText().toUpperCase());
						 dadoPj.setDdd(txtDdd.getText().toUpperCase());
						 dadoPj.setTel1(txtTel1.getText().toUpperCase());
						 dadoPj.setTel2(txtTel2.getText().toUpperCase());
						 dadoPj.setCel(txtCel.getText().toUpperCase());
						 dadoPj.setCep(txtCep.getText().toUpperCase());
						 dadoPj.setRua(txtRua.getText().toUpperCase());
						 dadoPj.setCidade(txtCidade.getText().toUpperCase());
						 dadoPj.setEstado(txtUf.getText().toUpperCase());
						 dadoPj.setBairro(txtBairro.getText().toUpperCase());
						 dadoPj.setNo(txtNo.getText().toUpperCase());
						 dadoPj.setComplemento(txtComplemento.getText().toUpperCase());
						 
						 daoPj.UpdateClientePj(dadoPj);
						 setTextField();
						 
						 
					 }
				}
			}
		});
		button.setBounds(306, 293, 117, 25);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Excluir");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				if(table.getSelectedRow() != -1) {
					int yes = JOptionPane.showConfirmDialog(null, "Você realmente deseja DELETAR esse Cliente ?","DELETE",JOptionPane.YES_NO_OPTION);
						if (yes == 0) {
							
							try {
								DadoPj dadoPj = new DadoPj();
								ContatoDaoCliente daoPj = new ContatoDaoCliente();
								
								//seta o valor do cpf da tabela
								dadoPj.setCnpj((String) table.getValueAt(table.getSelectedRow(), 0));
								
								daoPj.DeleteClientePj(dadoPj);
								
							} catch (Exception e2) {
								System.out.println("Erro ao deletar Cliente: " +e2);
							}
							
						}
				}
				
				
				
			}
		});
		button_1.setBounds(435, 293, 117, 25);
		contentPane.add(button_1);
		
		txtPesquisar = new JTextField();
		txtPesquisar.setBounds(564, 293, 149, 25);
		txtPesquisar.setColumns(10);
		contentPane.add(txtPesquisar);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				CarregaClientes(txtPesquisar.getText());
				
			}
		});
		btnPesquisar.setBounds(725, 293, 117, 25);
		contentPane.add(btnPesquisar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 329, 905, 209);
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
		
		JLabel lblClientePessoaJuridica = new JLabel("CLIENTE PESSOA JURIDICA");
		lblClientePessoaJuridica.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblClientePessoaJuridica.setBounds(367, 26, 221, 15);
		contentPane.add(lblClientePessoaJuridica);
		
		JButton button_3 = new JButton("");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cadastrar_Cliente cadCli = new Cadastrar_Cliente();
				cadCli.setVisible(true);
				dispose();
			}
		});
		button_3.setIcon(new ImageIcon(Visualizar_Clientes_Pj.class.getResource("/imgs/Back.png")));
		button_3.setBounds(873, 11, 42, 41);
		contentPane.add(button_3);
		
		JLabel label_15 = new JLabel("");
		label_15.setIcon(new ImageIcon(Visualizar_Clientes_Pj.class.getResource("/imgs/client.png")));
		label_15.setBounds(27, 11, 71, 53);
		contentPane.add(label_15);
		
		
		modelo.addColumn("CNPJ");
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
	
	public void setTextField() {
		
		int indice = table.getSelectedRow();
		
		txtCnpj.setText(table.getValueAt(indice, 0).toString());
		txtNome.setText(table.getValueAt(indice, 1).toString());
		//txtSobrenome.setText(table.getValueAt(indice, 2).toString());			
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
	
public void CarregaClientes(String descClientePj) {
		
		try {
			
			ContatoDaoCliente clientePj = new ContatoDaoCliente();
			java.util.List<DadoPj> pj = clientePj.getClientePj(descClientePj);
			modelo.setNumRows(0);
			

			for (DadoPj Clipj : pj) {
				modelo.addRow(
						new Object[] {
								Clipj.getCnpj(),
								Clipj.getNome(),
								Clipj.getSobrenome(),
								Clipj.getDdd(),
								Clipj.getTel1(),
								Clipj.getTel2(),
								Clipj.getCel(),
								Clipj.getCep(),
								Clipj.getRua(),	
								Clipj.getCidade(),															
								Clipj.getEstado(),
								Clipj.getNo(),
								Clipj.getBairro(),
								Clipj.getComplemento()
							
						});
			}
				
			
		} catch (Exception e) {
			System.out.println("Erro ao visualizar Cliente pj: " +e);
		}
	}

//PRECHER O TEXTFIELD COM O TABLE
	
}
