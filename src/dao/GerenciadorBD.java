package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GerenciadorBD {

	public static Connection obterConexao() {
		Connection conexao = null;

		// Credenciais do banco de dados
		String usuarioBD = "rm97327"; // usuário
		String senhaBD = "240101"; // senha

		try {
			conexao = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl", usuarioBD, senhaBD);
		} catch (SQLException e) {
			System.out.println("problema na conexão");
			e.printStackTrace();
		}

		return conexao;
	}

}