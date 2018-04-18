package VIEW;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import CONTROL.senhaGerente;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class verificaSenha extends JFrame {

	private JPanel contentPane;
	private JTextField txtSenha;

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
		setBounds(50, 50, 244, 177);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIdentificacao = new JLabel("Digite a Senha");
		lblIdentificacao.setFont(new Font("Arial", Font.PLAIN, 13));
		lblIdentificacao.setBounds(56, 21, 103, 14);
		contentPane.add(lblIdentificacao);
		
		txtSenha = new JTextField();
		txtSenha.setBounds(56, 46, 113, 23);
		contentPane.add(txtSenha);
		txtSenha.setColumns(10);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {

					senhaGerente senhaGerente = new senhaGerente();
					int senha = Integer.parseInt(txtSenha.getText());
					senhaGerente.setSenha(senha);
					
					DAO.DaoVerificaSenha verifica = new DAO.DaoVerificaSenha();
					verifica.verificaSenha(senhaGerente);
					dispose();
				} catch (Exception e2) {
					System.out.println("Erro VerificaSenha "+ e2);
				}			}
		});
		btnEnviar.setBounds(129, 104, 89, 23);
		contentPane.add(btnEnviar);
		
		JButton btnNewButton = new JButton("Voltar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Cadastro().setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(30, 104, 89, 23);
		contentPane.add(btnNewButton);
	}
}
