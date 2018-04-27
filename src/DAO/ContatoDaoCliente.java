package DAO;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import java.sql.*;
import java.sql.PreparedStatement;

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
				JOptionPane.showMessageDialog(null, "Usuario com esse cpf ' "+ dadopf.getCpf()+" ' j� existe");
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

					JOptionPane.showMessageDialog(null, "Usuario "+dadopf.getCpf().toUpperCase()+" cadastrado com sucesso");

				} catch (SQLException e) {
					System.out.println("Eroor ContatoDao PF "+ e);
				}


			}
		} catch (Exception e) {
			System.out.println("Erro no verficaCpf "+ e);
		}

	}
	public void adicionaPj(DadoPj dadopj) {
		
		String verificaCNPJ = "SELECT * FROM cliente_pj where cnpj = ? ";
		
		try {
			PreparedStatement stmt0 = (PreparedStatement) connection.prepareStatement(verificaCNPJ);
			stmt0.setString(1, dadopj.getCnpj());
			
			ResultSet rs = stmt0.executeQuery();
			if (rs.next()) {
				JOptionPane.showMessageDialog(null, "Usuario com esse CNPJ ' "+ dadopj.getCnpj()+" ' já existe");

			}else {
				String sql_cliente_pj = "INSERT INTO cliente_pj"
						+ "(tipo,nome_cliente, sobrenome, cnpj)"
						+ "VALUES(?,?,?,?)";
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

					stmt.setString(1,	dadopj.getTipo());	
					stmt.setString(2, 	dadopj.getNome());
					stmt.setString(3, 	dadopj.getSobrenome());
					stmt.setString(4, 	dadopj.getCnpj());


					stmt1.setString(1, dadopj.getDdd());
					stmt1.setString(2, 	dadopj.getTel1());
					stmt1.setString(3,	 dadopj.getTel2());
					stmt1.setString(4, 	dadopj.getCel());
					stmt1.setString(5, dadopj.getCnpj());

					stmt2.setString(1, dadopj.getCep());
					stmt2.setString(2, dadopj.getCidade());
					stmt2.setString(3, dadopj.getEstado());
					stmt2.setString(4, dadopj.getRua());
					stmt2.setString(5, dadopj.getBairro());
					stmt2.setString(6, dadopj.getNo());
					stmt2.setString(7, dadopj.getBairro());
					stmt2.setString(8, dadopj.getComplemento());
					stmt2.setString(9, dadopj.getCnpj());
					
					stmt.execute();
					stmt1.execute();
					stmt2.execute();
					stmt.close();
					stmt1.close();
					stmt2.close();


					JOptionPane.showMessageDialog(null, "Usuario "+dadopj.getCnpj().toUpperCase()+" cadastrado com sucesso");

				} catch (SQLException e) {
					System.out.println("Eroor ContatoDao Pj "+ e);
				}


			}
			
			
		} catch (Exception e) {
			System.out.println("Erro verifica CNPJ "+ e);
		}
		
	}
	
	//UpDATE no cliente pf
	public void UpdateClientePf(DadoPf updatePf) {
		
		String sql_update_pf = "UPDATE cliente_pf set nome_cliente = ?, sobrenome = ? where cpf = ?";
		
		String sql_update_tel = "UPDATE telefones_pf set ddd = ?, tel1 = ?, tel2 = ?, cel = ?"
				+ "where cliente_cpf = ?";
		
		String sql_update_end = "UPDATE endereco_pf set cep = ?, rua = ?, cidade = ?, estado = ?,"
				+ "numero = ?, bairro = ?, complemento = ? where fk_cpf_cliente = ?";
		
		try {

			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql_update_pf);
			PreparedStatement stmt1 = (PreparedStatement) connection.prepareStatement(sql_update_tel);
			PreparedStatement stmt2 = (PreparedStatement) connection.prepareStatement(sql_update_end);
			
			
			stmt.setString(1,	updatePf.getTipo());	 
			stmt.setString(2, 	updatePf.getNome());
			stmt.setString(3, 	updatePf.getSobrenome());
			stmt.setString(4, 	updatePf.getCpf());

			stmt1.setString(1, updatePf.getDdd());
			stmt1.setString(2, updatePf.getTel1());
			stmt1.setString(3, updatePf.getTel2());
			stmt1.setString(4, updatePf.getCel());
			stmt1.setString(5,  updatePf.getCpf());

			stmt2.setString(1, updatePf.getCep());
			stmt2.setString(2, updatePf.getRua());
			stmt2.setString(3, updatePf.getCidade());
			stmt2.setString(4, updatePf.getEstado());
			stmt2.setString(5, updatePf.getNo());
			stmt2.setString(6, updatePf.getBairro());
			stmt2.setString(7, updatePf.getComplemento());
			stmt2.setString(8, updatePf.getCpf());
			
			
			
		} catch (SQLException e) {
			System.out.println("Erro ao Atualizar cliente pf: " +e);
		}
		
	}
	
	//update Cliente Pj
	public void UpdateClientePj(DadoPj updatePj) {
			

		String sql_update_pj = "UPDATE cliente_pf set nome_cliente = ?, sobrenome = ? where cnpj = ?";
		
		String sql_update_tel = "UPDATE telefones_pf set ddd = ?, tel1 = ?, tel2 = ?, cel = ?"
				+ "where cliente_cnpj = ?";
		
		String sql_update_end = "UPDATE endereco_pf set cep = ?, rua = ?, cidade = ?, estado = ?,"
				+ "numero = ?, bairro = ?, complemento = ? where fk_cnpj_cliente = ?";
		
		
		try {
			
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql_update_pj);
			PreparedStatement stmt1 = (PreparedStatement) connection.prepareStatement(sql_update_tel);
			PreparedStatement stmt2 = (PreparedStatement) connection.prepareStatement(sql_update_end);

			
			stmt.setString(1,	updatePj.getTipo());	
			stmt.setString(2, 	updatePj.getNome());
			stmt.setString(3, 	updatePj.getSobrenome());
			stmt.setString(4, 	updatePj.getCnpj());


			stmt1.setString(1, updatePj.getDdd());
			stmt1.setString(2, 	updatePj.getTel1());
			stmt1.setString(3,	 updatePj.getTel2());
			stmt1.setString(4, 	updatePj.getCel());
			stmt1.setString(5, updatePj.getCnpj());

			stmt2.setString(1, updatePj.getCep());
			stmt2.setString(2, updatePj.getCidade());
			stmt2.setString(3, updatePj.getEstado());
			stmt2.setString(4, updatePj.getRua());
			stmt2.setString(5, updatePj.getBairro());
			stmt2.setString(6, updatePj.getNo());
			stmt2.setString(7, updatePj.getBairro());
			stmt2.setString(8, updatePj.getComplemento());
			stmt2.setString(9, updatePj.getCnpj());
			
		} catch (SQLException e) {
			System.out.println("Erro ao atualizar cliente pj: " +e);
		}

	}
}






