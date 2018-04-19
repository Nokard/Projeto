package VIEW;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.ScrollPane;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class Visualizar_Funcionario extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JTextField txtNome;
	private JTextField txtSobrenome;
	private JTextField txtRg;
	private JTextField textField;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;
	private JLabel label_7;
	private JLabel label_8;
	private JTextField txtDdd;
	private JTextField txtTel1;
	private JTextField txtTel2;
	private JTextField txtCel;
	private JTextField txtCargo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Visualizar_Funcionario frame = new Visualizar_Funcionario();
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
	public Visualizar_Funcionario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 596, 693);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 406, 560, 237);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblFuncionarios = new JLabel("Funcionarios");
		lblFuncionarios.setBounds(208, 11, 112, 36);
		contentPane.add(lblFuncionarios);
		lblFuncionarios.setFont(new Font("Arial", Font.BOLD, 16));
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.GRAY));
		panel.setBounds(10, 70, 560, 303);
		contentPane.add(panel);
		panel.setLayout(null);
		
		label = new JLabel("CPF");
		label.setFont(new Font("Arial", Font.PLAIN, 12));
		label.setBounds(266, 11, 46, 14);
		panel.add(label);
		
		label_1 = new JLabel("RG");
		label_1.setFont(new Font("Arial", Font.PLAIN, 12));
		label_1.setBounds(405, 11, 70, 14);
		panel.add(label_1);
		
		label_2 = new JLabel("SOBRENOME");
		label_2.setFont(new Font("Arial", Font.PLAIN, 12));
		label_2.setBounds(126, 11, 91, 14);
		panel.add(label_2);
		
		label_3 = new JLabel("NOME");
		label_3.setFont(new Font("Arial", Font.PLAIN, 12));
		label_3.setBounds(10, 11, 46, 14);
		panel.add(label_3);
		
		txtNome = new JTextField();
		txtNome.setBounds(10, 36, 106, 20);
		panel.add(txtNome);
		txtNome.setColumns(10);
		
		txtSobrenome = new JTextField();
		txtSobrenome.setBounds(126, 36, 111, 20);
		panel.add(txtSobrenome);
		txtSobrenome.setColumns(10);
		
		txtRg = new JTextField();
		txtRg.setBounds(266, 36, 111, 20);
		panel.add(txtRg);
		txtRg.setColumns(10);
		
		textField = new JTextField();
		textField.setBounds(405, 36, 105, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		label_4 = new JLabel("TELEFONE1");
		label_4.setFont(new Font("Arial", Font.PLAIN, 12));
		label_4.setBounds(49, 67, 70, 15);
		panel.add(label_4);
		
		label_5 = new JLabel("TELEFONE2");
		label_5.setFont(new Font("Arial", Font.PLAIN, 12));
		label_5.setBounds(167, 67, 93, 15);
		panel.add(label_5);
		
		label_6 = new JLabel("CELULAR");
		label_6.setFont(new Font("Arial", Font.PLAIN, 12));
		label_6.setBounds(288, 67, 56, 15);
		panel.add(label_6);
		
		label_7 = new JLabel("DDD");
		label_7.setFont(new Font("Arial", Font.PLAIN, 12));
		label_7.setBounds(10, 67, 34, 15);
		panel.add(label_7);
		
		label_8 = new JLabel("CARGO");
		label_8.setFont(new Font("Dialog", Font.PLAIN, 12));
		label_8.setBounds(405, 67, 93, 15);
		panel.add(label_8);
		
		txtDdd = new JTextField();
		txtDdd.setBounds(10, 87, 29, 20);
		panel.add(txtDdd);
		txtDdd.setColumns(10);
		
		txtTel1 = new JTextField();
		txtTel1.setBounds(49, 87, 106, 20);
		panel.add(txtTel1);
		txtTel1.setColumns(10);
		
		txtTel2 = new JTextField();
		txtTel2.setBounds(165, 87, 106, 20);
		panel.add(txtTel2);
		txtTel2.setColumns(10);
		
		txtCel = new JTextField();
		txtCel.setBounds(291, 87, 86, 20);
		panel.add(txtCel);
		txtCel.setColumns(10);
		
		txtCargo = new JTextField();
		txtCargo.setBounds(405, 87, 86, 20);
		panel.add(txtCargo);
		txtCargo.setColumns(10);
		
		JLabel label_9 = new JLabel("CEP");
		label_9.setFont(new Font("Arial", Font.PLAIN, 12));
		label_9.setBounds(10, 118, 46, 14);
		panel.add(label_9);
		
		JLabel label_10 = new JLabel("CIDADE");
		label_10.setFont(new Font("Arial", Font.PLAIN, 12));
		label_10.setBounds(70, 118, 46, 14);
		panel.add(label_10);
		
		JLabel label_11 = new JLabel("UF");
		label_11.setFont(new Font("Arial", Font.PLAIN, 12));
		label_11.setBounds(147, 118, 28, 14);
		panel.add(label_11);
		
		JLabel label_12 = new JLabel("BAIRRO");
		label_12.setFont(new Font("Arial", Font.PLAIN, 12));
		label_12.setBounds(187, 118, 46, 14);
		panel.add(label_12);
	}
}
