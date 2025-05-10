package custom;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Vendor {
    private int vendorId;
    private String name;
    private String contactNumber;
    private String email;
    private String address;
    private String rentalType; // Full-Time or Part-Time
    private Date availableFrom; // Only if Part-Time
    private Date availableTo;   // Only if Part-Time
    private double pricePerHour;

    // Constructor
    public Vendor(int vendorId, String name, String contactNumber, String email, String address,
                  String rentalType, String availableFromInput, String availableToInput, double pricePerHour) {
        this.vendorId = vendorId;
        this.name = name;
        this.contactNumber = contactNumber;
        this.email = email;
        this.address = address;
        this.rentalType = rentalType;
        this.pricePerHour = pricePerHour;

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        try {
            if (rentalType.equalsIgnoreCase("Part-Time")) {
                this.availableFrom = dateFormat.parse(availableFromInput);
                this.availableTo = dateFormat.parse(availableToInput);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    // Getters
    public int getVendorId() {
        return vendorId;
    }

    public String getName() {
        return name;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getRentalType() {
        return rentalType;
    }

    public Date getAvailableFrom() {
        return availableFrom;
    }
    public Date getAvailableTo() {
        return availableTo;
    }

    public double getPricePerHour() {
        return pricePerHour;
    }

    // Setters
    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPricePerHour(double pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    // Display method
    public void displayVendorInfo() {
        System.out.println("Vendor ID: " + vendorId +
                           ", Name: " + name +
                           ", Contact: " + contactNumber +
                           ", Email: " + email +
                           ", Address: " + address +
                           ", Rental Type: " + rentalType +
                           ", Price per Hour: ₹" + pricePerHour);

        if (rentalType.equalsIgnoreCase("Part-Time")) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            System.out.println("Available From: " + sdf.format(availableFrom) +
                               ", Available To: " + sdf.format(availableTo));
        }
    }

}


