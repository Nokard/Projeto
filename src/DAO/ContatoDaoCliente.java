package DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import java.sql.*;
import java.sql.PreparedStatement;

import CONTROL.DadoFunc;
import CONTROL.DadoPf;
import CONTROL.DadoPj;

public class ContatoDaoCliente extends ConnectionFac{

	private Connection connection;

	public ContatoDaoCliente() {
		this.connection = new ConnectionFac().getConnection();
	}

	public void adicionaPF(DadoPf dadopf) {

		String verificaCPF = "SELECT * FROM cliente_pf where cpf = ?";
		try {
			PreparedStatement stmt0 = (PreparedStatement) connection.prepareStatement(verificaCPF);
			stmt0.setString(1, dadopf.getCpf());

			ResultSet rs = stmt0.executeQuery();
			if (rs.next()) {
				JOptionPane.showMessageDialog(null, "Usuario com esse cpf ' "+ dadopf.getCpf()+" ' jï¿½ existe");
			}else {

				String sql_cliente_pf = "INSERT INTO cliente_pf"+
						"(tipo,nome_cliente, sobrenome, cpf)"+
						"VALUES(?,?,?,?)";
				String sql_tele_pf = "INSERT INTO telefones_pf"+
						"(ddd,tel1,tel2,cel,cliente_cpf)"
						+ "VALUES (?,?,?,?,?)";
				String sql_end_pf = "INSERT INTO endereco_pf"+
						"(cep,rua,cidade,estado,numero,bairro,complemento,fk_cpf_cliente)"+
						"VALUES(?,?,?,?,?,?,?,?);";


				try {
					PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql_cliente_pf);
					PreparedStatement stmt1 = (PreparedStatement) connection.prepareStatement(sql_tele_pf);
					PreparedStatement stmt2 = (PreparedStatement) connection.prepareStatement(sql_end_pf);


					stmt.setString(1,	dadopf.getTipo());	 
					stmt.setString(2, 	dadopf.getNome());
					stmt.setString(3, 	dadopf.getSobrenome());
					stmt.setString(4, 	dadopf.getCpf());

					stmt1.setString(1, dadopf.getDdd());
					stmt1.setString(2, dadopf.getTel1());
					stmt1.setString(3, dadopf.getTel2());
					stmt1.setString(4, dadopf.getCel());
					stmt1.setString(5,  dadopf.getCpf());

					stmt2.setString(1, dadopf.getCep());
					stmt2.setString(2, dadopf.getRua());
					stmt2.setString(3, dadopf.getCidade());
					stmt2.setString(4, dadopf.getEstado());
					stmt2.setString(5, dadopf.getNo());
					stmt2.setString(6, dadopf.getBairro());
					stmt2.setString(7, dadopf.getComplemento());
					stmt2.setString(8, dadopf.getCpf());


					stmt.execute();
					stmt1.execute();
					stmt2.execute();
					stmt.close();
					stmt1.close();
					stmt2.close();

					JOptionPane.showMessageDialog(null, "Usuario "+dadopf.getNome().toUpperCase()+" cadastrado com sucesso");

				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "Erro ao cadastrar Cliente\n Entrar em contato com o suporte. ");

					System.out.println("Eroor ContatoDao PF "+ e);
				}


			}
		} catch (Exception e) {
			System.out.println("Erro no verficaCpf "+ e);
		}

	}
	//UpDATE no cliente pf
		public void UpdateClientePf(DadoPf updatePf) {

			String sql_update_pf = "update cliente_pf a " + 
					"inner join endereco_pf b " + 
					"on a.cpf = b.fk_cpf_cliente " + 
					"inner join telefones_pf c " + 
					"on a.cpf = c.cliente_cpf " + 
					"set a.nome_cliente = ?, a.sobrenome = ?," + 
					"b.CEP = ?, b.RUA = ?, b.CIDADE =?, b.estado = ?, b.NUMERO = ?, b.bairro = ?, b.complemento = ?," + 
					"c.ddd = ?, c.tel1 = ?, c.tel2 = ?, c.cel = ?"
					+ "where a.cpf = ?;";

			try {

				PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql_update_pf);


				stmt.setString(1, 	updatePf.getNome());
				stmt.setString(2, 	updatePf.getSobrenome());
				stmt.setString(3, updatePf.getCep());
				stmt.setString(4, updatePf.getRua());
				stmt.setString(5, updatePf.getCidade());
				stmt.setString(6, updatePf.getEstado());
				stmt.setString(7, updatePf.getNo());
				stmt.setString(8, updatePf.getBairro());
				stmt.setString(9, updatePf.getComplemento());
				stmt.setString(10, updatePf.getDdd());
				stmt.setString(11, updatePf.getTel1());
				stmt.setString(12, updatePf.getTel2());
				stmt.setString(13, updatePf.getCel());
				stmt.setString(14, updatePf.getCpf());


				stmt.execute();

				JOptionPane.showMessageDialog(null, "Funcionario "+updatePf.getNome().toUpperCase()+" atualizado com sucesso !");

				stmt.close();


			} catch (SQLException e) {
				System.out.println("Erro ao Atualizar cliente pf: " +e);
			}

		}
		//DELETA CLIENTE PF
		public void DeleteClientePf(DadoPf deletePf) {


			try {

				String delete_sql = "DELETE a.*, b.*, c.* from cliente_pf a " + 
						"inner join endereco_pf b " + 
						"on a.cpf = b.fk_cpf_cliente " + 
						"inner join telefones_pf c " + 
						"on a.cpf = c.cliente_cpf " + 
						"where a.cpf = ?;";

				PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(delete_sql);
				stmt.setString(1, deletePf.getCpf());

				stmt.executeUpdate();

				JOptionPane.showMessageDialog(null, "Cliente excluido com sucesso");


			} catch (SQLException e) {
				System.out.println("Erro ao excluir Cliente " +e);
			}
		}
		
		public List<DadoPf> getPfDesc(String descPf){

			try {
				List<DadoPf> clientePf = new ArrayList<DadoPf>();
				String sql = "SELECT a.cpf,a.nome_cliente, a.sobrenome, b.CEP, b.RUA, b.cidade, b.estado, b.NUMERO," + 
						"b.BAIRRO, b.complemento, c.ddd, c.tel1, c.tel2, c.cel " + 
						"from cliente_pf a " + 
						"join endereco_pf b " + 
						"on a.cpf = b.fk_cpf_cliente " + 
						"join telefones_pf c " + 
						"on a.cpf = c.cliente_cpf "
						+ "where a.nome_cliente like ?";

				PreparedStatement stmt = (PreparedStatement) this.connection.prepareStatement(sql);
				stmt.setString(1, "%"+descPf+"%");
				ResultSet rs = stmt.executeQuery();

				while(rs.next()) {

					DadoPf pf = new DadoPf();

					pf.setCpf(rs.getString("cpf"));
					pf.setNome(rs.getString("nome_cliente"));
					pf.setSobrenome(rs.getString("sobrenome"));
					pf.setCep(rs.getString("cep"));
					pf.setRua(rs.getString("rua"));
					pf.setCidade(rs.getString("cidade"));
					pf.setEstado(rs.getString("estado"));
					pf.setNo(rs.getString("numero"));
					pf.setBairro(rs.getString("bairro"));
					pf.setComplemento(rs.getString("complemento"));
					pf.setDdd(rs.getString("ddd"));
					pf.setTel1(rs.getString("tel1"));
					pf.setTel2(rs.getString("tel2"));
					pf.setCel(rs.getString("cel"));

					clientePf.add(pf);				
				}
				rs.close();
				stmt.close();
				return clientePf;		

			} catch (SQLException e) {
				throw new RuntimeException();
			}

		}

	//Adiciona Pessoa Juridica
	public void adicionaPj(DadoPj dadopj) {

		String verificaCNPJ = "SELECT * FROM cliente_pj where cnpj = ? ";

		try {
			PreparedStatement stmt0 = (PreparedStatement) connection.prepareStatement(verificaCNPJ);
			stmt0.setString(1, dadopj.getCnpj());

			ResultSet rs = stmt0.executeQuery();
			if (rs.next()) {
				JOptionPane.showMessageDialog(null, "Cliente com esse CNPJ ' "+ dadopj.getCnpj()+" ' já existe");

			}else {
				String sql_cliente_pj = "INSERT INTO cliente_pj"
						+ "(nome_cliente, sobrenome, cnpj)"
						+ "VALUES(?,?,?)";
				String sql_tele_pj = "INSERT INTO telefones_pj"+
						"(ddd,tel1,tel2,cel,cliente_cnpj)"
						+ "VALUES (?,?,?,?,?)";
				String sql_end_pj = "INSERT INTO endereco_pj"
						+"(CEP,RUA,CIDADE,ESTADO,NUMERO,BAIRRO,complemento,fk_cnpj_cliente)"
						+"VALUES(?,?,?,?,?,?,?,?)";

				try {

					PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql_cliente_pj);
					PreparedStatement stmt1 = (PreparedStatement) connection.prepareStatement(sql_tele_pj);
					PreparedStatement stmt2 = (PreparedStatement) connection.prepareStatement(sql_end_pj);

		
					stmt.setString(1, 	dadopj.getNome());
					stmt.setString(2, 	dadopj.getSobrenome());
					stmt.setString(3, 	dadopj.getCnpj());


					stmt1.setString(1, dadopj.getDdd());
					stmt1.setString(2, 	dadopj.getTel1());
					stmt1.setString(3,	 dadopj.getTel2());
					stmt1.setString(4, 	dadopj.getCel());
					stmt1.setString(5, dadopj.getCnpj());

					stmt2.setString(1, dadopj.getCep());
					stmt2.setString(2, dadopj.getRua());
					stmt2.setString(3, dadopj.getCidade());
					stmt2.setString(4, dadopj.getEstado());
					stmt2.setString(5, dadopj.getNo());
					stmt2.setString(6, dadopj.getBairro());
					stmt2.setString(7, dadopj.getComplemento());
					stmt2.setString(8, dadopj.getCnpj());

					stmt.execute();
					stmt1.execute();
					stmt2.execute();
					
					stmt.close();
					stmt1.close();
					stmt2.close();


					JOptionPane.showMessageDialog(null, "Cliente "+dadopj.getNome().toUpperCase()+" \ncadastrado com sucesso");

				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "Erro ao cadastrar Cliente\n Entrar em contato com o suporte. ");
					System.out.println("Eroor ContatoDao Pj "+ e);
				}


			}


		} catch (Exception e) {
			System.out.println("Erro verifica CNPJ "+ e);
		}

	}

	
	//update Cliente Pj
	public void UpdateClientePj(DadoPj updatePj) {

		String sql_update_pj = "update cliente_pJ a " + 
				"inner join endereco_pj b " + 
				"on a.cnpj = b.fk_cnpj_cliente " + 
				"inner join telefones_pj c " + 
				"on a.cnpj = c.cliente_cnpj " + 
				"set a.nome_cliente = ?, a.sobrenome = ?," + 
				"b.CEP = ?, b.RUA = ?, b.CIDADE =?, b.estado = ?, b.NUMERO = ?, b.bairro = ?, b.complemento = ?," + 
				"c.ddd = ?, c.tel1 = ?, c.tel2 = ?, c.cel = ?"
				+ "where a.cnpj = ?;";

		try {

			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql_update_pj);


			stmt.setString(1, 	updatePj.getNome());
			stmt.setString(2, 	updatePj.getSobrenome());
			stmt.setString(3, updatePj.getCep());
			stmt.setString(4, updatePj.getRua());
			stmt.setString(5, updatePj.getCidade());
			stmt.setString(6, updatePj.getEstado());
			stmt.setString(7, updatePj.getNo());
			stmt.setString(8, updatePj.getBairro());
			stmt.setString(9, updatePj.getComplemento());
			stmt.setString(10, updatePj.getDdd());
			stmt.setString(11, updatePj.getTel1());
			stmt.setString(12, updatePj.getTel2());
			stmt.setString(13, updatePj.getCel());
			stmt.setString(14, updatePj.getCnpj());

			stmt.execute();

			JOptionPane.showMessageDialog(null, "Funcionario "+updatePj.getNome().toUpperCase()+" atualizado com sucesso !");

			stmt.close();



		} catch (SQLException e) {
			System.out.println("Erro ao atualizar cliente pj: " +e);
		}

	}

	//DELETANDO Cliente Pj COM CASCADE
	public void DeleteClientePj(DadoPj deletePj) {


		try {

			String delete_sql = "DELETE a.*, b.*, c.* from cliente_pj a " + 
					"inner join endereco_pj b " + 
					"on a.cnpj = b.fk_cnpj_cliente " + 
					"inner join telefones_pj c " + 
					"on a.cnpj = c.cliente_cnpj " + 
					"where a.cnpj = ?;";

			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(delete_sql);
			stmt.setString(1, deletePj.getCnpj());

			stmt.executeUpdate();

			JOptionPane.showMessageDialog(null, "Cliente Juridico excluido com sucesso");


		} catch (SQLException e) {
			System.out.println("Erro ao excluir Cliente Juridico " +e);
		}
	}

	
