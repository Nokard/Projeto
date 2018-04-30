package VIEW;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import CONTROL.Produto;
import DAO.ContatoDaoProduto;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class Estoque extends JFrame {

	private JPanel contentPane;
	private JTextField txtDescricao;
	private JTable table;
	DefaultTableModel modelo = new DefaultTableModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Estoque frame = new Estoque();
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
	public Estoque() {
		setBackground(Color.LIGHT_GRAY);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 743, 435);
		contentPane = new JPanel();
		this.setLocationRelativeTo(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblPesquisandoNoEstoque = new JLabel("Estoque");
		lblPesquisandoNoEstoque.setFont(new Font("Arial", Font.PLAIN, 19));
		lblPesquisandoNoEstoque.setBounds(271, 25, 96, 23);
		contentPane.add(lblPesquisandoNoEstoque);

		JLabel lblDescricao = new JLabel("DESCRI\u00C7\u00C3O");
		lblDescricao.setFont(new Font("Arial", Font.PLAIN, 12));
		lblDescricao.setBounds(244, 96, 75, 14);
		contentPane.add(lblDescricao);

		txtDescricao = new JTextField();
		txtDescricao.setBounds(244, 121, 181, 20);
		contentPane.add(txtDescricao);
		txtDescricao.setColumns(10);

		JButton btnPequisar = new JButton("Pequisar");
		btnPequisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				//Chama o metodo CarregarEstoque
				CarregarEstoqueforDesc(txtDescricao.getText());
			

			}
		});
		btnPequisar.setBounds(580, 120, 111, 23);
		contentPane.add(btnPequisar);

		JButton btnNewButton = new JButton("");
		btnNewButton.setForeground(SystemColor.text);
		btnNewButton.setBackground(SystemColor.menu);
		btnNewButton.setIcon(new ImageIcon(Estoque.class.getResource("/imgs/visuEstoque.png")));
		btnNewButton.setBounds(10, 11, 89, 74);
		contentPane.add(btnNewButton);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 165, 707, 220);
		contentPane.add(scrollPane);

		table = new JTable(modelo);
		scrollPane.setViewportView(table);

		JButton btnVoltar = new JButton("");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Index cadastro = new Index();
				cadastro.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setIcon(new ImageIcon(Estoque.class.getResource("/imgs/Back.png")));
		btnVoltar.setBounds(633, 11, 36, 36);
		contentPane.add(btnVoltar);

		modelo.addColumn("Código Produto");
		modelo.addColumn("Descrição");
		modelo.addColumn("Marca");
		modelo.addColumn("Estoque");
		modelo.addColumn("Data Fabricacão");
		modelo.addColumn("Data Validade");

	}

// Metodo sem o comando Pesquisa 
//	public void CarregarEstoque() {		
//
//		ContatoDaoProduto produtoDao = new ContatoDaoProduto();		
//		List<Produto> produtos = produtoDao.getProduto();
//		modelo.setNumRows(0);
//		for(Produto produto : produtos ) {
//			modelo.addRow(new Object[] {produto.getCd_produto(),produto.getDescricao(),produto.getTipo(),produto.getMarca(),produto.getQtdEstoque(),produto.getData_fabricacao(),produto.getData_validade()});
//		}
//	}
	
	public void CarregarEstoqueforDesc(String desc) {		

		ContatoDaoProduto produtoDao = new ContatoDaoProduto();		
		List<Produto> produtos = produtoDao.getProdutoForDesc(desc);
		modelo.setNumRows(0);
		for(Produto produto : produtos  ) {
			modelo.addRow(new Object[] {produto.getCd_produto(),produto.getDescricao(),produto.getMarca(),produto.getQtdEstoque(),produto.getData_fabricacao(),produto.getData_validade()});
		}
	}
}
