package services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import model.Event;

public class EventsService {
	
	public void createNewEvent() {
		Scanner scanner = new Scanner(System.in);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		
		System.out.println("Criar novo evento: ");
		
		System.out.println("Título: ");
	    String title = scanner.nextLine();

	    System.out.print("Descrição: ");
	    String description = scanner.nextLine();
	    
	    System.out.println("Dia da Reunião: ");
	    String day = scanner.nextLine();
	    
	    System.out.println("Mês da Reunião: ");
	    String month = scanner.nextLine();
	    
	    System.out.println("Year da Reunião: ");
	    String year = scanner.nextLine();
	    
	    System.out.println("Horário de início (formato: 10:00): ");
	    String startTime = scanner.nextLine();
	    
	    System.out.println("Duração da Reunião em minutos: ");
	    String duration = scanner.nextLine();

	    LocalDateTime startDate = LocalDateTime.parse(year + "-" + month + "-" + day + " " + startTime, formatter);

	    
	    LocalDateTime endDate = startDate.plusMinutes(Integer.parseInt(duration));
	    		 
	    System.out.print("Quantos particpantes? ");
        int numEmails = scanner.nextInt();
        scanner.nextLine();

        ArrayList<String> userEmails = new ArrayList<>();
        
        for (int i = 0; i < numEmails; i++) {
            System.out.print("Email participante" + (i + 1) + ": ");
            userEmails.add(scanner.nextLine());
        }
		
		Event event = new Event(title, description, startDate, endDate, userEmails);
		
		System.out.println("Início: " + event.getStartDate().format(formatter));
		System.out.println("Fim: " + event.getEndDate().format(formatter));

		
		System.out.println("Evento criado com sucesso!");
		
		scanner.close();
	}
}
