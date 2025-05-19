package bankapp.component;

//--------1.1.1 Creation of the Client Class
public class Client {
	
	private String firstName;
	private String name;
	private int clientNumber;
	
	//numberOfClient counts
	private static int numberOfClients;
	
	
	public Client(String name, String firstName) {
		this.firstName = firstName;
		this.name = name;
		numberOfClients++;
		this.clientNumber = numberOfClients;
	}
	
	
	public String getFirstName() {
		return this.firstName;
	}	
	
	public void setFirstName (String firstName) {
		this.firstName = firstName;
	}

	public String getName() {
		return name;
	}

	public void setName (String name) {
		this.name = name;
	}

	public int getClientNumber() {
		return clientNumber;
	}
	
	public void setClientNumber (int clientNumber) {
		this.clientNumber = clientNumber;
	}
	
	public static int getNumberOfClients() {
		return numberOfClients;
	}
	
	
	public String toString() {
		return "(Client number: " + getClientNumber() + ", Name: " + getName() + ", First Name: " + getFirstName() + ")" ;
	}
}
