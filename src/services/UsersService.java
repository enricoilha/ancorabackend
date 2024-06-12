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
	  
	  System.out.println("Selecione o id do usuário:");

	  try {
		  ArrayList<User> users = userDAO.selectAll();
		  
		  for(int i = 0; i < users.size(); i++) {
			  System.out.println(users.get(i).getId() + " - " + users.get(i).getName());
		  }
		  
		  String id = scanner.nextLine();
		  
		  User user = userDAO.selectSingleUser(Integer.parseInt(id));
		  
		  System.out.println("Nome: " + user.getName());
		  System.out.println("Email: " + user.getEmail());
		  
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		scanner.close();
	}
	  
}

public void selectAllUsers() {
	Scanner scanner = new Scanner(System.in);
	UserDAO userDAO = new UserDAO();

	try {
		ArrayList<User> users = userDAO.selectAll();

		for(int i = 0; i < users.size(); i++) {
			System.out.println("\n" + "Nome: " + users.get(i).getName());
			System.out.println("Email: " + users.get(i).getEmail() + "\n");
		}
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		scanner.close();
	}
}

public void updateUser() {
	Scanner scanner = new Scanner(System.in);
	UserDAO userDAO = new UserDAO();

	try {
		ArrayList<User> users = userDAO.selectAll();

		for(int i = 0; i < users.size(); i++) {
			System.out.println(users.get(i).getId() + " - " + users.get(i).getName());
		}
		System.out.println("Digite o ID do usuário que deseja alterar");
		String id = scanner.nextLine();

		System.out.println("Novos dados: \n");
		System.out.println("Nome: ");
		String newName = scanner.nextLine();
		System.out.println("Email: ");
		String newEmail = scanner.nextLine();
		User newUser = new User(Integer.parseInt(id), newName, newEmail);

		userDAO.updateUser(newUser);

	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		scanner.close();
	}
}

public void deleteUser() {
	Scanner scanner = new Scanner(System.in);
	UserDAO userDAO = new UserDAO();

	try {
		ArrayList<User> users = userDAO.selectAll();

		for(int i = 0; i < users.size(); i++) {
			System.out.println(users.get(i).getId() + " - " + users.get(i).getName());
		}
		System.out.println("Digite o ID do usuário que deseja alterar");
		String id = scanner.nextLine();

		userDAO.deleteUser(Integer.parseInt(id));
	} catch(Exception e) {
		e.printStackTrace();
	} finally {
		scanner.close();
	}
}
}