//Listando PJ 	
	public List<DadoPj> getClientePj(String descClientePj) {
		
		try {
			List<DadoPj> clientePj = new ArrayList<DadoPj>();
			String sql = "select a.cnpj,a.nome_cliente,a.sobrenome, b.ddd, b.tel1, b.tel2, b.cel, c.cep, c.rua, c.cidade,c.estado," + 
					"c.numero, c.bairro,c.complemento from cliente_pj a " + 
					"join telefones_pj b " + 
					"on a.cnpj = b.cliente_cnpj " + 
					"join endereco_pj c " + 
					"on a.cnpj = c.fk_cnpj_cliente " + 
					"where a.cnpj like ?;";

			PreparedStatement stmt = (PreparedStatement) this.connection.prepareStatement(sql);
			stmt.setString(1, "%"+descClientePj+"%");
			ResultSet rs = stmt.executeQuery();

			while(rs.next()) {

				DadoPj pj = new DadoPj();

				pj.setCnpj(rs.getString("cnpj"));
				pj.setNome(rs.getString("nome_cliente"));
				pj.setSobrenome(rs.getString("sobrenome"));
				pj.setCep(rs.getString("cep"));
				pj.setRua(rs.getString("rua"));
				pj.setCidade(rs.getString("cidade"));
				pj.setEstado(rs.getString("estado"));
				pj.setNo(rs.getString("numero"));
				pj.setBairro(rs.getString("bairro"));
				pj.setComplemento(rs.getString("complemento"));
				pj.setDdd(rs.getString("ddd"));
				pj.setTel1(rs.getString("tel1"));
				pj.setTel2(rs.getString("tel2"));
				pj.setCel(rs.getString("cel"));

				clientePj.add(pj);				
			}
			rs.close();
			stmt.close();
			return clientePj;		

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

}









