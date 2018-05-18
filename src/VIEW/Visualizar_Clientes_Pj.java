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

public class Visualizar_Clientes_Pj extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;

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
	public Visualizar_Clientes_Pj() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 541);
		contentPane = new JPanel();
		this.setLocationRelativeTo(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new LineBorder(Color.GRAY));
		panel.setBounds(87, 57, 677, 173);
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
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(10, 36, 106, 20);
		panel.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(126, 36, 111, 20);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(266, 36, 111, 20);
		panel.add(textField_2);
		
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
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(10, 87, 29, 20);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(49, 87, 106, 20);
		panel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(165, 87, 106, 20);
		panel.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(291, 87, 86, 20);
		panel.add(textField_6);
		
		JLabel label_7 = new JLabel("CEP");
		label_7.setFont(new Font("Dialog", Font.PLAIN, 12));
		label_7.setBounds(10, 118, 46, 14);
		panel.add(label_7);
		
		JLabel label_8 = new JLabel("CIDADE");
		label_8.setFont(new Font("Dialog", Font.PLAIN, 12));
		label_8.setBounds(59, 118, 46, 14);
		panel.add(label_8);
		
		JLabel label_9 = new JLabel("UF");
		label_9.setFont(new Font("Dialog", Font.PLAIN, 12));
		label_9.setBounds(151, 119, 28, 14);
		panel.add(label_9);
		
		JLabel label_10 = new JLabel("BAIRRO");
		label_10.setFont(new Font("Dialog", Font.PLAIN, 12));
		label_10.setBounds(201, 118, 46, 14);
		panel.add(label_10);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(10, 138, 29, 20);
		panel.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(57, 138, 86, 20);
		panel.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(151, 138, 34, 20);
		panel.add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(195, 138, 86, 20);
		panel.add(textField_10);
		
		JLabel label_11 = new JLabel("RUA");
		label_11.setFont(new Font("Dialog", Font.PLAIN, 12));
		label_11.setBounds(288, 119, 46, 14);
		panel.add(label_11);
		
		JLabel label_12 = new JLabel("NO\u00C2\u00BA");
		label_12.setFont(new Font("Dialog", Font.PLAIN, 12));
		label_12.setBounds(391, 118, 46, 14);
		panel.add(label_12);
		
		JLabel label_13 = new JLabel("COMPLEMENTO");
		label_13.setFont(new Font("Dialog", Font.PLAIN, 12));
		label_13.setBounds(470, 118, 96, 14);
		panel.add(label_13);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(293, 138, 86, 20);
		panel.add(textField_11);
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(391, 138, 56, 20);
		panel.add(textField_12);
		
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setBounds(470, 138, 159, 20);
		panel.add(textField_13);
	}
}
