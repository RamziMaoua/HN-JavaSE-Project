package bankapp.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import bankapp.component.Account;
import bankapp.component.Client;
import bankapp.component.Credit;
import bankapp.component.CurrentAccount;
import bankapp.component.Debit;
import bankapp.component.Flow;
import bankapp.component.SavingsAccount;
import bankapp.component.Transfer;

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
				
				
				
				//-------- 1.2.3 Creation of the table account
				ArrayList<Account> accountCollection = generateAccountCollection(clientCollection);
				displayAccounts(accountCollection);
				
				//-------- 1.3.1 Adaptation of the table of accounts
				HashMap<Integer, Account> accountMap =generateAccountHashTable(accountCollection);
			
				
				//-------- 1.3.4 Creation of flow array
				ArrayList<Flow> flows = generateFlows(accountCollection);	
				
				//-------- 1.3.5 Apply Flow to accounts
				applyFlowsToAccounts(flows, accountMap);
				displayAccountsSortedByBalance(accountMap);

				
			
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
			System.out.println("List of clients");
			clients.stream()
		           .map(Client::toString)
		           .forEach(System.out::println);
			System.out.println();
			
		}
		
		
		
		//----------- 1.2.3 Creation of the table account
		public static ArrayList<Account> generateAccountCollection(List<Client> clients) {
			
			int numberOfClients = Client.getNumberOfClients();
			
			ArrayList<Account> collection = new ArrayList<Account>(numberOfClients * 2);
			
			for (Client c : clients) {
				collection.addLast(new CurrentAccount("Current Account", c));
				// collection.getLast().setBalance(0); // unusable after updating setBalance to accept flow
				collection.addLast(new SavingsAccount("Savings Account", c));
				// collection.getLast().setBalance(0); // unusable after updating setBalance to accept flow
			}
			
			return collection;
		}
		
		public static void displayAccounts(List<Account> accounts) {
			System.out.println("List of accounts");
			accounts.stream()
					.map(Account::toString)
					.forEach(System.out::println);
			System.out.println();
		}
		

		//-------- 1.3.1 Adaptation of the table of accounts
		public static HashMap<Integer, Account> generateAccountHashTable(List<Account> accounts) {
			return accounts.stream()
					.collect(Collectors.toMap(
							Account::getAccountNumber,
							account -> account,
	                       (a1, a2) -> a1,     
	                       HashMap::new 
					)) ;
			
		}
		
		public static void displayAccountsSortedByBalance(HashMap<Integer, Account> accountMap) {
			System.out.println("List of accounts sorted by balance");
			accountMap.values()
		              .stream()
		              .sorted(Comparator.comparingDouble(Account::getBalance))
		              .forEach(System.out::println);
			System.out.println();
		}
		
		//------- 1.3.4 Creation of the flow array
		public static ArrayList<Flow> generateFlows(List<Account> accounts) {
		    ArrayList<Flow> flows = new ArrayList<>();
		    LocalDate today = LocalDate.now();
		    String date = today.plusDays(2).toString(); // operations done 2 days later

		    // Debit €50 from account #1
		    flows.add(new Debit("Debit from acc 1", 1, 50.0, 1, date));

		    // Credit €100.50 to all current accounts
		    List<Account> currentAccounts = accounts.stream()
		        .filter(a -> a instanceof CurrentAccount)
		        .collect(Collectors.toList());

		    int id = 2;
		    for (Account acc : currentAccounts) {
		        flows.add(new Credit("Credit to current acc", id++, 100.50, acc.getAccountNumber(), date));
		    }

		    // Credit €1500 to all savings accounts
		    List<Account> savingsAccounts = accounts.stream()
		        .filter(a -> a instanceof SavingsAccount)
		        .collect(Collectors.toList());

		    for (Account acc : savingsAccounts) {
		        flows.add(new Credit("Credit to savings acc", id++, 1500.0, acc.getAccountNumber(), date));
		    }

		    // Transfer €50 from account 1 to account 2
		    flows.add(new Transfer("Transfer from acc 1 to acc 2", id++, 1050.0, 2, date, 1));

		    return flows;
		}
		
		
		
		
		//--------1.3.5 Updating accounts
		public static void applyFlowsToAccounts(List<Flow> flows, HashMap<Integer, Account> accountMap) {
		    for (Flow flow : flows) {
		        for (Account account : accountMap.values()) {
		            account.setBalance(flow);
		        }
		    }

		    // Check for negative balances
		    Predicate<Account> isNegative = acc -> acc.getBalance() < 0;
		    Optional<Account> anyNegative = accountMap.values().stream()
		        .filter(isNegative)
		        .findFirst();

		    anyNegative.ifPresent(account -> 
		        System.out.println("Negative balance on account " + account.getAccountNumber())
		    );
		}
		
		
		
		
		
		
}
