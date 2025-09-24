public class Property {
    private String propertyId;
    private String address;
    private double rentalAmount;
    private String agentName;

    public Property(String propertyId, String address, double rentalAmount, String agentName) {
        this.propertyId = propertyId;
        this.address = address;
        this.rentalAmount = rentalAmount;
        this.agentName = agentName;
    }

    // Getters & Setters
    public String getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(String propertyId) {
        this.propertyId = propertyId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getRentalAmount() {
        return rentalAmount;
    }

    public void setRentalAmount(double rentalAmount) {
        this.rentalAmount = rentalAmount;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    @Override
    public String toString() {
        return "Property ID: " + propertyId +
                "\nAddress: " + address +
                "\nRental Amount: R" + rentalAmount +
                "\nAgent: " + agentName;
    }
}
