package VIEW;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import CONTROL.DadoPf;
import CONTROL.DadoPj;
import MODEL.ContatoDaoCliente;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JFormattedTextField;

public class Cadastrar_Cliente extends JFrame {

	private JPanel contentPane;
	private JTextField txtNomeCli;
	private JTextField txtCpfCnpj;
	private JComboBox<String> comboBox;
	private JLabel lblTipo;
	private JLabel lblEndereco;
	private JButton btnVoltar;
	private JLabel lblRua;
	private JTextField txtRua;
	private JLabel lblNo;
	private JTextField txtNumero;
	private JLabel lblComplemento;
	private JTextField txtComplemento;
	private JLabel lblCep;
	private JTextField txtCep;
	private JLabel lblTelefone;
	private JLabel lblTelefone_1;
	private JLabel lblCelular;
	private JButton btnSalvarCliente;
	private JLabel lblSobrenome;
	private JTextField txtSobrenome;
	private JFormattedTextField txtTelefone2;
	private JFormattedTextField txtCel;
	private JLabel lblNewLabel;
	private JLabel lblCadastroClientes;
	private JPanel panel;
	private JPanel panel_1;
	private JTextField txtCidade;
	private JTextField txtUf;
	private JButton btnListarClientes;
	private JTextField txtBairro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cadastrar_Cliente frame = new Cadastrar_Cliente();
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
	public Cadastrar_Cliente() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 636, 444);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		this.setLocationRelativeTo(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		MaskFormatter jfid = null;
		MaskFormatter JfTelefone1 = null;
		MaskFormatter JfTelefone2 = null;
		MaskFormatter JfCel1 = null;
		

		try {
		
			JfTelefone1 = new MaskFormatter("####-####");
			JfTelefone2 = new MaskFormatter("####-####");
			JfCel1 = new MaskFormatter("#####-####");

		} catch (Exception e) {
			System.out.println("Erro -> "+ e);
		}

		;


		

		panel = new JPanel();
		panel.setBounds(7, 10, 610, 206);
		contentPane.add(panel);
		panel.setLayout(null);

		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(21, 3, 76, 48);
		panel.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(Cadastrar_Cliente.class.getResource("/imgs/client.png")));

		lblCadastroClientes = new JLabel("Cadastro Clientes ");
		lblCadastroClientes.setBounds(245, 3, 146, 36);
		panel.add(lblCadastroClientes);
		lblCadastroClientes.setFont(new Font("Arial", Font.PLAIN, 16));

		btnVoltar = new JButton("");
		btnVoltar.setBounds(563, 3, 36, 36);
		panel.add(btnVoltar);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Index().setVisible(true);
				dispose();
			}
		});
		btnVoltar.setIcon(new ImageIcon(Cadastrar_Cliente.class.getResource("/imgs/Back.png")));

		lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(9, 95, 46, 14);
		panel.add(lblTipo);
		lblTipo.setFont(new Font("Arial", Font.PLAIN, 12));


		comboBox = new JComboBox<String>();
		comboBox.setBounds(9, 120, 87, 20);
		panel.add(comboBox);

		JLabel lblNomeCliente = new JLabel("Nome Cliente");
		lblNomeCliente.setBounds(122, 95, 102, 14);
		panel.add(lblNomeCliente);
		lblNomeCliente.setFont(new Font("Arial", Font.PLAIN, 12));

		txtNomeCli = new JTextField();
		txtNomeCli.setBounds(122, 120, 136, 20);
		panel.add(txtNomeCli);
		txtNomeCli.setToolTipText("");
		txtNomeCli.setColumns(10);

		lblSobrenome = new JLabel("Sobrenome");
		lblSobrenome.setBounds(267, 95, 76, 14);
		panel.add(lblSobrenome);
		lblSobrenome.setFont(new Font("Arial", Font.PLAIN, 12));

		txtSobrenome = new JTextField();
		txtSobrenome.setBounds(268, 120, 146, 20);
		panel.add(txtSobrenome);
		txtSobrenome.setColumns(10);

		JLabel lblCnpjcpf = new JLabel("CNPJ/CPF");
		lblCnpjcpf.setBounds(465, 95, 65, 14);
		panel.add(lblCnpjcpf);
		lblCnpjcpf.setFont(new Font("Arial", Font.PLAIN, 12));

		txtCpfCnpj = new JTextField();
		txtCpfCnpj.setBounds(465, 120, 114, 20);
		panel.add(txtCpfCnpj);
		txtCpfCnpj.setColumns(10);

		lblTelefone = new JLabel("Telefone1:");
		lblTelefone.setBounds(74, 151, 87, 14);
		panel.add(lblTelefone);
		lblTelefone.setFont(new Font("Arial", Font.PLAIN, 12));

		//FORMATTED TEXTFIELD DOS TELEFONES
		JFormattedTextField txtTelefone1 = new JFormattedTextField(JfTelefone1);
		txtTelefone1.setBounds(75, 177, 114, 20);
		panel.add(txtTelefone1);

		txtTelefone2 = new JFormattedTextField(JfTelefone2);
		txtTelefone2.setBounds(199, 177, 111, 20);
		panel.add(txtTelefone2);

		lblTelefone_1 = new JLabel("Telefone 2:");
		lblTelefone_1.setBounds(197, 151, 76, 14);
		panel.add(lblTelefone_1);
		lblTelefone_1.setFont(new Font("Arial", Font.PLAIN, 12));

		txtCel = new JFormattedTextField(JfCel1);
		txtCel.setBounds(320, 177, 119, 20);
		panel.add(txtCel);

		lblCelular = new JLabel("Celular: ");
		lblCelular.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblCelular.setBounds(322, 151, 69, 14);
		panel.add(lblCelular);
		
		JLabel lblId = new JLabel("DDD");
		lblId.setFont(new Font("Arial", Font.PLAIN, 12));
		lblId.setBounds(21, 151, 34, 14);
		panel.add(lblId);
		
		JFormattedTextField jfDdd = new JFormattedTextField(jfid);
		jfDdd.setBounds(19, 177, 36, 20);
		panel.add(jfDdd);
		
		btnSalvarCliente = new JButton("Cadastrar");
		btnSalvarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				if(comboBox.getSelectedItem().toString().equals("Fisica")) {
					
					//Verificando se os campos estÃ£p preenchidos
					if(txtNomeCli.getText().equals("") || txtSobrenome.getText().equals("") || txtCpfCnpj.getText().equals("") 
							|| txtTelefone1.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Nao pode conter Campos Vazios !");
					}else {
					
						try {
							
							DadoPf pf = new DadoPf();
						
							pf.setNome(txtNomeCli.getText().toUpperCase());
							pf.setSobrenome(txtSobrenome.getText().toUpperCase());
							pf.setCpf(txtCpfCnpj.getText().toUpperCase());
							
							pf.setDdd(jfDdd.getText());
							pf.setTel1(txtTelefone1.getText());
							pf.setTel2(txtTelefone2.getText());
							pf.setCel(txtCel.getText());
							
                                                     
							pf.setCep(txtCep.getText().toUpperCase());
							pf.setRua(txtRua.getText().toUpperCase());
							pf.setCidade(txtCidade.getText().toUpperCase());
							pf.setBairro(txtBairro.getText().toUpperCase());
							pf.setEstado(txtUf.getText().toUpperCase());
							pf.setNo(txtNumero.getText());
							pf.setComplemento(txtComplemento.getText().toUpperCase());

							ContatoDaoCliente dao = new ContatoDaoCliente();

                                                 
							
							dao.adicionaPF(pf);
                                                 
						} catch (Exception ex ) {
							System.err.println("Errr -> " + ex);
						}

					}
				}else {
					if(txtNomeCli.getText().equals("") || txtSobrenome.getText().equals("") || txtCpfCnpj.getText().equals("") 
							|| txtTelefone1.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Nao pode conter Campos Vazios !");
					}else {
						try {

							DadoPj pj = new DadoPj();
							pj.setTipo(comboBox.getActionCommand().toUpperCase());
							pj.setNome(txtNomeCli.getText().toUpperCase());
							pj.setSobrenome(txtSobrenome.getText().toUpperCase());
							pj.setCnpj(txtCpfCnpj.getText());
							
							pj.setDdd(jfDdd.getText());
							pj.setTel1(txtTelefone1.getText().toUpperCase());
							pj.setTel2(txtTelefone2.getText().toUpperCase());
							pj.setCel(txtCel.getText().toUpperCase());
							
							pj.setCep(txtCep.getText().toUpperCase());
							pj.setRua(txtRua.getText().toUpperCase());
							pj.setCidade(txtCidade.getText().toUpperCase());
							pj.setBairro(txtBairro.getText().toUpperCase());
							pj.setEstado(txtUf.getText().toUpperCase());
							pj.setNo(txtNumero.getText());
							pj.setComplemento(txtComplemento.getText().toUpperCase());
							
						
							ContatoDaoCliente dao = new ContatoDaoCliente();
							
							
							dao.adicionaPj(pj);
							
						
						} catch (Exception e2) {
							System.out.println("Errr ->" +e2);
						}		

					}
				}	
			}
		});
		btnSalvarCliente.setBounds(488, 371, 114, 23);
		contentPane.add(btnSalvarCliente);

		panel_1 = new JPanel();
		panel_1.setBounds(9, 219, 608, 142);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		lblEndereco = new JLabel("ENDERECO");
		lblEndereco.setBounds(5, 4, 87, 14);
		panel_1.add(lblEndereco);
		lblEndereco.setFont(new Font("Arial", Font.PLAIN, 12));

		lblCep = new JLabel("CEP");
		lblCep.setBounds(5, 29, 46, 14);
		panel_1.add(lblCep);
		lblCep.setFont(new Font("Arial", Font.PLAIN, 12));

		txtCep = new JTextField();
		txtCep.setBounds(6, 54, 86, 20);
		panel_1.add(txtCep);
		txtCep.setColumns(10);

		lblRua = new JLabel("Rua");
		lblRua.setBounds(5, 85, 87, 14);
		panel_1.add(lblRua);
		lblRua.setFont(new Font("Arial", Font.PLAIN, 12));

		txtRua = new JTextField();
		txtRua.setBounds(5, 110, 302, 20);
		panel_1.add(txtRua);
		txtRua.setColumns(10);

		txtNumero = new JTextField();
		txtNumero.setBounds(317, 110, 65, 20);
		panel_1.add(txtNumero);
		txtNumero.setColumns(10);

		lblNo = new JLabel("No\u00BA");
		lblNo.setBounds(317, 85, 46, 14);
		panel_1.add(lblNo);
		lblNo.setFont(new Font("Arial", Font.PLAIN, 12));

		lblComplemento = new JLabel("Complemento");
		lblComplemento.setBounds(400, 85, 93, 14);
		panel_1.add(lblComplemento);
		lblComplemento.setFont(new Font("Arial", Font.PLAIN, 12));

		txtComplemento = new JTextField();
		txtComplemento.setBounds(392, 110, 179, 20);
		panel_1.add(txtComplemento);
		txtComplemento.setColumns(10);
		
		JLabel lblCidade = new JLabel("CIDADE");
		lblCidade.setFont(new Font("Arial", Font.PLAIN, 12));
		lblCidade.setBounds(101, 30, 57, 14);
		panel_1.add(lblCidade);
		
		txtCidade = new JTextField();
		txtCidade.setBounds(101, 54, 149, 20);
		panel_1.add(txtCidade);
		txtCidade.setColumns(10);
		
		JLabel lblUf = new JLabel("UF");
		lblUf.setFont(new Font("Arial", Font.PLAIN, 12));
		lblUf.setBounds(261, 30, 46, 14);
		panel_1.add(lblUf);
		
		txtUf = new JTextField();
		txtUf.setBounds(255, 54, 33, 20);
		panel_1.add(txtUf);
		txtUf.setColumns(10);
		
		JLabel lblBairro = new JLabel("BAIRRO");
		lblBairro.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblBairro.setBounds(317, 29, 70, 15);
		panel_1.add(lblBairro);
		
		txtBairro = new JTextField();
		txtBairro.setBounds(300, 54, 114, 19);
		panel_1.add(txtBairro);
		txtBairro.setColumns(10);
		
		btnListarClientes = new JButton("Listar Clientes");
		btnListarClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Object[] selectionValues = {"Pessoa Física","Pessoa Jurídica"};
				String initialSelection = "Pessoa Fisica";
				 Object selection = JOptionPane.showInputDialog(null, "Selecione o Cliente ",
					        "Clientes", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
			if (selection == "Pessoa Física") {
				Visualizar_Clientes_Pf visu_clientes = new Visualizar_Clientes_Pf();
				visu_clientes.setVisible(true);
				dispose();
				
			}else if (selection == "Pessoa Jurídica" ) {
				Visualizar_Clientes_Pj visu_clientes = new Visualizar_Clientes_Pj();
				visu_clientes.setVisible(true);
				dispose();

			}else {
				Cadastrar_Cliente cc = new Cadastrar_Cliente();
				cc.setVisible(true);
				dispose();
			}
				
				
				
				
//				if(comboBox.getSelectedItem().toString().equals("Fisica")) {
//				
//				Visualizar_Clientes_Pf visu_clientes = new Visualizar_Clientes_Pf();
//				visu_clientes.setVisible(true);
//				dispose();
//				
//				}else {
//					Visualizar_Clientes_Pj visu_clientes = new Visualizar_Clientes_Pj();
//					visu_clientes.setVisible(true);
//					dispose();
//					
//				}
			}
		});
		btnListarClientes.setBounds(322, 371, 154, 23);
		contentPane.add(btnListarClientes);
		comboBox.addItem("Fisica");
		comboBox.addItem("Juridica");






	}
}
