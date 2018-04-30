package VIEW;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class Cadastrar_Pedido extends JFrame {

	private JPanel contentPane;
	private JTextField txtCodigo_produto;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;
	private JTextField txtValor_Pedido;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cadastrar_Pedido frame = new Cadastrar_Pedido();
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
	public Cadastrar_Pedido() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 610, 435);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		this.setLocationRelativeTo(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 218, 577, 165);
		
		table = new JTable();
		scrollPane.setColumnHeaderView(table);
		contentPane.setLayout(null);
		contentPane.add(scrollPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.WHITE, 1, true));
		panel.setBounds(6, 11, 578, 197);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(2, 7, 65, 63);
		panel.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(Cadastrar_Pedido.class.getResource("/imgs/pedido.png")));
		
		JLabel lblCadastrarPedido = new JLabel("Cadastrar Pedido");
		lblCadastrarPedido.setBounds(203, 7, 162, 30);
		panel.add(lblCadastrarPedido);
		lblCadastrarPedido.setFont(new Font("Arial", Font.PLAIN, 16));
		
		JButton button = new JButton("");
		button.setBounds(534, 7, 36, 36);
		panel.add(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Index().setVisible(true);
				dispose();
				
			}
		});
		button.setIcon(new ImageIcon(Cadastrar_Pedido.class.getResource("/imgs/Back.png")));
		
		JLabel lblQtdeEstoqu = new JLabel("Qtde. Estoque");
		lblQtdeEstoqu.setBounds(474, 86, 86, 14);
		panel.add(lblQtdeEstoqu);
		lblQtdeEstoqu.setFont(new Font("Arial", Font.PLAIN, 12));
		
		textField_1 = new JTextField();
		textField_1.setBounds(474, 106, 86, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField = new JTextField();
		textField.setBounds(118, 106, 335, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		txtCodigo_produto = new JTextField();
		txtCodigo_produto.setBounds(2, 106, 110, 20);
		panel.add(txtCodigo_produto);
		txtCodigo_produto.setColumns(10);
		
		txtValor_Pedido = new JTextField();
		txtValor_Pedido.setBounds(2, 158, 86, 20);
		panel.add(txtValor_Pedido);
		txtValor_Pedido.setColumns(10);
		
		JLabel lblValorPedido = new JLabel("Valor Pedido");
		lblValorPedido.setBounds(2, 138, 70, 15);
		panel.add(lblValorPedido);
		lblValorPedido.setFont(new Font("Arial", Font.PLAIN, 12));
		
		JButton btnAtualiza = new JButton("Atualiza ");
		btnAtualiza.setBounds(335, 158, 88, 23);
		panel.add(btnAtualiza);
		
		JButton btnAdicionaProduto = new JButton("Adiciona Produto");
		btnAdicionaProduto.setBounds(425, 158, 135, 23);
		panel.add(btnAdicionaProduto);
		
		JLabel lblCdigoDoProduto = new JLabel("C\u00F3digo do Produto");
		lblCdigoDoProduto.setBounds(5, 84, 110, 14);
		panel.add(lblCdigoDoProduto);
		lblCdigoDoProduto.setFont(new Font("Arial", Font.PLAIN, 12));
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o");
		lblDescrio.setBounds(143, 84, 75, 14);
		panel.add(lblDescrio);
		lblDescrio.setFont(new Font("Arial", Font.PLAIN, 12));
	}
}
