package bankapp.component;



//-------1.3.3 Creation of the Credit class

public class Credit extends Flow{
	public Credit() {
        super(null, 0, 0.0, 0, null);
    }
	
	public Credit(String comment, int identifier, double amount, int targetAccountNumber, String date) {
		super(comment, identifier, amount, targetAccountNumber, date); 
	}

}
