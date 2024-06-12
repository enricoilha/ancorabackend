package services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import dao.EventDAO;
import model.Event;

public class EventsService {
	
	public void createNewEvent() {
		EventDAO eventDAO = new EventDAO();
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

		try {
			int insertedId = eventDAO.insert(event);
			event.setId(insertedId);
			eventDAO.insertEmailsTable(event);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			scanner.close();
		}
		
		
	}

	public void selectAllEvents() {
		EventDAO eventsDAO = new EventDAO();

		try {
			ArrayList<Event> events = eventsDAO.selectAll();

			for (int i = 0; i < events.size(); i++) {

                Event event = events.get(i);
                System.out.println("\n");
                System.out.println("Id do evento: " + event.getId());
                System.out.println("Título: " + event.getTitle());
                System.out.println("Descrição: " + event.getDescription());
                System.out.println("Início: " + event.getStartDate());
                System.out.println("Término: " + event.getEndDate());
                System.out.println("Emails de usuários: " + event.getUserEmails());
                System.out.println("\n");
            }

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectSingleEvent() {
		EventDAO eventDAO = new EventDAO();
		Scanner scanner = new Scanner(System.in);
		
		try {
			ArrayList<Event> events = eventDAO.selectAll();
			System.out.println("\n Digite o id do evento que deseja selecionar: \n");

			for(int i = 0; i < events.size(); i++){
				Event event = events.get(i);
				System.out.println(event.getId() + " - " + event.getTitle());
			}
			String id = scanner.nextLine();

			Event event = eventDAO.selectSingleEvent(Integer.parseInt(id));

			System.out.println("\n");
			System.out.println("Id do evento: " + event.getId());
			System.out.println("Título: " + event.getTitle());
			System.out.println("Descrição: " + event.getDescription());
			System.out.println("Início: " + event.getStartDate());
			System.out.println("Término: " + event.getEndDate());
			System.out.println("Emails de usuários: " + event.getUserEmails());
			System.out.println("\n");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			scanner.close();
		}
	}

	public void deleteEvent() {
		EventDAO eventDAO = new EventDAO();
		Scanner scanner = new Scanner(System.in);
		
		try {
			ArrayList<Event> events = eventDAO.selectAll();

			System.out.println("\n Digite o id do evento que deseja deletar: \n");
			for(int i = 0; i < events.size(); i++) {
				Event event = events.get(i);
				System.out.println(event.getId() + " - " + event.getTitle());
			}
			String id = scanner.nextLine();

			eventDAO.delete(Integer.parseInt(id));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			scanner.close();
		}
	}
}
