package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.User;

public class UserDAO {
	private Connection conexao;
	
	public void insert(User user) throws SQLException {
		conexao = GerenciadorBD.obterConexao();
		PreparedStatement comandoSQL = null;
		
		String sql = "INSERT INTO USERS (user_id, user_name, user_email) values (SQ_USERS.NEXTVAL, ?, ?)";
		
		try {
			comandoSQL = conexao.prepareStatement(sql);
			comandoSQL.setString(1, user.getName());
			comandoSQL.setString(2, user.getEmail());
			
			comandoSQL.executeUpdate();
			System.out.println("Usuário cadastrado com sucesso!");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			comandoSQL.close();
			conexao.close();
		}
	}
	
	public ArrayList<User> selectAll() throws SQLException {
		conexao = GerenciadorBD.obterConexao();
		PreparedStatement comandoSQL = null;
		
		String sql = "select * from users";
		
		ArrayList<User> users = new ArrayList<User>();
		
		try {
			comandoSQL = conexao.prepareStatement(sql);
			
			ResultSet queriedUser = comandoSQL.executeQuery();
			
			while(queriedUser.next()) {
				User usuario = new User(queriedUser.getInt("user_id"),queriedUser.getString("user_name"), queriedUser.getString("user_email"));
				
				users.add(usuario);
			}
			
			} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			comandoSQL.close();
			conexao.close();
		}
	
		
		return users;
		
	}
	
	public User selectSingleUser(int id) throws SQLException {
		conexao = GerenciadorBD.obterConexao();
		PreparedStatement comandoSQL = null;
		
		 String sql = "SELECT * FROM Users WHERE user_id = ?";
	     User user = new User();
	     
	     try {
	    	 comandoSQL = conexao.prepareStatement(sql);
	    	 comandoSQL.setInt(1, id);
	    	 
	    	 ResultSet usuario = comandoSQL.executeQuery();
	    	 
	    	 if(usuario.next()) {
	    		 user.setId(usuario.getInt("user_id"));
	    		 user.setName(usuario.getString("user_name"));
	    		 user.setEmail(usuario.getString("user_email"));
	    	 }
	    	 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			comandoSQL.close();
			conexao.close();
			
		}
	     
	     return user;
	   
	}
	
	 public void updateUser(User user) throws SQLException {
	        conexao = GerenciadorBD.obterConexao();
			PreparedStatement comandoSQL = null;
			
	        String sql = "UPDATE Users SET user_name = ?, user_email = ? WHERE user_id = ?";

	        try  {
	        	comandoSQL = conexao.prepareStatement(sql);
	            comandoSQL.setString(1, user.getName());
	            comandoSQL.setString(2, user.getEmail());
	            comandoSQL.setInt(3, user.getId());
	            comandoSQL.executeUpdate();
	            
	            System.out.println("Usuário atualizado com sucesso");

	        } catch (SQLException e) {
	            e.printStackTrace();
	            
	        } finally {
				comandoSQL.close();
				conexao.close();
				
			}
	    }
	 
	 	public void deleteUser(int id) throws SQLException {
	 		conexao = GerenciadorBD.obterConexao();
			PreparedStatement comandoSQL = null;
			
	        String sql = "DELETE FROM Users WHERE user_id = ?";

	        try {

	        	comandoSQL = conexao.prepareStatement(sql);
	        	comandoSQL.setInt(1, id);
	            comandoSQL.executeUpdate();
	            
	            System.out.println("Usuário deletado com sucesso");

	        } catch (SQLException e) {
	            e.printStackTrace();
	            
	        } finally {
				comandoSQL.close();
				conexao.close();
				
			}
	    }

}
