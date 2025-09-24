import java.util.ArrayList;

public class PropertyService {
    private ArrayList<Property> properties = new ArrayList<>();

    // Add property
    public void addProperty(Property property) {
        properties.add(property);
    }

    // Find by ID
    public Property findPropertyById(String propertyId) {
        for (Property p : properties) {
            if (p.getPropertyId().equals(propertyId)) {
                return p;
            }
        }
        return null;
    }

    // Update property
    public boolean updateProperty(String propertyId, String address, double rental, String agent) {
        Property property = findPropertyById(propertyId);
        if (property != null) {
            property.setAddress(address);
            property.setRentalAmount(rental);
            property.setAgentName(agent);
            return true;
        }
        return false;
    }

    // Delete property
    public boolean deleteProperty(String propertyId) {
        Property property = findPropertyById(propertyId);
        if (property != null) {
            properties.remove(property);
            return true;
        }
        return false;
    }

    // Return all properties
    public ArrayList<Property> getAllProperties() {
        return properties;
    }
}
