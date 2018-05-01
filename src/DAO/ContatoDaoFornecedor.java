package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import CONTROL.DadoFornec;
import CONTROL.DadoFunc;

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
					stmt2.setString(4, dadoFornec.getCel());
					stmt2.setString(5, dadoFornec.getCnpj());

					stmt.execute();
					stmt1.execute();
					stmt2.execute();

					JOptionPane.showMessageDialog(null, "Fornecedor "+dadoFornec.getRazaoSocial()+" Cadastrado com sucesso ");
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

	public List<DadoFornec> getFornecedoresDesc(String descFornec) {

		try {

			List<DadoFornec> fornecedores = new ArrayList<DadoFornec>();

			PreparedStatement stmt = (PreparedStatement) this.connection.prepareStatement(
					"select a.cnpj, a.nomeFantasia, a.razaoSocial, b.ddd, b.tel1, b.tel2, b.cel,\n" + 
							"c.cep, c.rua, c.cidade, c.estado, c.numero, c.bairro, c.complemento\n" + 
							" from fornecedor a \n" + 
							"join telefone_fornecedor b\n" + 
							"on a.cnpj = b.fk_cnpj_fornecedor \n" + 
							"join endereco_fornecedor c \n" + 
							"on a.cnpj = c.fk_cnpj_fornecedor "
							+ "where a.nomeFantasia like ? ");

			stmt.setString(1, "%"+descFornec+"%");

			ResultSet rs = stmt.executeQuery();

			while(rs.next()) {

				DadoFornec fornec = new DadoFornec();

				fornec.setCnpj(rs.getString("cnpj"));
				fornec.setNomeFantasia(rs.getString("nomeFantasia"));
				fornec.setRazaoSocial(rs.getString("razaoSocial"));
				fornec.setDdd(rs.getInt("ddd"));
				fornec.setTel1(rs.getString("tel1"));
				fornec.setTel2(rs.getString("tel2"));
				fornec.setCel(rs.getString("cel"));
				fornec.setCep(rs.getString("cep"));
				fornec.setRua(rs.getString("rua"));
				fornec.setCidade(rs.getString("cidade"));
				fornec.setEstado(rs.getString("estado"));
				fornec.setNo(rs.getString("numero"));
				fornec.setBairro(rs.getString("bairro"));
				fornec.setComplemento(rs.getString("complemento"));

				fornecedores.add(fornec);				
			}
			rs.close();
			stmt.close();
			return fornecedores;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}


	//DELETANDO FUNCIONARIO COM CASCADE
	public void DeleteFornecedor(DadoFornec dadoFornec) {

		String delete_sql = "delete from adega.fornecedor where cnpj = ?";

		try {
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(delete_sql);
			stmt.setString(1, dadoFornec.getCnpj());

			stmt.executeUpdate();

			JOptionPane.showMessageDialog(null, "Fornecedor excluido com sucesso");


		} catch (SQLException e) {
			System.out.println("Erro ao excluir Fornecedor" +e);
		}
	}

//ATUALIZANDO FORNECEDOR
	public void UpdateFornec(DadoFornec updateFornec) {


		try {
			String updateFornecedor = "update adega.fornecedor a " + 
					"inner join adega.telefone_fornecedor b " + 
					"on a.cnpj = b.fk_cnpj_fornecedor " + 
					"inner join adega.endereco_fornecedor c " + 
					"on a.cnpj = c.fk_cnpj_fornecedor " + 
					"set a.nomeFantasia = ?, a.razaoSocial = ?, " + 
					"b.ddd = ?, b.tel1 = ?, b.tel2 = ?, b.cel = ?, " + 
					"c.cep = ?, c.rua = ?, c.cidade = ?, c.estado = ?, c.numero = ?, c.bairro = ?, c.complemento = ? " + 
					"where a.cnpj = ?;";


			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(updateFornecedor);

			stmt.setString(1, updateFornec.getNomeFantasia());
			stmt.setString(2, updateFornec.getRazaoSocial());
			stmt.setInt(3, updateFornec.getDdd());
			stmt.setString(4, updateFornec.getTel1());
			stmt.setString(5, updateFornec.getTel2());
			stmt.setString(6, updateFornec.getCel());
			stmt.setString(7, updateFornec.getCep());
			stmt.setString(8, updateFornec.getRua());
			stmt.setString(9, updateFornec.getCidade());
			stmt.setString(10, updateFornec.getEstado());
			stmt.setString(11, updateFornec.getNo());
			stmt.setString(12, updateFornec.getBairro());
			stmt.setString(13, updateFornec.getComplemento());
			stmt.setString(14, updateFornec.getCnpj());

			stmt.executeUpdate();

			JOptionPane.showMessageDialog(null, "Fornecedor atualizado com sucesso ! ");


			stmt.close();



		} catch (SQLException e) {
			System.out.println("Erro ao atualizar: " +e);
		}


	}





}


















