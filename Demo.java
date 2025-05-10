package custom;

public class Demo{
    private int buyerId;
    private String name;
    private String contactNumber;
    private String email;
    private String address;

    // Constructor
    public Demo(int buyerId, String name, String contactNumber, String email, String address) {
        this.buyerId = buyerId;
        this.name = name;
        this.contactNumber = contactNumber;
        this.email = email;
        this.address = address;
    }

    // Getters
    public int getBuyerId() {
        return buyerId;
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
    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // Display method
    public void displayBuyerInfo() {
        System.out.println("Buyer ID: " + buyerId +
                           ", Name: " + name +
                           ", Contact: " + contactNumber +
                           ", Email: " + email +
                           ", Address: " + address);
    }

   
}



