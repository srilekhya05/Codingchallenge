package entity.model;
import exception.*;

public abstract class Donation {
    private String donorName;
    private float amount;

    public Donation(String donorName, float amount) {
    	this.donorName = donorName;
    	if (amount < 10) {
            throw new InsufficientFundsException("Insufficient funds. Minimum donation amount is $10.");
        }
        this.amount = amount;
    }

    public void setDonorName(String donorName) {
        this.donorName = donorName;
    }
    
    public String getDonorName() {
        return donorName;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
    
    public float getAmount() {
        return amount;
    }

    public abstract void recordDonation();
    
}
