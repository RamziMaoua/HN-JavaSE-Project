package bankapp.component;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

//-------1.3.2 Creation of the Flow class
@JsonTypeInfo(
	    use = JsonTypeInfo.Id.NAME,
	    include = JsonTypeInfo.As.PROPERTY,
	    property = "type"
	)
	@JsonSubTypes({
	    @JsonSubTypes.Type(value = Debit.class, name = "debit"),
	    @JsonSubTypes.Type(value = Credit.class, name = "credit"),
	    @JsonSubTypes.Type(value = Transfer.class, name = "transfer")
	})
public abstract class Flow {
	private String comment;
	private int identifier;
	private double amount;
	private int targetAccountNumber;
	private boolean effect;
	private String date;
	
	
	protected Flow (String comment, int identifier, double amount, int targetAccountNumber, String date) {
	    this.comment = comment;
	    this.identifier = identifier;
	    this.amount = amount;
	    this.targetAccountNumber = targetAccountNumber;
	    this.date = date;
	    this.effect = false;
		
	}
	
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getIdentifier() {
		return identifier;
	}
	public void setIdentifier(int identifier) {
		this.identifier = identifier;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public int getTargetAccountNumber() {
		return targetAccountNumber;
	}
	public void setTargetAccountNumber(int targetAccountNumber) {
		this.targetAccountNumber = targetAccountNumber;
	}
	public boolean isEffect() {
		return effect;
	}
	public void setEffect(boolean effect) {
		this.effect = effect;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

}
