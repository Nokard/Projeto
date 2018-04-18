package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import CONTROL.DadoFunc;

public class ContatoDaoFuncionario extends ConnectionFac{


	private Connection connection;

	public ContatoDaoFuncionario() {
		this.connection = new ConnectionFac().getConnection();
	}


	public void adicionaFuncionario(DadoFunc dadoFunc) {

		try {
			PreparedStatement verificaFunc;
			verificaFunc = (PreparedStatement) this.connection.prepareStatement
					("SELECT * FROM funcionario where rg = ? or cpf = ?");
			verificaFunc.setString(1, dadoFunc.getRg());
			verificaFunc.setString(2, dadoFunc.getCpf());
			ResultSet rs = verificaFunc.executeQuery();

			if (rs.next()) {
				JOptionPane.showMessageDialog(null, "Funcionário já Cadastrado");
			}else {
				//Comandos SQL para inserir em 3 tabelas
				// tablea funcionario
				String sql_adiciona_func= "Insert into funcionario"+
						"(nome,sobrenome,rg,cpf) Values (?,?,?,?);";
				//table endereco_funcionario
				String sql_adiciona_end_func= "INSERT INTO endereco_funcionario"+
						"(cep,rua,cidade,estado,numero,bairro,complemento,fk_cpf_funcionario)"+
						"VALUES(?,?,?,?,?,?,?,?);";
				//table telefone_funcionario
				String sql_adiciona_tel_func = "INSERT INTO telefone_funcionario"+
						"(ddd,tel1,tel2,cel,fk_cpf_funcionario)"+
						"VALUES(?,?,?,?,?);";

				try {
					//PreparedStatement para pegar o sql e inserir no banco
					PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql_adiciona_func);
					PreparedStatement stmt1 = (PreparedStatement) connection.prepareStatement(sql_adiciona_end_func);
					PreparedStatement stmt2 = (PreparedStatement) connection.prepareStatement(sql_adiciona_tel_func);

					//pegando os dados do sql_adiciona_func
					stmt.setString(1, dadoFunc.getNome());
					stmt.setString(2, dadoFunc.getSobrenome());
					stmt.setString(3, dadoFunc.getRg());
					stmt.setString(4, dadoFunc.getCpf());

					//pegando os dados do sql_adiciona_endereco_funcionario
					stmt1.setString(1, dadoFunc.getCep());
					stmt1.setString(2, dadoFunc.getRua());
					stmt1.setString(3, dadoFunc.getCidade());
					stmt1.setString(4, dadoFunc.getEstado());
					stmt1.setString(5, dadoFunc.getNo());
					stmt1.setString(6, dadoFunc.getBairro());
					stmt1.setString(7, dadoFunc.getComplemento());
					stmt1.setString(8, dadoFunc.getCpf());

					//pegando os dados do sql_adiciona_telefone_funcionario
					stmt2.setInt(1, dadoFunc.getDdd());
					stmt2.setString(2, dadoFunc.getTel1());
					stmt2.setString(3, dadoFunc.getTel2());
					stmt2.setString(4,  dadoFunc.getCel());
					stmt2.setString(5, dadoFunc.getCpf());

					stmt.execute();
					stmt1.execute();
					stmt2.execute();
					stmt.close();
					stmt1.close();
					stmt2.close();

					JOptionPane.showMessageDialog(null, "Funcionario "+dadoFunc.getNome().toUpperCase()+" Cadastrado com sucesso");



				} catch (SQLException e) {
					System.out.println("Erro ao cadastrar Funcionario " + e);
				}

			}

		} catch (Exception e) {
			System.out.println("Erro ao verificar Funcionario: "+ e);
		}

	}

}
