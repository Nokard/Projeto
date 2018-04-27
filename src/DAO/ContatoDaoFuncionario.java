package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import CONTROL.DadoFunc;
import CONTROL.Produto;

public class ContatoDaoFuncionario extends ConnectionFac{


	private Connection connection;

	public ContatoDaoFuncionario() {
		this.connection = new ConnectionFac().getConnection();
	}

	//ADICIONANDO FUNCIONARIOS
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
						"(nome,sobrenome,rg,cpf,cargo) Values (?,?,?,?,?);";
				//table endereco_funcionario
				String sql_adiciona_end_func= "INSERT INTO endereco_funcionario"+
						"(cep,rua,cidade,estado,numero,bairro,complemento,fk_endereco_cpf_funcionario)"+
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
					stmt.setString(5, dadoFunc.getCargo());

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

	//ATUALIZANDO DADOS FUNCIONARIO
	public void UpdateFuncionario(DadoFunc updateFunc) {
		


	}

	//DELETANDO FUNCIONARIO COM CASCADE
	public void DeleteFuncionario(DadoFunc dadoFunc) {

		String delete_sql = "DELETE FROM adega.funcionario where cpf = ?";

		try {
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(delete_sql);
			stmt.setString(1, dadoFunc.getCpf());

			stmt.executeUpdate();

			JOptionPane.showMessageDialog(null, "Funcionario excluido com sucesso");


		} catch (SQLException e) {
			System.out.println("Erro ao excluir Funcionario" +e);
		}
	}
	
	//Atualizando Funcionarios
	public void UpdateFunc() {
		
	}


	//LISTANDO FUNCIONARIOS
	public List<DadoFunc> getFuncionarioDesc(String desc){

		try {

			List<DadoFunc> funcionarios = new ArrayList<DadoFunc>();

			PreparedStatement stmt = (PreparedStatement) this.connection.prepareStatement("select a.nome, a.sobrenome, a.rg, a.cpf, a.cargo," + 
					"c.ddd , c.tel1, c.tel2, c.cel," + 
					"b.CEP,b.ESTADO, b.CIDADE , b.BAIRRO, b.NUMERO, b.RUA, b.complemento " + 
					"from adega.funcionario a " + 
					"join endereco_funcionario b " + 
					"on a.cpf = b.fk_endereco_cpf_funcionario " + 
					"join adega.telefone_funcionario c " + 
					"on a.cpf = c.fk_cpf_funcionario " + 
					"WHERE a.nome like ?;");

			stmt.setString(1, "%"+desc+"%");

			ResultSet rs = stmt.executeQuery();


			while (rs.next()) {

				DadoFunc func = new DadoFunc();

				func.setNome(rs.getString("nome"));
				func.setSobrenome(rs.getString("sobrenome"));
				func.setRg(rs.getString("rg"));
				func.setCpf(rs.getString("cpf"));
				func.setCargo(rs.getString("cargo"));
				func.setDdd(rs.getInt("ddd"));
				func.setTel1(rs.getString("tel1"));
				func.setTel2(rs.getString("tel2"));
				func.setCel(rs.getString("cel"));
				func.setCep(rs.getString("CEP"));
				func.setEstado(rs.getString("estado"));
				func.setCidade(rs.getString("CIDADE"));
				func.setBairro(rs.getString("BAIRRO"));
				func.setNo(rs.getString("NUMERO"));
				func.setRua(rs.getString("RUA"));
				func.setComplemento(rs.getString("complemento"));

				funcionarios.add(func);

			}
			rs.close();
			stmt.close();
			return funcionarios;

		} catch (SQLException e) {
			throw new  RuntimeException(e);
		}


	}
	
	/*public List<DadoFunc> ListarFuncionarios(){

		try {

			List<DadoFunc> funcionarios = new ArrayList<DadoFunc>();

			PreparedStatement stmt = (PreparedStatement) this.connection.prepareStatement("select a.nome, a.sobrenome, a.rg, a.cpf, a.cargo," + 
					"c.ddd , c.tel1, c.tel2, c.cel," + 
					"b.CEP,b.ESTADO, b.CIDADE , b.BAIRRO, b.NUMERO, b.RUA, b.complemento " + 
					"from adega.funcionario a " + 
					"join endereco_funcionario b " + 
					"on a.cpf = b.fk_endereco_cpf_funcionario " + 
					"join adega.telefone_funcionario c " + 
					"on a.cpf = c.fk_cpf_funcionario;");

			ResultSet rs = stmt.executeQuery();


			while (rs.next()) {

				DadoFunc func = new DadoFunc();

				func.setNome(rs.getString("nome"));
				func.setSobrenome(rs.getString("sobrenome"));
				func.setRg(rs.getString("rg"));
				func.setCpf(rs.getString("cpf"));
				func.setCargo(rs.getString("cargo"));
				func.setDdd(rs.getInt("ddd"));
				func.setTel1(rs.getString("tel1"));
				func.setTel2(rs.getString("tel2"));
				func.setCel(rs.getString("cel"));
				func.setCep(rs.getString("CEP"));
				func.setEstado(rs.getString("estado"));
				func.setCidade(rs.getString("CIDADE"));
				func.setBairro(rs.getString("BAIRRO"));
				func.setNo(rs.getString("NUMERO"));
				func.setRua(rs.getString("RUA"));
				func.setComplemento(rs.getString("complemento"));

				funcionarios.add(func);

			}
			rs.close();
			stmt.close();
			return funcionarios;

		} catch (SQLException e) {
			throw new  RuntimeException(e);
		}


	}
*/
}












