package custom;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Buying {
    String buyerName;
    int equipmentId;
    Date startDate;
    Date endDate;

    // Constructor
    public Buying() {
        try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Enter name of buyer: ");
			buyerName = scanner.next();

			System.out.println("Enter equipment ID: ");
			equipmentId = scanner.nextInt();

			System.out.println("Enter start date (dd-MM-yyyy): ");
			String startInput = scanner.next();

			System.out.println("Enter end date (dd-MM-yyyy): ");
			String endInput = scanner.next();

			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			try {
			    startDate = dateFormat.parse(startInput);
			    endDate = dateFormat.parse(endInput);
			} catch (ParseException e) {
			    e.printStackTrace();
			}
		}
    }

    // Check availability
    public boolean isAvailable(ArrayList<Buying> bookings, ArrayList<Equipment> equipments) {
        int totalAvailable = 0;

        // Find total available quantity for the given equipmentId
        for (Equipment eq : equipments) {
            if (eq.getEquipmentId() == equipmentId) {
                totalAvailable = eq.getQuantity();
            }
        }

        int bookedCount = 0;

        // Check if the equipment is already booked for the given dates
        for (Buying b : bookings) {
            if (b.equipmentId == equipmentId &&
                !(b.endDate.before(startDate) || b.startDate.after(endDate))) {
                bookedCount++;
            }
        }

        // Return true if the booked count is less than total available, else false
        return bookedCount < totalAvailable;
    }
}
