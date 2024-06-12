package menu;

import java.util.Scanner;

import services.MetricsService;

public class MetricMenu {
    
    public void showMetricMenu() {

        Scanner scanner = new Scanner(System.in);
		MetricsService metricsService = new MetricsService();
		
		boolean loop = true;

		while (loop) {
			
			System.out.println("O que deseja?");
			System.out.println("1 - Participação em eventos por usuário");
			System.out.println("0 - Sair");

			
			String selected = scanner.nextLine();
				
				switch (Integer.parseInt(selected)) {
                    case 1:
                        metricsService.getUsersInEvents();
                        break;
                    case 0:
                        loop = false;
                        break;
                    default:
                        loop = false;
                        break;
                }
            }
    }
}
