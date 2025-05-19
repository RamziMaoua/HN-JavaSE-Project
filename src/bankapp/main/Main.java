package bankapp.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import bankapp.component.Client;

public class Main {

	public static void main(String[] args) {
		
		//-------- 1.1.2 Creation of the main class for tests
				Scanner scanner = new Scanner(System.in);
				System.out.println("How many clients will use our bank ?" );
				int numberOfClients = scanner.nextInt();
				scanner.close();
				
				ArrayList<Client> clientCollection = new ArrayList<>();
				clientCollection = generateClientCollection(numberOfClients);
				displayClients(clientCollection);
				
	}
	
	
	//----------- 1.1.2 Creation of the main class for tests
		public static ArrayList<Client> generateClientCollection(int numberOfClients) {
			ArrayList<Client> collection = new ArrayList<Client>(numberOfClients);
			
			for (int i= 0; i< numberOfClients; i++) {
				collection.add(i, new Client("name" + (i + 1), "firstname" + (i + 1)));
			}
			
			return collection;
		}
		
		public static void displayClients(List<Client> clients) {
		    clients.stream()
		           .map(Client::toString)
		           .forEach(System.out::println);
		}
		
		
		
		
}
