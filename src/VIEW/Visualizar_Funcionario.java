package VIEW;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.ScrollPane;
import java.util.List;

import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import CONTROL.DadoFunc;
import DAO.ContatoDaoFuncionario;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Visualizar_Funcionario extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JTextField txtNome;
	private JTextField txtSobrenome;
	private JTextField txtCpf;
	private JTextField txtRg;
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
	private JTextField txtCep;
	private JTextField txtCidade;
	private JTextField txtUf;
	private JTextField txtBairro;
	private JLabel label_13;
	private JLabel label_14;
	private JLabel label_15;
	private JTextField txtRua;
	private JTextField txtNumero;
	private JTextField txtComplemento;



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

	DefaultTableModel modelo = new DefaultTableModel();
	private JTextField txtPesquisa;
	private JLabel label_16;

	public Visualizar_Funcionario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1029, 541);
		contentPane = new JPanel();
		this.setLocationRelativeTo(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 332, 995, 170);
		contentPane.add(scrollPane);

		JLabel lblFuncionarios = new JLabel("Funcionarios");
		lblFuncionarios.setBounds(421, 0, 135, 36);
		contentPane.add(lblFuncionarios);
		lblFuncionarios.setFont(new Font("Dialog", Font.PLAIN, 16));

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.GRAY));
		panel.setBounds(73, 57, 771, 199);
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


		txtCpf = new JTextField();
		txtCpf.setBounds(266, 36, 111, 20);
		panel.add(txtCpf);
		txtCpf.setColumns(10);

		txtRg = new JTextField();
		txtRg.setBounds(405, 36, 105, 20);
		panel.add(txtRg);
		txtRg.setColumns(10);

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
		label_8.setBounds(536, 11, 93, 15);
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
		txtCargo.setBounds(536, 36, 86, 20);
		panel.add(txtCargo);
		txtCargo.setColumns(10);

		JLabel label_9 = new JLabel("CEP");
		label_9.setFont(new Font("Arial", Font.PLAIN, 12));
		label_9.setBounds(10, 118, 46, 14);
		panel.add(label_9);

		JLabel label_10 = new JLabel("CIDADE");
		label_10.setFont(new Font("Arial", Font.PLAIN, 12));
		label_10.setBounds(114, 119, 46, 14);
		panel.add(label_10);

		JLabel label_11 = new JLabel("UF");
		label_11.setFont(new Font("Arial", Font.PLAIN, 12));
		label_11.setBounds(212, 119, 28, 14);
		panel.add(label_11);

		JLabel label_12 = new JLabel("BAIRRO");
		label_12.setFont(new Font("Arial", Font.PLAIN, 12));
		label_12.setBounds(266, 119, 46, 14);
		panel.add(label_12);

		txtCep = new JTextField();
		txtCep.setBounds(10, 138, 79, 20);
		panel.add(txtCep);
		txtCep.setColumns(10);

		txtCidade = new JTextField();
		txtCidade.setBounds(114, 138, 86, 20);
		panel.add(txtCidade);
		txtCidade.setColumns(10);

		txtUf = new JTextField();
		txtUf.setBounds(212, 138, 34, 20);
		panel.add(txtUf);
		txtUf.setColumns(10);

		txtBairro = new JTextField();
		txtBairro.setBounds(258, 138, 86, 20);
		panel.add(txtBairro);
		txtBairro.setColumns(10);

		label_13 = new JLabel("RUA");
		label_13.setFont(new Font("Arial", Font.PLAIN, 12));
		label_13.setBounds(357, 119, 46, 14);
		panel.add(label_13);

		label_14 = new JLabel("NO\u00BA");
		label_14.setFont(new Font("Arial", Font.PLAIN, 12));
		label_14.setBounds(454, 118, 46, 14);
		panel.add(label_14);

		label_15 = new JLabel("COMPLEMENTO");
		label_15.setFont(new Font("Arial", Font.PLAIN, 12));
		label_15.setBounds(536, 118, 96, 14);
		panel.add(label_15);

		txtRua = new JTextField();
		txtRua.setBounds(357, 138, 86, 20);
		panel.add(txtRua);
		txtRua.setColumns(10);

		txtNumero = new JTextField();
		txtNumero.setBounds(454, 138, 56, 20);
		panel.add(txtNumero);
		txtNumero.setColumns(10);

		txtComplemento = new JTextField();
		txtComplemento.setBounds(536, 138, 159, 20);
		panel.add(txtComplemento);
		txtComplemento.setColumns(10);

		table = new JTable(modelo);
		//Metodo para preencher os textField com as
		//setas do teclado
		table.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				setTextField();
			}
			@Override
			public void keyReleased(KeyEvent e) {
				setTextField();
			}
		});
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setTextField();	
			}
		});
		scrollPane.setViewportView(table);

		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				CarregaFuncionario(txtPesquisa.getText());


			}
		});
		btnPesquisar.setBounds(888, 295, 117, 25);
		contentPane.add(btnPesquisar);

		txtPesquisa = new JTextField();
		txtPesquisa.setBounds(746, 295, 130, 25);
		contentPane.add(txtPesquisa);
		txtPesquisa.setColumns(10);

		JLabel lblNomeDoFuncionario = new JLabel("Nome Do Funcionario");
		lblNomeDoFuncionario.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNomeDoFuncionario.setBounds(742, 268, 151, 25);
		contentPane.add(lblNomeDoFuncionario);

		JButton btnVoltar = new JButton("");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Cadastrar_Funcionario cadastro_func = new Cadastrar_Funcionario();
				cadastro_func.setVisible(true);
				dispose();

			}
		});
		btnVoltar.setIcon(new ImageIcon(Visualizar_Funcionario.class.getResource("/imgs/Back.png")));
		btnVoltar.setBounds(964, 12, 41, 36);
		contentPane.add(btnVoltar);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(table.getSelectedRow() != -1) {
					int yes = JOptionPane.showConfirmDialog(null, "Você realmente deseja DELETAR esse Funcionario ?","DELETE",JOptionPane.YES_NO_OPTION);	
					if (yes == 0) {
						
						DadoFunc func = new DadoFunc();
						ContatoDaoFuncionario funcDao = new ContatoDaoFuncionario();

						func.setCpf((String) table.getValueAt(table.getSelectedRow(),3));

						funcDao.DeleteFuncionario(func);

						//CHAMANDO METODO PARA LIMPAR TEXTFIEDLD
						limparTextField();

					}

				}else {
					JOptionPane.showMessageDialog(null, "Selecione um registro para excluir");
				}
			}
		});
		btnExcluir.setBounds(598, 295, 117, 25);
		contentPane.add(btnExcluir);

		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	

				if(table.getSelectedRow() != -1) {
					int yes = JOptionPane.showConfirmDialog(null, "Você realmente deseja ATUALIZAR esse Funcionario ?","ATUALIZAR",JOptionPane.YES_NO_OPTION);	
					if (yes == 0) {
						DadoFunc func = new DadoFunc();
						ContatoDaoFuncionario funcDao = new ContatoDaoFuncionario();
						int ddd = Integer.parseInt(txtDdd.getText());

						func.setNome(txtNome.getText().toUpperCase());
						func.setSobrenome(txtSobrenome.getText().toUpperCase());
						func.setRg(txtRg.getText());
						func.setCpf(txtCpf.getText());
						func.setCargo(txtCargo.getText().toUpperCase());
						func.setDdd(ddd);
						func.setTel1(txtTel1.getText());
						func.setTel2(txtTel2.getText());
						func.setCel(txtCel.getText());
						func.setCep(txtCep.getText());
						func.setCidade(txtCidade.getText().toUpperCase());
						func.setEstado(txtUf.getText().toUpperCase());
						func.setRua(txtRua.getText().toUpperCase());
						func.setBairro(txtBairro.getText().toUpperCase());
						func.setNo(txtNumero.getText());
						func.setComplemento(txtComplemento.getText().toUpperCase());

						funcDao.UpdateFunc(func);

						//CHAMANDO METODO PARA LIMPAR TEXTFIEDLD
						limparTextField();

					}

				}else {
					JOptionPane.showMessageDialog(null, "Selecione um registro para Atualizar");
				}

			}
		});
		btnAtualizar.setBounds(469, 295, 117, 25);
		contentPane.add(btnAtualizar);
		
		label_16 = new JLabel("");
		label_16.setIcon(new ImageIcon(Visualizar_Funcionario.class.getResource("/imgs/employess.png")));
		label_16.setBounds(29, 0, 70, 45);
		contentPane.add(label_16);

		modelo.addColumn("Nome");
		modelo.addColumn("Sobrenome");
		modelo.addColumn("RG");
		modelo.addColumn("CPF");
		modelo.addColumn("Cargo");
		modelo.addColumn("DDD");
		modelo.addColumn("Tel1");
		modelo.addColumn("Tel2");
		modelo.addColumn("Cel");
		modelo.addColumn("CEP");
		modelo.addColumn("ESTADO");
		modelo.addColumn("CIDADE");
		modelo.addColumn("BAIRRO");
		modelo.addColumn("NUMERO");
		modelo.addColumn("RUA");
		modelo.addColumn("COMPLEMENTO");

	}

	//Preenche o textField com os dados do JTABLE 
	public void setTextField() {

		int indice = table.getSelectedRow();

		txtNome.setText(table.getValueAt(indice, 0).toString());
		txtSobrenome.setText( table.getValueAt(indice, 1).toString());
		txtRg.setText( table.getValueAt(indice, 2).toString());
		txtCpf.setText( table.getValueAt(indice, 3).toString());
		txtCargo.setText( table.getValueAt(indice, 4).toString());
		txtDdd.setText(table.getValueAt(indice, 5).toString());
		txtTel1.setText(table.getValueAt(indice, 6).toString());
		txtTel2.setText( table.getValueAt(indice, 7).toString());
		txtCel.setText( table.getValueAt(indice, 8).toString());
		txtCep.setText(table.getValueAt(indice, 9).toString());
		txtUf.setText(table.getValueAt(indice, 10).toString());
		txtCidade.setText(table.getValueAt(indice, 11).toString());
		txtBairro.setText(table.getValueAt(indice, 12).toString());
		txtRua.setText(table.getValueAt(indice, 13).toString());
		txtNumero.setText(table.getValueAt(indice, 14).toString());
		txtComplemento.setText(table.getValueAt(indice, 15).toString());

	}

	public void CarregaFuncionario(String desc) {

		try {

			ContatoDaoFuncionario daoFunc = new ContatoDaoFuncionario();
			List<DadoFunc> func = daoFunc.getFuncionarioDesc(desc);
			modelo.setNumRows(0);
			for(DadoFunc funcionario : func) {
				modelo.addRow(
						new Object[] {
								funcionario.getNome(),funcionario.getSobrenome(),
								funcionario.getRg(),
								funcionario.getCpf(),
								funcionario.getCargo(),
								funcionario.getDdd(),
								funcionario.getTel1(),
								funcionario.getTel2(),
								funcionario.getCel(),
								funcionario.getCep(),
								funcionario.getEstado(),
								funcionario.getCidade(),
								funcionario.getBairro(),
								funcionario.getNo(),
								funcionario.getRua(),
								funcionario.getComplemento()				

						});
			}

		} catch (Exception e) {
			System.out.println("Erro Visualizar_Funcionario: "+ e);
		}	

	}

	//METODO PARA LIMPAR TEXTFIELD
	public void limparTextField() {

		txtNome.setText("");
		txtSobrenome.setText("");
		txtCpf.setText("");
		txtRg.setText("");
		txtCargo.setText("");
		txtDdd.setText("");
		txtTel1.setText("");
		txtTel2.setText("");
		txtCel.setText("");
		txtCep.setText("");
		txtCidade.setText("");
		txtUf.setText("");
		txtBairro.setText("");
		txtRua.setText("");
		txtNumero.setText("");
		txtComplemento.setText("");		
	}
}












