package menu;

import java.util.Scanner;

import services.UsersService;


public class UserMenu {
	
	public UserMenu() {}
	
	public void ShowUserMenu() {
		Scanner scanner = new Scanner(System.in);
		UsersService usersService = new UsersService();
		
		boolean loop = true;

		while (loop) {
			
			System.out.println("O que deseja?");
			System.out.println("1 - Adicionar de usuário?");
			System.out.println("2 - Selecionar usuário específico?");

			
			String selected = scanner.nextLine();
				
				switch (Integer.parseInt(selected)) {
				
				case 1:
					usersService.createUser();
					break;
				case 2:
					usersService.selectSingleUser();
					break;
				default:
					loop = false;
					break;
				}
			} 
		
		scanner.close();
			
		}
	
	}
	


