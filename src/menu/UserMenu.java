package menu;

import java.util.Scanner;

import services.UsersService;


public class UserMenu {
		
	public void ShowUserMenu() {
		Scanner scanner = new Scanner(System.in);
		UsersService usersService = new UsersService();
		
		boolean loop = true;

		while (loop) {
			
			System.out.println("O que deseja?");
			System.out.println("1 - Adicionar de usuário?");
			System.out.println("2 - Selecionar usuário específico?");
			System.out.println("3 - Selecinoar todos os usuários");
			System.out.println("4 - Alterar dados de usuário");
			System.out.println("5 - Deletar usuário");

			System.out.println("0 - Sair");

			
			String selected = scanner.nextLine();
				
				switch (Integer.parseInt(selected)) {
				
				case 1:
					usersService.createUser();
					break;
				case 2:
					usersService.selectSingleUser();
					break;
				case 3:
					usersService.selectAllUsers();
					break;
				case 4:
					usersService.updateUser();
					break;
				case 5:
					usersService.deleteUser();
					break;
				case 0:
					loop = false;
					break;
				default:
					loop = false;
					break;
				}
			} 
		
		scanner.close();
			
		}
	
	}
	


