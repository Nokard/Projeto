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
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;

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
	public Visualizar_Clientes_Pf() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 929, 541);
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
		panel.setBounds(54, 26, 771, 187);
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
		scrollPane.setBounds(12, 264, 905, 235);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}
}
