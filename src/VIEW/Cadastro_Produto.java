package VIEW;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import CONTROL.Produto;
import DAO.ContatoDaoProduto;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class Cadastro_Produto extends JFrame {

	private JPanel contentPane;
	private JTextField txtCodProduto;
	private JTextField txtDescricao;
	private JTextField txtNacionalidade;
	private JTextField txtMarca;
	private JTextField txtQtEstoque;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cadastro_Produto frame = new Cadastro_Produto();
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
	public Cadastro_Produto() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 603, 370);
		contentPane = new JPanel();
		this.setLocationRelativeTo(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);


		MaskFormatter jfFabri = null;
		MaskFormatter jfVali = null;

		try {

			jfFabri = new MaskFormatter("##/##/####");
			jfVali = new MaskFormatter("##/##/####");

		} catch (Exception e) {
			System.out.println("Erro nas mascara: " + e);
		}

		JLabel lblCadastroDeProdutos = new JLabel("Cadastro de Produtos");
		lblCadastroDeProdutos.setFont(new Font("Arial", Font.PLAIN, 16));
		lblCadastroDeProdutos.setBounds(223, 26, 163, 19);
		contentPane.add(lblCadastroDeProdutos);

		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Index cadastro = new Index();
				cadastro.setVisible(true);
				dispose();
			}
		});
		button.setIcon(new ImageIcon(Cadastro_Produto.class.getResource("/imgs/Back.png")));
		button.setBounds(545, 11, 38, 34);
		contentPane.add(button);



		JPanel panel = new JPanel();
		panel.setForeground(new Color(169, 169, 169));
		panel.setBorder(new LineBorder(null));
		panel.setBounds(13, 68, 570, 216);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblCdigoDoProduto = new JLabel("C\u00D3DGO DO PRODUTO");
		lblCdigoDoProduto.setBounds(10, 11, 129, 14);
		panel.add(lblCdigoDoProduto);
		lblCdigoDoProduto.setFont(new Font("Arial", Font.PLAIN, 12));

		JLabel lblDescrio = new JLabel("DESCRI\u00C7\u00C3O");
		lblDescrio.setBounds(182, 11, 84, 14);
		panel.add(lblDescrio);
		lblDescrio.setFont(new Font("Arial", Font.PLAIN, 12));

		txtCodProduto = new JTextField();
		txtCodProduto.setBounds(10, 36, 129, 20);
		panel.add(txtCodProduto);
		txtCodProduto.setColumns(10);

		txtDescricao = new JTextField();
		txtDescricao.setBounds(170, 36, 381, 20);
		panel.add(txtDescricao);
		txtDescricao.setColumns(10);

		JLabel lblNacionalidade = new JLabel("NACIONALIDADE");
		lblNacionalidade.setBounds(10, 80, 104, 14);
		panel.add(lblNacionalidade);
		lblNacionalidade.setFont(new Font("Arial", Font.PLAIN, 12));

		txtNacionalidade = new JTextField();
		txtNacionalidade.setBounds(10, 107, 155, 20);
		panel.add(txtNacionalidade);
		txtNacionalidade.setColumns(10);

		JLabel lblMarca = new JLabel("MARCA");
		lblMarca.setBounds(205, 80, 46, 14);
		panel.add(lblMarca);
		lblMarca.setFont(new Font("Arial", Font.PLAIN, 12));

		txtMarca = new JTextField();
		txtMarca.setBounds(205, 107, 122, 20);
		panel.add(txtMarca);
		txtMarca.setColumns(10);

		JLabel lblQtdeEstoque = new JLabel("Qtde. ESTOQUE");
		lblQtdeEstoque.setBounds(360, 80, 96, 14);
		panel.add(lblQtdeEstoque);
		lblQtdeEstoque.setFont(new Font("Arial", Font.PLAIN, 12));

		txtQtEstoque = new JTextField();
		txtQtEstoque.setBounds(360, 107, 86, 20);
		panel.add(txtQtEstoque);
		txtQtEstoque.setColumns(10);

		JLabel lblDataFabricao = new JLabel("DATA FABRICA\u00C7\u00C3O");
		lblDataFabricao.setBounds(10, 159, 118, 14);
		panel.add(lblDataFabricao);
		lblDataFabricao.setFont(new Font("Arial", Font.PLAIN, 12));

		JLabel lblDataDeValidade = new JLabel("DATA DE VALIDADE");
		lblDataDeValidade.setBounds(138, 159, 110, 14);
		panel.add(lblDataDeValidade);
		lblDataDeValidade.setFont(new Font("Arial", Font.PLAIN, 12));

		JFormattedTextField txtFabricacao = new JFormattedTextField(jfFabri);
		txtFabricacao.setBounds(10, 184, 104, 20);
		panel.add(txtFabricacao);

		JFormattedTextField txtValidade = new JFormattedTextField(jfVali);
		txtValidade.setBounds(133, 184, 115, 20);
		panel.add(txtValidade);


		JButton btnSalvar = new JButton("SALVAR");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {

					Produto produto = new Produto();

					int cod_produto = Integer.parseInt(txtCodProduto.getText());
					int qtd_estoque = Integer.parseInt(txtQtEstoque.getText());

					produto.setCd_produto(cod_produto);
					produto.setDescricao(txtDescricao.getText().toUpperCase());
					produto.setMarca(txtMarca.getText().toUpperCase());
					produto.setQtdEstoque(qtd_estoque);
					produto.setData_fabricacao(txtFabricacao.getText());
					produto.setData_validade(txtValidade.getText());


					ContatoDaoProduto daoProduto = new ContatoDaoProduto();

					daoProduto.adicionaProduto(produto);
					
					
					limparTextField();




				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		btnSalvar.setBounds(488, 295, 89, 23);
		contentPane.add(btnSalvar);

	}
	public void limparTextField() {
		
		txtCodProduto.setText("");
		txtDescricao.setText("");
		txtNacionalidade.setText("");
		txtMarca.setText("");
		txtQtEstoque.setText("");
		JFormattedTextField txtFabricacao = new JFormattedTextField();
		txtFabricacao.setText("");
		JFormattedTextField txtValidade = new JFormattedTextField();
		txtValidade.setText("");	
		
		
	}
}
