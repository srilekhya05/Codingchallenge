package entity.model;

import exception.InsufficientFundsException;

import java.util.Date;
public class CashDonation extends Donation {
    private Date donationDate;

    public CashDonation(String donorName, float amount, Date donationDate) {
        super(donorName, amount);
        this.donationDate = donationDate;
    }

    public Date getDonationDate() {
        return donationDate;
    }

    public void setDonationDate(Date donationDate) {
        this.donationDate = donationDate;
    }

    public void recordDonation() {
        System.out.println("Cash donation recorded on " + donationDate);
    }

    
    public static void main(String[] args) {
        
        Date donationDate = new Date();
        

        try {
            
            CashDonation donation = new CashDonation("Jane Doe", 20.0f, donationDate);
            donation.recordDonation();  
        } catch (InsufficientFundsException e) {
            System.out.println("Error: " + e.getMessage());
        }
       
        
    }

}

