package VIEW;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

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
	private JTextField textField_8;
	private JTextField txtUf;
	private JTextField txtRua;
	private JTextField txtNo;
	private JTextField txtBairro;
	private JTextField txtComplemento;
	private JTextField textField;

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
	public Visualizar_Fornecedor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1029, 541);
		contentPane = new JPanel();
		this.setLocationRelativeTo(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.GRAY));
		panel.setBounds(28, 12, 894, 240);
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
		
		JLabel txtCidade = new JLabel("Cidade");
		txtCidade.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtCidade.setBounds(112, 128, 70, 15);
		panel.add(txtCidade);
		
		JLabel label_9 = new JLabel("Uf");
		label_9.setFont(new Font("Dialog", Font.PLAIN, 12));
		label_9.setBounds(318, 128, 70, 15);
		panel.add(label_9);
		
		txtCep = new JTextField();
		txtCep.setColumns(10);
		txtCep.setBounds(12, 153, 81, 19);
		panel.add(txtCep);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(105, 153, 206, 19);
		panel.add(textField_8);
		
		txtUf = new JTextField();
		txtUf.setColumns(10);
		txtUf.setBounds(323, 153, 114, 19);
		panel.add(txtUf);
		
		JLabel label_10 = new JLabel("Rua");
		label_10.setFont(new Font("Dialog", Font.PLAIN, 12));
		label_10.setBounds(12, 177, 70, 15);
		panel.add(label_10);
		
		txtRua = new JTextField();
		txtRua.setColumns(10);
		txtRua.setBounds(12, 194, 114, 19);
		panel.add(txtRua);
		
		txtNo = new JTextField();
		txtNo.setColumns(10);
		txtNo.setBounds(138, 194, 54, 19);
		panel.add(txtNo);
		
		JLabel label_11 = new JLabel("Noº");
		label_11.setFont(new Font("Dialog", Font.PLAIN, 12));
		label_11.setBounds(137, 177, 70, 15);
		panel.add(label_11);
		
		JLabel label_12 = new JLabel("Bairro");
		label_12.setFont(new Font("Dialog", Font.PLAIN, 12));
		label_12.setBounds(204, 177, 70, 15);
		panel.add(label_12);
		
		txtBairro = new JTextField();
		txtBairro.setColumns(10);
		txtBairro.setBounds(204, 194, 114, 19);
		panel.add(txtBairro);
		
		txtComplemento = new JTextField();
		txtComplemento.setColumns(10);
		txtComplemento.setBounds(333, 194, 206, 19);
		panel.add(txtComplemento);
		
		JLabel label_13 = new JLabel("Complemento");
		label_13.setFont(new Font("Dialog", Font.PLAIN, 12));
		label_13.setBounds(333, 177, 97, 15);
		panel.add(label_13);
		
		textField = new JTextField();
		textField.setBounds(659, 276, 121, 25);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPesquisar.setBounds(805, 276, 117, 25);
		contentPane.add(btnPesquisar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnExcluir.setBounds(497, 279, 117, 25);
		contentPane.add(btnExcluir);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAtualizar.setBounds(343, 279, 117, 25);
		contentPane.add(btnAtualizar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 316, 894, 183);
		contentPane.add(scrollPane);
	}
}
