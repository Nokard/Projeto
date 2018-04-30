package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import CONTROL.senhaGerente;
import VIEW.Cadastrar_Pedido;
import VIEW.Index;

public class DaoVerificaSenha extends ConnectionFac {

	private Connection connection;
	
	public DaoVerificaSenha() {
		// TODO Auto-generated constructor stub
	this.connection = new ConnectionFac().getConnection();
	
	}
	
	
	
	public void verificaSenha(senhaGerente senGerente) {
		
		try {
			
			PreparedStatement stmt = (PreparedStatement) this.connection.prepareStatement("SELECT * FROM senhagerente where senha = ? ");
			stmt.setInt(1, senGerente.getSenha());
			
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				JOptionPane.showMessageDialog(null, "Acesso concedido");

				new Cadastrar_Pedido().setVisible(true);
					
			}else {
				JOptionPane.showMessageDialog(null, "Voc� n�o tem permissao para acessars");
				new Index().setVisible(true);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
	}
}
