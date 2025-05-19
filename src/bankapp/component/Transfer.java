package bankapp.component;


//-------1.3.3 Creation of the Transfer class
public class Transfer extends Flow {

	private int originAccountNumber;
	public Transfer(String comment, int identifier, double amount, int targetAccountNumber, String date, int originAccountNumber) {
		super(comment, identifier, amount, targetAccountNumber, date); 
		this.originAccountNumber = originAccountNumber;
		
	}
	
	public int getOriginAccountNumber() {
		return originAccountNumber;
	}

	public void setOriginAccountNumber(int originAccountNumber) {
		this.originAccountNumber = originAccountNumber;
	}
}
