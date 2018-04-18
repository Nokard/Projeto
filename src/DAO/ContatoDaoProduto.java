package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import CONTROL.Produto;

public class ContatoDaoProduto extends ConnectionFac{

	private Connection connection;

	public ContatoDaoProduto() {
		this.connection = new ConnectionFac().getConnection();
	}


	public void adicionaProduto(Produto produto) {

		try {
			//Produto produto1 = new Produto();
			PreparedStatement verifica_estoque;
			verifica_estoque = (PreparedStatement) this.connection.prepareStatement("SELECT * FROM produtos where cd_produto = ? AND marca = ? ");
			verifica_estoque.setInt(1, produto.getCd_produto());
			verifica_estoque.setString(2, produto.getMarca());
			ResultSet rs = verifica_estoque.executeQuery();

			if (rs.next()) {
				try {
					//Produto produto = new Produto();
					String update_produto = "Update produtos set qtd_estoque = qtd_estoque + "+ produto.getQtdEstoque() +" WHERE marca = ?";						
					PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(update_produto);
					//stmt.setInt(1, produto.getQtdEstoque());
					stmt.setString(1, produto.getMarca());

					stmt.executeUpdate();
					stmt.close();
					
					JOptionPane.showMessageDialog(null, "Atualizado com sucesso");

				} catch (SQLException e) {
					// TODO: handle exception
					System.out.println("Erro no update estoque " + e);
				}


			}else {
				//criando a query para inserir no banco de dados 
				String sql_produto = "INSERT INTO produtos"+
						"(cd_produto,descricao,marca,qtd_estoque,"
						+ " data_fabricacao, data_validade)"+
						"VALUES(?,?,?,?,?,?)";


				try {
					PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql_produto);

					stmt.setInt(1, produto.getCd_produto());
					stmt.setString(2, produto.getDescricao());
					stmt.setString(3, produto.getMarca());
					stmt.setInt(4, produto.getQtdEstoque());
					stmt.setString(5, produto.getData_fabricacao());
					stmt.setString(6, produto.getData_validade());


					stmt.execute();
					stmt.close();
					JOptionPane.showMessageDialog(null, "Produto "+ produto.getDescricao() +" Cadastrado com sucesso");

				} catch (Exception e) {
					System.out.println("Error ao inserir: "+ e);
				}
			}

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}


	}

	//Metodo de pesquisa sem o pesquisar

	public List<Produto> getProduto(){



		try {
			List<Produto> produtos = new ArrayList<Produto>();

			Produto produto1 = new Produto();
			PreparedStatement stmt = (PreparedStatement) this.connection.prepareStatement("SELECT * FROM produtos where cd_produto = ? ");
			stmt.setInt(1, produto1.getCd_produto());

			ResultSet rs = stmt.executeQuery();

			while(rs.next()) {

				Produto produto = new Produto();
				produto.setCd_produto(rs.getInt("cd_produto"));
				produto.setDescricao(rs.getString("descricao"));
				produto.setMarca(rs.getString("marca"));
				produto.setQtdEstoque(rs.getInt("qtd_estoque"));
				produto.setData_fabricacao(rs.getString("data_fabricacao"));
				produto.setData_validade(rs.getString("data_validade"));

				produtos.add(produto);
			}
			rs.close();
			stmt.close();
			return produtos;


		} catch (SQLException e) {
			throw new RuntimeException(e);
		}



	}

	public List<Produto> getProdutoForDesc(String desc){


		try {
			List<Produto> produtos = new ArrayList<Produto>();

			PreparedStatement stmt = (PreparedStatement) this.connection.prepareStatement("SELECT * FROM produtos where descricao like ? ");
			stmt.setString(1, "%"+desc+"%");		

			ResultSet rs = stmt.executeQuery();

			while(rs.next()) {

				Produto produto = new Produto();
				produto.setCd_produto(rs.getInt("cd_produto"));
				produto.setDescricao(rs.getString("descricao"));
				produto.setMarca(rs.getString("marca"));
				produto.setQtdEstoque(rs.getInt("qtd_estoque"));
				produto.setData_fabricacao(rs.getString("data_fabricacao"));
				produto.setData_validade(rs.getString("data_validade"));

				produtos.add(produto);
			}
			rs.close();
			stmt.close();
			return produtos;


		} catch (SQLException e) {
			throw new RuntimeException(e);
		}



	}

}











