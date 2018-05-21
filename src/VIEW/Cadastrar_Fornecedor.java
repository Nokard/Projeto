package VIEW;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.border.LineBorder;

import CONTROL.DadoFornec;
import MODEL.ContatoDaoFornecedor;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Cadastrar_Fornecedor extends JFrame {

	private JPanel contentPane;
	private JTextField txtNomeFantasia;
	private JTextField txtRazaoSocial;
	private JTextField txtCnpj;
	private JTextField txtCep;
	private JTextField txtCidade;
	private JTextField txtUf;
	private JTextField txtDdd;
	private JTextField txtTel1;
	private JTextField txtTel2;
	private JTextField txtCel;
	private JTextField txtRua;
	private JTextField txtComplemento;
	private JTextField txtNumero;
	private JTextField txtBairro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cadastrar_Fornecedor frame = new Cadastrar_Fornecedor();
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
	public Cadastrar_Fornecedor() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 636, 444);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		this.setLocationRelativeTo(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.GRAY));
		panel.setBounds(12, 67, 612, 167);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		
		JLabel lblNomeFornecedor = new JLabel("Nome Fantasia");
		lblNomeFornecedor.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNomeFornecedor.setBounds(12, 12, 131, 15);
		panel.add(lblNomeFornecedor);
		
		txtNomeFantasia = new JTextField();
		txtNomeFantasia.setBounds(12, 32, 156, 19);
		panel.add(txtNomeFantasia);
		txtNomeFantasia.setColumns(10);
		
		JLabel lblRazoSocial = new JLabel("Razão Social");
		lblRazoSocial.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblRazoSocial.setBounds(192, 12, 105, 15);
		panel.add(lblRazoSocial);
		
		txtRazaoSocial = new JTextField();
		txtRazaoSocial.setBounds(192, 32, 343, 19);
		panel.add(txtRazaoSocial);
		txtRazaoSocial.setColumns(10);
		
		JLabel lblCnpj = new JLabel("CNPJ");
		lblCnpj.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblCnpj.setBounds(12, 63, 70, 15);
		panel.add(lblCnpj);
		
		txtCnpj = new JTextField();
		txtCnpj.setBounds(12, 79, 156, 19);
		panel.add(txtCnpj);
		txtCnpj.setColumns(10);
		
		JLabel lblDdd = new JLabel("DDD");
		lblDdd.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblDdd.setBounds(12, 109, 57, 15);
		panel.add(lblDdd);
		
		JLabel lblTel = new JLabel("Telefone 1");
		lblTel.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblTel.setBounds(68, 110, 90, 15);
		panel.add(lblTel);
		
		JLabel lblTelefone = new JLabel("Telefone 2");
		lblTelefone.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblTelefone.setBounds(207, 109, 90, 15);
		panel.add(lblTelefone);
		
		JLabel lblCelular = new JLabel("Celular");
		lblCelular.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblCelular.setBounds(318, 109, 70, 15);
		panel.add(lblCelular);
		
		txtDdd = new JTextField();
		txtDdd.setBounds(12, 136, 44, 19);
		panel.add(txtDdd);
		txtDdd.setColumns(10);
		
		txtTel1 = new JTextField();
		txtTel1.setBounds(68, 136, 114, 19);
		panel.add(txtTel1);
		txtTel1.setColumns(10);
		
		txtTel2 = new JTextField();
		txtTel2.setBounds(192, 136, 114, 19);
		panel.add(txtTel2);
		txtTel2.setColumns(10);
		
		txtCel = new JTextField();
		txtCel.setBounds(318, 136, 114, 19);
		panel.add(txtCel);
		txtCel.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(Color.GRAY));
		panel_1.setBounds(12, 246, 612, 130);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblCep = new JLabel("Cep");
		lblCep.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblCep.setBounds(10, 12, 70, 15);
		panel_1.add(lblCep);
		
		txtCep = new JTextField();
		txtCep.setBounds(10, 30, 81, 19);
		panel_1.add(txtCep);
		txtCep.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Cidade");
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNewLabel.setBounds(106, 12, 70, 15);
		panel_1.add(lblNewLabel);
		
		txtCidade = new JTextField();
		txtCidade.setBounds(103, 30, 206, 19);
		panel_1.add(txtCidade);
		txtCidade.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Uf");
		lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(321, 12, 70, 15);
		panel_1.add(lblNewLabel_1);
		
		txtUf = new JTextField();
		txtUf.setBounds(321, 30, 114, 19);
		panel_1.add(txtUf);
		txtUf.setColumns(10);
		
		JLabel lblRu = new JLabel("Rua");
		lblRu.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblRu.setBounds(10, 54, 70, 15);
		panel_1.add(lblRu);
		
		JLabel lblComplemento = new JLabel("Complemento");
		lblComplemento.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblComplemento.setBounds(331, 54, 97, 15);
		panel_1.add(lblComplemento);
		
		txtRua = new JTextField();
		txtRua.setBounds(10, 71, 114, 19);
		panel_1.add(txtRua);
		txtRua.setColumns(10);
		
		txtComplemento = new JTextField();
		txtComplemento.setBounds(331, 71, 206, 19);
		panel_1.add(txtComplemento);
		txtComplemento.setColumns(10);
		
		JLabel lblNo = new JLabel("Noº");
		lblNo.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNo.setBounds(135, 54, 70, 15);
		panel_1.add(lblNo);
		
		txtNumero = new JTextField();
		txtNumero.setBounds(136, 71, 54, 19);
		panel_1.add(txtNumero);
		txtNumero.setColumns(10);
		
		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblBairro.setBounds(202, 54, 70, 15);
		panel_1.add(lblBairro);
		
		txtBairro = new JTextField();
		txtBairro.setBounds(202, 71, 114, 19);
		panel_1.add(txtBairro);
		txtBairro.setColumns(10);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Index cadastro = new Index();
				cadastro.setVisible(true);
				dispose();
			}
		});
		button.setIcon(new ImageIcon(Cadastrar_Fornecedor.class.getResource("/imgs/Back.png")));
		button.setBounds(568, 4, 56, 36);
		contentPane.add(button);
		
		JLabel lblCadastroFornecedor = new JLabel("Cadastro Fornecedor");
		lblCadastroFornecedor.setFont(new Font("Dialog", Font.BOLD, 16));
		lblCadastroFornecedor.setBounds(236, 14, 201, 26);
		contentPane.add(lblCadastroFornecedor);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Cadastrar_Fornecedor.class.getResource("/imgs/fornecedor.png")));
		label.setBounds(21, 4, 56, 51);
		contentPane.add(label);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (txtNomeFantasia.getText().trim().isEmpty()|| txtRazaoSocial.getText().trim().isEmpty()|| 
						txtBairro.getText().trim().isEmpty()|| txtCel.getText().trim().isEmpty()|| txtCep.getText().trim().isEmpty()||
						txtCidade.getText().trim().isEmpty()|| txtCnpj.getText().trim().isEmpty()|| txtComplemento.getText().trim().isEmpty()||
						txtDdd.getText().trim().isEmpty()|| txtNumero.getText().trim().isEmpty()|| txtRua.getText().trim().isEmpty()|| txtTel1.getText().trim().isEmpty()||
						txtTel2.getText().trim().isEmpty()|| txtUf.getText().trim().isEmpty()) 
				{
					JOptionPane.showMessageDialog(null, "Não pode conter nenhum campo vazio !");
					
				} else {
					
					try {
						
						DadoFornec DadoFornec = new DadoFornec();
						int ddd = Integer.parseInt(txtDdd.getText());
						
						
						DadoFornec.setNomeFantasia(txtNomeFantasia.getText().toUpperCase());
						DadoFornec.setRazaoSocial(txtRazaoSocial.getText().toUpperCase());
						DadoFornec.setBairro(txtBairro.getText().toUpperCase());
						DadoFornec.setCel(txtCel.getText());
						DadoFornec.setCep(txtCep.getText());
						DadoFornec.setCidade(txtCidade.getText().toUpperCase());
						DadoFornec.setCnpj(txtCnpj.getText());
						DadoFornec.setComplemento(txtComplemento.getText().toUpperCase());
						DadoFornec.setDdd(ddd);
						DadoFornec.setNo(txtNumero.getText());
						DadoFornec.setRua(txtRua.getText().toUpperCase());
						DadoFornec.setTel1(txtTel1.getText());
						DadoFornec.setTel2(txtTel2.getText());
						DadoFornec.setEstado(txtUf.getText().toUpperCase());
						
						ContatoDaoFornecedor daoFornec = new ContatoDaoFornecedor();
						
						daoFornec.adicionaFornecedor(DadoFornec);
						
					} catch (Exception e2) {
						System.out.println("Erro Cadastrar_fornecedor: " +e2);
					}
					

				}
				
			}
		});
		btnCadastrar.setBounds(507, 377, 117, 25);
		contentPane.add(btnCadastrar);
		
		JButton btnFornecedores = new JButton("Fornecedores");
		btnFornecedores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Visualizar_Fornecedor visu_fornec = new Visualizar_Fornecedor();
				visu_fornec.setVisible(true);
				dispose();
			}
		});
		btnFornecedores.setBounds(347, 377, 132, 25);
		contentPane.add(btnFornecedores);
	}
}
