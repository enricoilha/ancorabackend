package menu;

import java.util.Scanner;

import services.EventsService;

public class EventMenu {
	
	public EventMenu() {}
	
	public void showEventMenu() {
		
		Scanner scanner = new Scanner(System.in);
		EventsService eventsService = new EventsService();		
		boolean loop = true;

		while (loop) {
			
			System.out.println("O que deseja?");
			System.out.println("1 - Criar evento");
			
			String selected = scanner.nextLine();
			
			switch (Integer.parseInt(selected)) {
			
			case 1:
				
				eventsService.createNewEvent();
				break;
			default:
				
				loop = false;
				break;
			}
		}
		
		scanner.close();
	}
}
