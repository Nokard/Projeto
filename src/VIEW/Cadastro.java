package VIEW;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;

public class Cadastro extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cadastro frame = new Cadastro();
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
	public Cadastro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 363, 452);
		contentPane = new JPanel();
		this.setLocationRelativeTo(null);
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCliente = new JButton("Cliente");
		btnCliente.setFont(new Font("Arial", Font.PLAIN, 12));
		btnCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CadastroCliente().setVisible(true);
				dispose();
			}
		});
		btnCliente.setIcon(new ImageIcon(Cadastro.class.getResource("/imgs/cliente.png")));
		btnCliente.setForeground(Color.WHITE);
		btnCliente.setBackground(new Color(128, 0, 0));
		btnCliente.setBounds(10, 16, 141, 67);
		contentPane.add(btnCliente);
		
		JButton btnFornecedor = new JButton("Fornecedor");
		btnFornecedor.setFont(new Font("Arial", Font.PLAIN, 12));
		btnFornecedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnFornecedor.setIcon(new ImageIcon(Cadastro.class.getResource("/imgs/fornecedor.png")));
		
		btnFornecedor.setForeground(Color.WHITE);
		btnFornecedor.setBounds(10, 250, 141, 67);
		btnFornecedor.setBackground(new Color(128, 0, 0));
		btnFornecedor.setForeground(new Color(255, 255, 255));
		contentPane.add(btnFornecedor);
		
		JButton btnPedido = new JButton("Pedido");
		btnPedido.setFont(new Font("Arial", Font.PLAIN, 12));
		btnPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				new CadastrarPedido().setVisible(true);
				dispose();
			}
		});
		btnPedido.setIcon(new ImageIcon(Cadastro.class.getResource("/imgs/pedido1.png")));
		btnPedido.setBackground(new Color(128, 0, 0));
		btnPedido.setForeground(Color.WHITE);
		btnPedido.setForeground(new Color(255, 255, 255));
		btnPedido.setBounds(10, 172, 141, 67);
		contentPane.add(btnPedido);
		
		JButton btnFuncionarios = new JButton("Estoque");
		btnFuncionarios.setFont(new Font("Arial", Font.PLAIN, 12));
		btnFuncionarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Estoque estoque = new Estoque();
				estoque.setVisible(true);
				dispose();
			
			 
			}
		});
		btnFuncionarios.setIcon(new ImageIcon(Cadastro.class.getResource("/imgs/visuEstoque.png")));
		btnFuncionarios.setForeground(Color.WHITE);
		btnFuncionarios.setBackground(new Color(128, 0, 0));
		btnFuncionarios.setForeground(new Color(255, 255, 255));
		btnFuncionarios.setBounds(172, 328, 154, 67);
		contentPane.add(btnFuncionarios);
		
		JButton btnEstoque = new JButton("Produtos");
		btnEstoque.setFont(new Font("Arial", Font.PLAIN, 12));
		btnEstoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cadastro_Produto cadProduto = new Cadastro_Produto();
				cadProduto.setVisible(true);
				dispose();
			}
		});
		btnEstoque.setIcon(new ImageIcon(Cadastro.class.getResource("/imgs/estoque.png")));
		btnEstoque.setBackground(new Color(128, 0, 0));
		btnEstoque.setForeground(new Color(255, 255, 255));
		btnEstoque.setBounds(10, 328, 141, 67);
		contentPane.add(btnEstoque);
		
		JLabel lblCadastro = new JLabel("Los Adega");
		lblCadastro.setForeground(new Color(128, 0, 0));
		lblCadastro.setFont(new Font("Arial", Font.ITALIC, 20));
		lblCadastro.setBounds(207, 34, 104, 27);
		contentPane.add(lblCadastro);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Cadastro.class.getResource("/imgs/wine.png")));
		label.setBounds(191, 72, 135, 152);
		contentPane.add(label);
		
		JButton btnFuncionrios = new JButton("Funcion\u00E1rios");
		btnFuncionrios.setFont(new Font("Arial", Font.PLAIN, 12));
		btnFuncionrios.setForeground(new Color(255, 255, 255));
		btnFuncionrios.setBackground(new Color(128, 0, 0));
		btnFuncionrios.setIcon(new ImageIcon(Cadastro.class.getResource("/imgs/func.png")));
		btnFuncionrios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				new Cadastro_Funcionario().setVisible(true);
				dispose();
			
			}
		});
		btnFuncionrios.setBounds(10, 94, 141, 67);
		contentPane.add(btnFuncionrios);
	}
}
