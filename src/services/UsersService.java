package services;

import java.util.ArrayList;
import java.util.Scanner;

import dao.UserDAO;
import model.User;

public class UsersService {
	
	
	public void createUser() {
		Scanner scanner = new Scanner(System.in);
		UserDAO userDAO = new UserDAO();
		
		System.out.println("Adicionar usuário: ");
		
		System.out.println("Nome: ");
		String nome = scanner.nextLine();
		System.out.println("Email: ");
		String email = scanner.nextLine();
		
		User user = new User(nome, email);
		
		try {
			userDAO.insert(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		scanner.close();
	}
	
  public void selectSingleUser() {
	  Scanner scanner = new Scanner(System.in);
	  UserDAO userDAO = new UserDAO();
	  
	  
	  try {
		  ArrayList<User> users = userDAO.selectAll();
		  
		  for(int i = 0; i < users.size(); i++) {
			  System.out.println(users.get(i).getId() + " - " + users.get(i).getName());
		  }
		  
		  System.out.println("Selecione o id do usuário:");
		  String id = scanner.nextLine();
		  
		  User user = userDAO.selectSingleUser(Integer.parseInt(id));
		  
		  System.out.println("Nome: " + user.getName());
		  System.out.println("Email: " + user.getEmail());
		  
	} catch (Exception e) {
		e.printStackTrace();
	}
	  
	  scanner.close();

	  }
}
