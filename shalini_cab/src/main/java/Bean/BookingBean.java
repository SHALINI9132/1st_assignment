package Bean;

public class BookingBean {
    private String username;
    private String phoneNumber;
    private String pickupLocation;
    private String dropLocation;
    private String cab;
    private int distance;

    // Getters and Setters
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getPickupLocation() { return pickupLocation; }
    public void setPickupLocation(String pickupLocation) { this.pickupLocation = pickupLocation; }

    public String getDropLocation() { return dropLocation; }
    public void setDropLocation(String dropLocation) { this.dropLocation = dropLocation; }

    public String getCab() { return cab; }
    public void setCab(String cab) { this.cab = cab; }

    public int getDistance() { return distance; }
    public void setDistance(int distance) { this.distance = distance; }
}
