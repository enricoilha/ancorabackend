package main;
import java.util.Scanner;

import menu.EventMenu;
import menu.UserMenu;

public class Main {

	
	public static void main(String args[]) {
		
		UserMenu userMenu = new UserMenu();
		EventMenu eventMenu = new EventMenu();
		
		Scanner scanner = new Scanner(System.in);
		boolean loop = true;
		
		while(loop) {
			
			System.out.println("Deseja acessar qual menu ?");
			System.out.println("1 - Usuário ");
			System.out.println("2 - Evento ");
			System.out.println("0 - Sair");
			
			String opcao = scanner.nextLine();
			
			switch(Integer.parseInt(opcao)) {
			
			case 1:
				userMenu.ShowUserMenu();
				break;
			case 2:
				eventMenu.showEventMenu();
				break;
			case 3:
				break;
			case 0:
				loop = false;
				break;
			}
		}
		
		scanner.close();
	}
}
