package VIEW;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import CONTROL.DadoFunc;
import DAO.ContatoDaoFuncionario;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

public class Cadastro_Funcionario extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtSobrenome;
	private JTextField txtCpf;
	private JTextField txtRg;
	private JTextField txtRua;
	private JTextField txtNumero;
	private JTextField txtComplemento;
	private JTextField txtDdd;
	private JTextField txtCidade;
	private JTextField txtUf;
	private JTextField txtBairro;
	private JTextField txtCargo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cadastro_Funcionario frame = new Cadastro_Funcionario();
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
	public Cadastro_Funcionario() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 641, 419);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		this.setLocationRelativeTo(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//MASCARA PARA OS CAMPOS
		MaskFormatter JfTelefone1 = null;
		MaskFormatter JfTelefone2 = null;
		MaskFormatter JfCel1 = null;
		MaskFormatter jfCpf = null;
		MaskFormatter jfRg = null;
		
		try {
			JfTelefone1 = new MaskFormatter("####-####");
			JfTelefone2 = new MaskFormatter("####-####");
			JfCel1 = new MaskFormatter("#####-####");
			jfCpf = new MaskFormatter("###########");
			jfRg = new MaskFormatter("#########");
		} catch (Exception e) {
			System.out.println("Erro -> "+ e);
		}
		
		JButton btnCancelar = new JButton("LISTAR FUNCIONARIOS");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Visualizar_Funcionario visu_funcionario = new Visualizar_Funcionario();
				visu_funcionario.setVisible(true);
				dispose();
			}
		});
		btnCancelar.setBounds(164, 347, 223, 23);
		contentPane.add(btnCancelar);
		
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(128, 128, 128), 1, true));
		panel.setBounds(17, 11, 602, 174);
		contentPane.add(panel);
		panel.setLayout(null);
		
		txtNome = new JTextField();
		txtNome.setBounds(11, 89, 138, 20);
		panel.add(txtNome);
		txtNome.setColumns(10);
		
		txtSobrenome = new JTextField();
		txtSobrenome.setBounds(159, 89, 138, 20);
		panel.add(txtSobrenome);
		txtSobrenome.setColumns(10);
		
		txtCpf = new JTextField();
		txtCpf.setBounds(306, 89, 138, 20);
		panel.add(txtCpf);
		txtCpf.setColumns(10);
		
		txtRg = new JTextField();
		txtRg.setBounds(454, 89, 138, 20);
		panel.add(txtRg);
		txtRg.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(306, 64, 46, 14);
		panel.add(lblCpf);
		lblCpf.setFont(new Font("Arial", Font.PLAIN, 12));
		
		JLabel lblRg = new JLabel("RG");
		lblRg.setBounds(454, 64, 70, 14);
		panel.add(lblRg);
		lblRg.setFont(new Font("Arial", Font.PLAIN, 12));
		
		JLabel lblSobrenome = new JLabel("SOBRENOME");
		lblSobrenome.setBounds(161, 64, 91, 14);
		panel.add(lblSobrenome);
		lblSobrenome.setFont(new Font("Arial", Font.PLAIN, 12));
		
		JLabel lblNome = new JLabel("NOME");
		lblNome.setBounds(11, 64, 46, 14);
		panel.add(lblNome);
		lblNome.setFont(new Font("Arial", Font.PLAIN, 12));
		
		JLabel lbIcone = new JLabel("");
		lbIcone.setBounds(8, 5, 48, 48);
		panel.add(lbIcone);
		lbIcone.setBackground(Color.WHITE);
		lbIcone.setIcon(new ImageIcon(Cadastro_Funcionario.class.getResource("/imgs/employess.png")));
		
		JLabel lblCadastroDeFuncionrio = new JLabel("Cadastro de Funcion\u00E1rio");
		lblCadastroDeFuncionrio.setBounds(217, 15, 213, 36);
		panel.add(lblCadastroDeFuncionrio);
		lblCadastroDeFuncionrio.setFont(new Font("Arial", Font.PLAIN, 16));
		
		JButton btnVoltar = new JButton("");
		btnVoltar.setBounds(555, 15, 36, 36);
		panel.add(btnVoltar);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cadastro cadastro = new Cadastro();
				cadastro.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setIcon(new ImageIcon(Cadastro_Funcionario.class.getResource("/imgs/Back.png")));
		
		JLabel lblTelefone = new JLabel("TELEFONE1");
		lblTelefone.setBounds(71, 120, 80, 14);
		panel.add(lblTelefone);
		lblTelefone.setFont(new Font("Arial", Font.PLAIN, 12));
		
		JFormattedTextField jfTelefone1 = new JFormattedTextField(JfTelefone1);
		jfTelefone1.setBounds(71, 145, 100, 20);
		panel.add(jfTelefone1);
		
		JLabel lblTelefone_1 = new JLabel("TELEFONE2");
		lblTelefone_1.setBounds(182, 120, 70, 14);
		panel.add(lblTelefone_1);
		lblTelefone_1.setFont(new Font("Arial", Font.PLAIN, 12));
		
		JFormattedTextField jfTelefone2 = new JFormattedTextField(JfTelefone2);
		jfTelefone2.setBounds(181, 145, 100, 20);
		panel.add(jfTelefone2);
		
		JLabel lblCelular = new JLabel("CELULAR");
		lblCelular.setBounds(306, 120, 65, 14);
		panel.add(lblCelular);
		lblCelular.setFont(new Font("Arial", Font.PLAIN, 12));
		
		JFormattedTextField jfCel = new JFormattedTextField(JfCel1);
		jfCel.setBounds(306, 145, 124, 20);
		panel.add(jfCel);
		
		JLabel lblId = new JLabel("DDD");
		lblId.setFont(new Font("Arial", Font.PLAIN, 12));
		lblId.setBounds(11, 120, 46, 14);
		panel.add(lblId);
		
		txtDdd = new JTextField();
		txtDdd.setBounds(11, 145, 46, 20);
		panel.add(txtDdd);
		txtDdd.setColumns(10);
		
		JLabel lblCargo = new JLabel("CARGO");
		lblCargo.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblCargo.setBounds(443, 120, 70, 15);
		panel.add(lblCargo);
		
		txtCargo = new JTextField();
		txtCargo.setBounds(439, 145, 114, 19);
		panel.add(txtCargo);
		txtCargo.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(128, 128, 128), 1, true));
		panel_1.setBounds(16, 190, 603, 153);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		txtRua = new JTextField();
		txtRua.setBounds(10, 111, 246, 20);
		panel_1.add(txtRua);
		txtRua.setColumns(10);
		
		txtNumero = new JTextField();
		txtNumero.setBounds(266, 111, 86, 20);
		panel_1.add(txtNumero);
		txtNumero.setColumns(10);
		
		txtComplemento = new JTextField();
		txtComplemento.setBounds(381, 111, 157, 20);
		panel_1.add(txtComplemento);
		txtComplemento.setColumns(10);
		
		JLabel lblComplemento = new JLabel("COMPLEMENTO");
		lblComplemento.setBounds(381, 85, 116, 14);
		panel_1.add(lblComplemento);
		lblComplemento.setFont(new Font("Arial", Font.PLAIN, 12));
		
		JLabel lblNo = new JLabel("NO\u00BA");
		lblNo.setBounds(266, 85, 46, 14);
		panel_1.add(lblNo);
		lblNo.setFont(new Font("Arial", Font.PLAIN, 12));
		
		JLabel lblLogradouro = new JLabel("RUA");
		lblLogradouro.setBounds(10, 85, 91, 14);
		panel_1.add(lblLogradouro);
		lblLogradouro.setFont(new Font("Arial", Font.PLAIN, 12));
		
		JLabel lblCep = new JLabel("CEP");
		lblCep.setBounds(10, 20, 46, 14);
		panel_1.add(lblCep);
		lblCep.setFont(new Font("Arial", Font.PLAIN, 12));
		
		JFormattedTextField txtCep = new JFormattedTextField();
		txtCep.setBounds(10, 39, 91, 20);
		panel_1.add(txtCep);
		
		JLabel lblCidade = new JLabel("CIDADE");
		lblCidade.setFont(new Font("Arial", Font.PLAIN, 12));
		lblCidade.setBounds(113, 21, 46, 14);
		panel_1.add(lblCidade);
		
		txtCidade = new JTextField();
		txtCidade.setBounds(111, 39, 86, 20);
		panel_1.add(txtCidade);
		txtCidade.setColumns(10);
		
		JLabel lblUf = new JLabel("UF");
		lblUf.setFont(new Font("Arial", Font.PLAIN, 12));
		lblUf.setBounds(211, 20, 28, 14);
		panel_1.add(lblUf);
		
		txtUf = new JTextField();
		txtUf.setBounds(211, 39, 54, 20);
		panel_1.add(txtUf);
		txtUf.setColumns(10);
		
		JLabel lblBairro = new JLabel("BAIRRO");
		lblBairro.setFont(new Font("Arial", Font.PLAIN, 12));
		lblBairro.setBounds(280, 21, 46, 14);
		panel_1.add(lblBairro);
		
		txtBairro = new JTextField();
		txtBairro.setBounds(279, 39, 86, 20);
		panel_1.add(txtBairro);
		txtBairro.setColumns(10);
		
	
		JButton btnSalvar = new JButton("SALVAR FUNCIONARIO");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					Visualizar_Funcionario visuFunc = new Visualizar_Funcionario();
					DadoFunc func = new DadoFunc();
					int ddd = Integer.parseInt(txtDdd.getText());

					
					func.setNome(txtNome.getText().toUpperCase());
					func.setSobrenome(txtSobrenome.getText().toUpperCase());
					func.setRg(txtRg.getText());
					func.setCpf(txtCpf.getText());
					func.setCargo(txtCargo.getText().toUpperCase());
					func.setDdd(ddd);
					func.setTel1(jfTelefone1.getText());
					func.setTel2(jfTelefone2.getText());
					func.setCel(jfCel.getText());
					func.setCep(txtCep.getText());
					func.setCidade(txtCidade.getText().toUpperCase());
					func.setEstado(txtUf.getText().toUpperCase());
					func.setRua(txtRua.getText().toUpperCase());
					func.setBairro(txtBairro.getText().toUpperCase());
					func.setNo(txtNumero.getText());
					func.setComplemento(txtComplemento.getText().toUpperCase());
					
					ContatoDaoFuncionario daoFunc = new ContatoDaoFuncionario();
					
					daoFunc.adicionaFuncionario(func);
					
					visuFunc.limparTextField();
					
					
					
				} catch (Exception e2) {
					System.out.println("Erro Cadastro_func ->" + e2);
				}
				
			}
		});
		btnSalvar.setBounds(416, 347, 199, 23);
		contentPane.add(btnSalvar);
		
		
	}
}
