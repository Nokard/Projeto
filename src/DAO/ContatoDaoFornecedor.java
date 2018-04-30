package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import CONTROL.DadoFornec;

public class ContatoDaoFornecedor extends ConnectionFac {

	private Connection connection;

	public ContatoDaoFornecedor(){
		this.connection = new ConnectionFac().getConnection();
	}

	public void adicionaFornecedor(DadoFornec dadoFornec) {

		try {
			PreparedStatement verificaForne;
			verificaForne = (PreparedStatement) this.connection.prepareStatement("SELECT * FROM fornecedor where cnpj = ?");
			verificaForne.setString(1, dadoFornec.getCnpj());

			ResultSet rs = verificaForne.executeQuery();

			if (rs.next()) {
				JOptionPane.showMessageDialog(null, "Fornecedor já cadastrado !");
			}else {

				String sql_adiciona_fornecedor = "INSERT INTO fornecedor"
						+ "(cnpj,nomeFantasia,razaoSocial) values (?,?,?)";
				String sql_adiciona_end_fornecedor = "INSERT INTO endereco_fornecedor "
						+ "(cep,rua,cidade,estado,numero,bairro,complemento,fk_cnpj_fornecedor)"
						+ "values(?,?,?,?,?,?,?,?)";
				String sql_adiciona_tel_fornecedor = "INSERT INTO telefone_fornecedor"
						+ "(ddd,tel1,tel2,cel,fk_cnpj_fornecedor)"
						+ "values(?,?,?,?,?)";

				try {
					//PreparedStatement para inserir no banco 
					PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql_adiciona_fornecedor);
					PreparedStatement stmt1 = (PreparedStatement) connection.prepareStatement(sql_adiciona_end_fornecedor);
					PreparedStatement stmt2 = (PreparedStatement) connection.prepareStatement(sql_adiciona_tel_fornecedor);
					
					stmt.setString(1, dadoFornec.getCnpj());
					stmt.setString(2, dadoFornec.getNomeFantasia());
					stmt.setString(3, dadoFornec.getRazaoSocial());
					
					stmt1.setString(1, dadoFornec.getCep());
					stmt1.setString(2, dadoFornec.getRua());
					stmt1.setString(3, dadoFornec.getCidade());
					stmt1.setString(4, dadoFornec.getEstado());
					stmt1.setString(5, dadoFornec.getNo());
					stmt1.setString(6, dadoFornec.getBairro());
					stmt1.setString(7, dadoFornec.getComplemento());
					stmt1.setString(8, dadoFornec.getCnpj());
					
					stmt2.setInt(1, dadoFornec.getDdd());
					stmt2.setString(2, dadoFornec.getTel1());
					stmt2.setString(3, dadoFornec.getTel2());
					stmt2.setString(4, dadoFornec.getCnpj());
					
					stmt.execute();
					stmt1.execute();
					stmt2.execute();
					
					stmt.close();
					stmt1.close();
					stmt2.close();
					
					
					
				} catch (SQLException e) {
					System.out.println("Erro ao Cadastrar Fornecedor: " +e);
				}

			}

		} catch (SQLException e) {
			System.out.println("Erro ao verificar Fornecedor: " +e);
		}
	}

}
