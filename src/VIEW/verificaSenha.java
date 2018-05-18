package VIEW;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import CONTROL.senhaGerente;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class verificaSenha extends JFrame {

	private JPanel contentPane;
	private JTextField txtSenha;
	private JTextField txtUser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					verificaSenha frame = new verificaSenha();
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
	public verificaSenha() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(50, 50, 430, 272);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblIdentificacao = new JLabel("SENHA");
		lblIdentificacao.setFont(new Font("Arial", Font.PLAIN, 13));
		lblIdentificacao.setBounds(218, 136, 68, 14);
		contentPane.add(lblIdentificacao);

		txtSenha = new JTextField();
		txtSenha.setBounds(295, 132, 113, 23);
		contentPane.add(txtSenha);
		txtSenha.setColumns(10);

		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (txtUser.getText().equals("gerente") && txtSenha.getText().equals("12345")) {
					
				}else {
					JOptionPane.showMessageDialog(null, "Senha ou usuario incorretos");
				}
				
				
//				try {
//
//					senhaGerente senhaGerente = new senhaGerente();
//
//					int senha = Integer.parseInt(txtSenha.getText());
//					senhaGerente.setSenha(senha);
//
//					DAO.DaoVerificaSenha verifica = new DAO.DaoVerificaSenha();
//					verifica.verificaSenha(senhaGerente);
//					dispose();
//				} catch (Exception e2) {
//					System.out.println("Erro VerificaSenha "+ e2);
//				}			
			}
		});
		btnEnviar.setBounds(319, 186, 89, 23);
		contentPane.add(btnEnviar);

		JButton btnNewButton = new JButton("SAIR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton.setBounds(218, 186, 89, 23);
		contentPane.add(btnNewButton);

		JLabel lblUsuario = new JLabel("USUARIO");
		lblUsuario.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblUsuario.setBounds(216, 101, 70, 15);
		contentPane.add(lblUsuario);

		txtUser = new JTextField();
		txtUser.setBounds(295, 97, 114, 23);
		contentPane.add(txtUser);
		txtUser.setColumns(10);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(verificaSenha.class.getResource("/imgs/wine.png")));
		label.setBounds(50, 65, 113, 144);
		contentPane.add(label);

		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setFont(new Font("Dialog", Font.BOLD, 16));
		lblLogin.setBounds(176, 12, 70, 35);
		contentPane.add(lblLogin);
	}
}
