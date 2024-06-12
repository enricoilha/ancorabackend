package menu;

import java.util.Scanner;

import services.EventsService;

public class EventMenu {
		
	public void showEventMenu() {
		
		Scanner scanner = new Scanner(System.in);
		EventsService eventsService = new EventsService();		
		boolean loop = true;

		while (loop) {
			
			System.out.println("O que deseja?");
			System.out.println("1 - Criar evento");
			System.out.println("2 - Selecionar todos os eventos");
			System.out.println("3 - Selecione evento específico");
			System.out.println("4 - Alterar evento");
			System.out.println("5 - Deletar evento");
		
			System.out.println("0 - Sair");
			
			String selected = scanner.nextLine();
			
			switch (Integer.parseInt(selected)) {
			
			case 1:
				eventsService.createNewEvent();
				break;
			case 2:
			  eventsService.selectAllEvents();
			  break;
			case 3:
				eventsService.selectSingleEvent();
				break;
			case 4:
				eventsService.updateEvent();
				break;
			case 5:
				eventsService.deleteEvent();
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
