import java.util.ArrayList;

public class PropertyReport {

    // Print a single property
    public void printProperty(Property property) {
        if (property != null) {
            System.out.println("---------------------------");
            System.out.println(property);
            System.out.println("PROPERTY" +1);
            System.out.println("---------------------------");
        } else {
            System.out.println("Property not found!");
        }
    }

    // Print all properties
    public void printAllProperties(ArrayList<Property> properties) {
        if (properties.isEmpty()) {
            System.out.println("No properties available.");
        } else {
            for (Property p : properties) {
                printProperty(p);
            }
        }
    }
}
