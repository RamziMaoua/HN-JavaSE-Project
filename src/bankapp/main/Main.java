package bankapp.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import bankapp.component.Account;
import bankapp.component.Client;
import bankapp.component.CurrentAccount;
import bankapp.component.SavingsAccount;

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
				
				
				
				//-------- 1.2.3
				ArrayList<Account> accountCollection = generateAccountCollection(clientCollection);
				displayAccounts(accountCollection);
				
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
		
		
		
		//----------- 1.2.3 Creation of the table account
		public static ArrayList<Account> generateAccountCollection(List<Client> clients) {
			
			int numberOfClients = Client.getNumberOfClients();
			
			ArrayList<Account> collection = new ArrayList<Account>(numberOfClients * 2);
			
			for (Client c : clients) {
				collection.addLast(new CurrentAccount("Current Account", c));
				collection.getLast().setBalance(0);
				collection.addLast(new SavingsAccount("Savings Account", c));
				collection.getLast().setBalance(0);
			}
			
			return collection;
		}
		
		public static void displayAccounts(List<Account> accounts) {
			accounts.stream()
					.map(Account::toString)
					.forEach(System.out::println);
		}
		
		
		
		
		
		
		
		
}
