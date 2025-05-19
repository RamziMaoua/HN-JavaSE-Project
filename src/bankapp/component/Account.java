package bankapp.component;


//-------1.2.1 Creation of the Account class
public abstract class Account {
	
	protected String label;
	protected double balance;
	protected int accountNumber;
	protected Client client;
	
	private static int numberOfAccounts;
	
	protected Account(String label, Client client) {
		numberOfAccounts++;
		accountNumber = numberOfAccounts;
		this.label = label;
		this.client = client;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public static int getNumberOfAccounts() {
		return numberOfAccounts;
	}

	public static void setNumberOfAccounts(int numberOfAccounts) {
		Account.numberOfAccounts = numberOfAccounts;
	}
	
	public String toString() {
		return "Account number : " + getAccountNumber() +  ", Label : " + getLabel() + ", " + "Client : " +  client.toString() + "Balance : " + getBalance() ;
	}

	
	

}
