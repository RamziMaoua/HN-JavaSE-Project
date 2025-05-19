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
		this.balance = 0.0; // set after updating setBalance to accept a flow
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	
	//----- 1.3.5 Updating accounts - modified to take in Flow
	public void setBalance(Flow flow) {
		
	        if (flow instanceof Credit && !flow.isEffect()) {
	            if (this.accountNumber == flow.getTargetAccountNumber()) {
	                this.balance += flow.getAmount();
	                flow.setEffect(true);
	            }
	        } else if (flow instanceof Debit && !flow.isEffect()) {
	            if (this.accountNumber == flow.getTargetAccountNumber()) {
	                this.balance -= flow.getAmount();
	                flow.setEffect(true);
	            }
	        } else if (flow instanceof Transfer) {
	            Transfer transfer = (Transfer) flow;
	            if (this.accountNumber == transfer.getTargetAccountNumber()) {
	                this.balance += transfer.getAmount();
	                flow.setEffect(true);
	            } else if (this.accountNumber == transfer.getOriginAccountNumber()) {
	                this.balance -= transfer.getAmount();
	                flow.setEffect(true);
	            }
	            
	            if (!flow.isEffect()) {
	            	flow.setEffect(true);
	            }
	        }		
	}

	public double getBalance() {
		return balance;
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

	@Override
	public String toString() {
		return "Account number : " + getAccountNumber() +  ", Label : " + getLabel() + ", " + "Client : (" +  client.toString() + "), Balance : " + getBalance() ;
	}

	
	

}
