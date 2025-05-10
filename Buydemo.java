package custom;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Buydemo {
    private static DateFormat dateFormat;

	public static void main(String[] args) {
        ArrayList<Equipment> equipments = new ArrayList<>();
        ArrayList<Booking> bookings = new ArrayList<>();

        // Adding some initial Equipment (like buses earlier)
        // Add equipment with rental type, price per hour, and availability dates
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        try {
            equipments.add(new Equipment(1, "Tractor", 5, 500, "Full-Time", sdf.parse("01-05-2025"), sdf.parse("01-06-2025")));
            equipments.add(new Equipment(2, "Rotavator", 3, 200, "Part-Time", sdf.parse("01-05-2025"), sdf.parse("10-06-2025")));
            equipments.add(new Equipment(3, "Harvester", 2, 1000, "Full-Time", sdf.parse("01-06-2025"), sdf.parse("01-07-2025")));
        } catch (Exception e) {
            e.printStackTrace();
        }

        int userOption = 1;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Available Equipment:");
        for (Equipment e : equipments) {
            e.displayEquipmentInfo();
        }

        while (true) {
            System.out.println("\nEnter 1 to Book Equipment, 2 to Lend Equipment, 3 to Exit:");
            userOption = scanner.nextInt();

            if (userOption == 1) {
                // Buyer booking flow
                System.out.println("Enter buyer name: ");
                scanner.nextLine(); // Consume the newline
                String buyerName = scanner.nextLine();

                System.out.println("Enter equipment ID: ");
                int equipmentId = scanner.nextInt();

                System.out.println("Enter start date (dd-MM-yyyy): ");
                String startDateInput = scanner.next();

                System.out.println("Enter end date (dd-MM-yyyy): ");
                String endDateInput = scanner.next();

                // Check if the start date is before today's date
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                Date today = new Date();
                try {
                    Date startDate = dateFormat.parse(startDateInput);
                    if (startDate.before(today)){
                    	System.out.println("Invalid date, booking cannot be done.");
                        continue; // Skip the rest of the loop and ask for booking again
                    }

                    // Create a new Booking object and check availability
                    Booking booking = new Booking(buyerName, equipmentId, startDateInput, endDateInput);

                    if (booking.isAvailable(bookings, equipments)) {
                        bookings.add(booking);
                        System.out.println("Your booking is confirmed!");
                    } else {
                        System.out.println("Sorry, this equipment is fully booked for the selected dates.");
                    }
                } catch (Exception e) {
                    System.out.println("Invalid date format. Please enter in dd-MM-yyyy format.");
                }

            } else if (userOption == 2) {
                // Vendor lending flow
                System.out.println("Enter equipment name to lend: ");
                scanner.nextLine(); // Consume the newline
                String equipmentName = scanner.nextLine();

                System.out.println("Enter quantity available: ");
                int quantity = scanner.nextInt();
                System.out.println("Enter rental type (Full-Time/Part-Time): ");
                scanner.nextLine(); // Consume the newline
                String rentalType = scanner.nextLine();

                System.out.println("Enter price per hour (₹): ");
                double pricePerHour = scanner.nextDouble();

                // For Part-Time rental, ask for availability dates
                Date availableFrom = null, availableTo = null;
                if (rentalType.equalsIgnoreCase("Part-Time")) {
                    System.out.println("Enter availability start date (dd-MM-yyyy): ");
                    String fromInput = scanner.next();
                    System.out.println("Enter availability end date (dd-MM-yyyy): ");
                    String toInput = scanner.next();  // Correctly capture the second date

                    try {
                        dateFormat = null;
						availableFrom = dateFormat.parse(fromInput);
                        availableTo = dateFormat.parse(toInput); // Parsing both the dates
                    } catch (Exception e) {
                        System.out.println("Invalid date format. Please enter in dd-MM-yyyy format.");
                        continue; // Skip this iteration and ask again
                    }
                }

                int newId = 0;
				// Auto-generate new equipment IDint newId = equipments.size() + 1;
                equipments.add(new Equipment(newId, equipmentName, quantity, pricePerHour, rentalType, availableFrom, availableTo));

                // Show updated equipment list
                System.out.println("\nUpdated Equipment List:");
                for (Equipment e : equipments) {
                    e.displayEquipmentInfo();
                }

            } else if (userOption == 3) {
                System.out.println("Exiting the system. Thank you!");
                break; // Exit from while loop
            } else {
                System.out.println("Invalid option. Please enter 1, 2, or 3.");
            }
        }

        scanner.close(); // Close scanner after use
    }
}

                    
