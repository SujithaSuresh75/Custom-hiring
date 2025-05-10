package custom;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Booking {
    String buyerName;
    int equipmentId;
    Date startDate;
    Date endDate;

    // Constructor
    public Booking(String buyerName, int equipmentId, String startDateInput, String endDateInput) {
        this.buyerName = buyerName;
        this.equipmentId = equipmentId;

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        try {
            this.startDate = dateFormat.parse(startDateInput);
            this.endDate = dateFormat.parse(endDateInput);
            Date today = new Date();
            if (startDate.before(today)) {
                System.out.println("Booking start date cannot be before today!");
                // Handle accordingly, maybe reject the booking
            }


        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    public boolean isAvailable(ArrayList<Booking> bookings, ArrayList<Equipment> equipments) {
        int totalAvailable = 0;

        // Check the available quantity of the requested equipment
        for (Equipment eq : equipments) {
            if (eq.getEquipmentId() == equipmentId) {
                totalAvailable = eq.getQuantity();
            }
        }

        int bookedCount=0;
        for (Booking b : bookings) {
            if (b.equipmentId == equipmentId &&
                !(b.endDate.before(startDate) || b.startDate.after(endDate))) {
                bookedCount++;
            }
        }

        // Return true if the equipment is available, false if fully booked
        return bookedCount < totalAvailable;
    }

    // Getters for booking details
    public String getBuyerName() {
        return buyerName;
    }

    public int getEquipmentId() {
        return equipmentId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    // Display booking details
    public void displayBookingInfo() {
        System.out.println("Booking Details: ");
        System.out.println("Buyer Name: " + buyerName);
        System.out.println("Equipment ID: " + equipmentId);
        System.out.println("Start Date: " + startDate);
        System.out.println("End Date: " + endDate);
    }
	

}
