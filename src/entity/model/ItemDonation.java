package entity.model;

public class ItemDonation extends Donation {
    private String itemType;

    public ItemDonation(String donorName, float amount, String itemType) {
        super(donorName, amount);
        this.itemType = itemType;
    }
    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getItemType() {
        return itemType;
    }


    public void recordDonation() {
    	System.out.println("Item donation recorded. Type: " + itemType);
    }
}
