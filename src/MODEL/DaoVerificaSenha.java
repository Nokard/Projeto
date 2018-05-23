package MODEL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Statement;

import CONTROL.senhaGerente;
import VIEW.Cadastrar_Pedido;
import VIEW.Index;

public class DaoVerificaSenha extends ConnectionFac {

	ConnectionFac con = new ConnectionFac();
	
	public DaoVerificaSenha() {
			con.getConnection();
	}
	

	
	
	
}
