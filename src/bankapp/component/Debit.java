package bankapp.component;



//-------1.3.3 Creation of the Debit class

public class Debit extends Flow{
	
	public Debit(String comment, int identifier, double amount, int targetAccountNumber, String date) {
		super(comment, identifier, amount, targetAccountNumber, date); 
	}

}
