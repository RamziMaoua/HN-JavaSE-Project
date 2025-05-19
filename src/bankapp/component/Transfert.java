package bankapp.component;


//-------1.3.3 Creation of the Transfert class
public class Transfert extends Flow {

	private int originAccountNumber;
	public Transfert(String comment, int identifier, double amount, int targetAccountNumber, String date, int originAccountNumber) {
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
