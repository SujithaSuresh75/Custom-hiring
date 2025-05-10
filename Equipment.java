package custom;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Equipment {
    private int equipmentId;
    private String equipmentName;
    private int quantity;
    private double pricePerHour;
    private String rentalType; // Full-Time / Part-Time
    private Date availableFrom;
    private Date availableTo;

    // Constructor
    public Equipment(int id, String name, int qty, double pricePerHour, String rentalType, Date availableFrom, Date availableTo) {
        this.equipmentId = id;
        this.equipmentName = name;
        this.quantity = qty;
        this.pricePerHour = pricePerHour;
        this.rentalType = rentalType;
        this.availableFrom = availableFrom;
        this.availableTo = availableTo;
    }

    // Getters
    public int getEquipmentId() {
        return equipmentId;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public int getQuantity() {
        return quantity;
    }
    public double getPricePerHour() {
        return pricePerHour;
    }

    public String getRentalType() {
        return rentalType;
    }

    public Date getAvailableFrom(){
    	return availableFrom;
    }

    public Date getAvailableTo() {
        return availableTo;
    }

    // Display method
    public void displayEquipmentInfo() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        System.out.println("Equipment ID: " + equipmentId +
                           ", Name: " + equipmentName +
                           ", Quantity: " + quantity +
                           ", Price per Hour: ₹" + pricePerHour +
                           ", Rental Type: " + rentalType);

        if (rentalType.equalsIgnoreCase("Part-Time")) {
            System.out.println("Available From: " + sdf.format(availableFrom) +
                               ", Available To: " + sdf.format(availableTo));
        }
    }
}

    
