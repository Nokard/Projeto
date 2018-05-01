package VIEW;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import CONTROL.DadoFornec;
import DAO.ContatoDaoFornecedor;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

public class Visualizar_Fornecedor extends JFrame {

	private JPanel contentPane;
	private JTextField txtNomeFantasia;
	private JTextField txtRazaoSocial;
	private JTextField txtCnpj;
	private JTextField txtDdd;
	private JTextField txtTel1;
	private JTextField txtTel2;
	private JTextField txtCel;
	private JTextField txtCep;
	private JTextField txtCidade;
	private JTextField txtUf;
	private JTextField txtRua;
	private JTextField txtNo;
	private JTextField txtBairro;
	private JTextField txtComplemento;
	private JTextField txtPesquisaFornecedor;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Visualizar_Fornecedor frame = new Visualizar_Fornecedor();
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
	
	public Visualizar_Fornecedor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 571);
		contentPane = new JPanel();
		this.setLocationRelativeTo(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.GRAY));
		panel.setBounds(28, 57, 894, 240);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel label = new JLabel("Nome Fantasia");
		label.setFont(new Font("Dialog", Font.PLAIN, 12));
		label.setBounds(12, 12, 131, 15);
		panel.add(label);

		JLabel label_1 = new JLabel("Razão Social");
		label_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		label_1.setBounds(192, 12, 105, 15);
		panel.add(label_1);

		JLabel label_2 = new JLabel("CNPJ");
		label_2.setFont(new Font("Dialog", Font.PLAIN, 12));
		label_2.setBounds(557, 12, 70, 15);
		panel.add(label_2);

		JLabel label_3 = new JLabel("DDD");
		label_3.setFont(new Font("Dialog", Font.PLAIN, 12));
		label_3.setBounds(12, 70, 57, 15);
		panel.add(label_3);

		JLabel label_4 = new JLabel("Telefone 1");
		label_4.setFont(new Font("Dialog", Font.PLAIN, 12));
		label_4.setBounds(68, 71, 90, 15);
		panel.add(label_4);

		JLabel label_5 = new JLabel("Telefone 2");
		label_5.setFont(new Font("Dialog", Font.PLAIN, 12));
		label_5.setBounds(207, 70, 90, 15);
		panel.add(label_5);

		JLabel label_6 = new JLabel("Celular");
		label_6.setFont(new Font("Dialog", Font.PLAIN, 12));
		label_6.setBounds(318, 70, 70, 15);
		panel.add(label_6);

		txtNomeFantasia = new JTextField();
		txtNomeFantasia.setColumns(10);
		txtNomeFantasia.setBounds(12, 39, 156, 19);
		panel.add(txtNomeFantasia);

		txtRazaoSocial = new JTextField();
		txtRazaoSocial.setColumns(10);
		txtRazaoSocial.setBounds(192, 39, 343, 19);
		panel.add(txtRazaoSocial);

		txtCnpj = new JTextField();
		txtCnpj.setColumns(10);
		txtCnpj.setBounds(557, 39, 156, 19);
		panel.add(txtCnpj);

		txtDdd = new JTextField();
		txtDdd.setColumns(10);
		txtDdd.setBounds(12, 97, 44, 19);
		panel.add(txtDdd);

		txtTel1 = new JTextField();
		txtTel1.setColumns(10);
		txtTel1.setBounds(68, 97, 114, 19);
		panel.add(txtTel1);

		txtTel2 = new JTextField();
		txtTel2.setColumns(10);
		txtTel2.setBounds(192, 97, 114, 19);
		panel.add(txtTel2);

		txtCel = new JTextField();
		txtCel.setColumns(10);
		txtCel.setBounds(318, 97, 114, 19);
		panel.add(txtCel);

		JLabel label_7 = new JLabel("Cep");
		label_7.setFont(new Font("Dialog", Font.PLAIN, 12));
		label_7.setBounds(12, 126, 70, 15);
		panel.add(label_7);

		JLabel cidade = new JLabel("Cidade");
		cidade.setFont(new Font("Dialog", Font.PLAIN, 12));
		cidade.setBounds(344, 126, 70, 15);
		panel.add(cidade);

		JLabel label_9 = new JLabel("Uf");
		label_9.setFont(new Font("Dialog", Font.PLAIN, 12));
		label_9.setBounds(557, 126, 70, 15);
		panel.add(label_9);

		txtCep = new JTextField();
		txtCep.setColumns(10);
		txtCep.setBounds(12, 153, 81, 19);
		panel.add(txtCep);

		txtCidade = new JTextField();
		txtCidade.setColumns(10);
		txtCidade.setBounds(344, 153, 206, 19);
		panel.add(txtCidade);

		txtUf = new JTextField();
		txtUf.setColumns(10);
		txtUf.setBounds(562, 153, 114, 19);
		panel.add(txtUf);

		JLabel label_10 = new JLabel("Rua");
		label_10.setFont(new Font("Dialog", Font.PLAIN, 12));
		label_10.setBounds(116, 128, 70, 15);
		panel.add(label_10);

		txtRua = new JTextField();
		txtRua.setColumns(10);
		txtRua.setBounds(116, 153, 114, 19);
		panel.add(txtRua);

		txtNo = new JTextField();
		txtNo.setColumns(10);
		txtNo.setBounds(252, 153, 54, 19);
		panel.add(txtNo);

		JLabel label_11 = new JLabel("Noº");
		label_11.setFont(new Font("Dialog", Font.PLAIN, 12));
		label_11.setBounds(252, 128, 70, 15);
		panel.add(label_11);

		JLabel label_12 = new JLabel("Bairro");
		label_12.setFont(new Font("Dialog", Font.PLAIN, 12));
		label_12.setBounds(12, 177, 70, 15);
		panel.add(label_12);

		txtBairro = new JTextField();
		txtBairro.setColumns(10);
		txtBairro.setBounds(12, 194, 114, 19);
		panel.add(txtBairro);

		txtComplemento = new JTextField();
		txtComplemento.setColumns(10);
		txtComplemento.setBounds(138, 194, 206, 19);
		panel.add(txtComplemento);

		JLabel label_13 = new JLabel("Complemento");
		label_13.setFont(new Font("Dialog", Font.PLAIN, 12));
		label_13.setBounds(138, 177, 97, 15);
		panel.add(label_13);

		txtPesquisaFornecedor = new JTextField();
		txtPesquisaFornecedor.setBounds(645, 309, 142, 25);
		contentPane.add(txtPesquisaFornecedor);
		txtPesquisaFornecedor.setColumns(10);

		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CarregaFornecedor(txtPesquisaFornecedor.getText());
			}
		});
		btnPesquisar.setBounds(799, 309, 117, 25);
		contentPane.add(btnPesquisar);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(table.getSelectedRow() != -1) {
					int yes = JOptionPane.showConfirmDialog(null, "Você realmente deseja DELETAR esse Funcionario ?","DELETE",JOptionPane.YES_NO_OPTION);	
						if (yes == 0) {
							try {

								DadoFornec dadoFornec = new DadoFornec();
								ContatoDaoFornecedor daoFornec = new ContatoDaoFornecedor();
								
								//seta o valor do cnpj da tabela no dadoFornec
								dadoFornec.setCnpj((String) table.getValueAt(table.getSelectedRow(), 0));

								daoFornec.DeleteFornecedor(dadoFornec);

							} catch (Exception e2) {
								System.out.println("Erro no deletar: " +e2);
							}							
							
						}
					
				}else {
					JOptionPane.showMessageDialog(null, "Selecione um registro para excluir !");
				}
			}
		});
		btnExcluir.setBounds(516, 309, 117, 25);
		contentPane.add(btnExcluir);

		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				if (table.getSelectedRow() != -1) {
					int yes = JOptionPane.showConfirmDialog(null, "Você realmente deseja ATUALIZAR esse Funcionario ?","ATUALIZAR",JOptionPane.YES_NO_OPTION);	
					if (yes == 0) {
						
						DadoFornec fornec = new DadoFornec();
						ContatoDaoFornecedor daoFornec = new ContatoDaoFornecedor();
						
						int ddd = Integer.parseInt(txtDdd.getText());
						
						fornec.setBairro(txtBairro.getText().toUpperCase());
						fornec.setCel(txtCel.getText());
						fornec.setCep(txtCep.getText());
						fornec.setCidade(txtCidade.getText().toUpperCase());
						fornec.setCnpj(txtCnpj.getText());
						fornec.setComplemento(txtComplemento.getText().toUpperCase());
						fornec.setDdd(ddd);
						fornec.setNo(txtNo.getText());
						fornec.setNomeFantasia(txtNomeFantasia.getText().toUpperCase());
						fornec.setRazaoSocial(txtRazaoSocial.getText().toUpperCase());
						fornec.setRua(txtRua.getText().toUpperCase());
						fornec.setTel1(txtTel1.getText());
						fornec.setTel2(txtTel2.getText());
						fornec.setEstado(txtUf.getText().toUpperCase());
						
						daoFornec.UpdateFornec(fornec);
						
						limparTextField();
						
					}
				
				}else {
					JOptionPane.showMessageDialog(null, "Selecione um registro para Atualizar");
				}
			
				
			}
		});
		btnAtualizar.setBounds(387, 309, 117, 25);
		contentPane.add(btnAtualizar);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 346, 894, 183);
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
			}
			@Override
			public void keyReleased(KeyEvent e) {
				setTextField();
			}
		});
		scrollPane.setViewportView(table);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Cadastrar_Fornecedor cadFornec = new Cadastrar_Fornecedor();
				cadFornec.setVisible(true);
				dispose();
			}
		});
		button.setIcon(new ImageIcon(Visualizar_Fornecedor.class.getResource("/imgs/Back.png")));
		button.setBounds(871, 12, 51, 33);
		contentPane.add(button);
		
		JLabel label_8 = new JLabel("");
		label_8.setIcon(new ImageIcon(Visualizar_Fornecedor.class.getResource("/imgs/fornecedor.png")));
		label_8.setBounds(42, 0, 51, 45);
		contentPane.add(label_8);
		
		JLabel lblVisualizarFornecedores = new JLabel("Visualizar Fornecedores");
		lblVisualizarFornecedores.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblVisualizarFornecedores.setBounds(360, 12, 195, 25);
		contentPane.add(lblVisualizarFornecedores);
		
		
		
		modelo.addColumn("CNPJ");
		modelo.addColumn("Nome Fantasia");
		modelo.addColumn("Razão Social");
		modelo.addColumn("DDD");
		modelo.addColumn("telefone 1");
		modelo.addColumn("Telefone 2");
		modelo.addColumn("Celular");
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
		
		txtNomeFantasia.setText(table.getValueAt(indice, 1).toString());
		txtRazaoSocial.setText(table.getValueAt(indice, 2).toString());
		txtCnpj.setText(table.getValueAt(indice, 0).toString());
		txtDdd.setText(table.getValueAt(indice, 3).toString());
		txtTel1.setText(table.getValueAt(indice, 4).toString());
		txtTel2.setText(table.getValueAt(indice, 5).toString());
		txtCel.setText(table.getValueAt(indice, 6).toString());
		txtCep.setText(table.getValueAt(indice, 7).toString());
		txtRua.setText(table.getValueAt(indice, 8).toString());
		txtCidade.setText(table.getValueAt(indice, 9).toString());
		txtUf.setText(table.getValueAt(indice, 10).toString());
		txtNo.setText(table.getValueAt(indice, 11).toString());
		txtBairro.setText(table.getValueAt(indice, 12).toString());		
		txtComplemento.setText(table.getValueAt(indice, 13).toString());		
		
		
	}
	

	public void CarregaFornecedor(String descFornec) {

		try {

			ContatoDaoFornecedor daoFornec = new ContatoDaoFornecedor();
			List<DadoFornec> dadoFornec = daoFornec.getFornecedoresDesc(descFornec);
			modelo.setNumRows(0);
			
			for (DadoFornec fornecedor : dadoFornec) {
				modelo.addRow(
					new Object[] {
							fornecedor.getCnpj(),
							fornecedor.getNomeFantasia(),
							fornecedor.getRazaoSocial(),
							fornecedor.getDdd(),
							fornecedor.getTel1(),
							fornecedor.getTel2(),
							fornecedor.getCel(),
							fornecedor.getCep(),
							fornecedor.getRua(),
							fornecedor.getCidade(),
							fornecedor.getEstado(),
							fornecedor.getNo(),
							fornecedor.getBairro(),
							fornecedor.getComplemento()
					});
			}

		} catch (Exception e) {
			System.out.println("Erro ao visualizar o Fornecedor: " +e);
		}
	}
	
	public void limparTextField() {
		
		txtNomeFantasia.setText("");
		txtRazaoSocial.setText("");
		txtCnpj.setText("");
		txtDdd.setText("");
		txtTel1.setText("");
		txtTel2.setText("");
		txtCel.setText("");
		txtCep.setText("");
		txtCidade.setText("");
		txtUf.setText("");
		txtRua.setText("");
		txtNo.setText("");
		txtBairro.setText("");
		txtComplemento.setText("");
		
		
		
	}
}
