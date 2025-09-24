import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PropertyServiceTest {

    private PropertyService service;

    @BeforeEach
    void setUp() {
        service = new PropertyService();
        // Add one sample property
        service.addProperty(new Property("P101", "123 Main Street", 5000, "Alice"));
    }

    // 1. SearchProperty_ReturnsProperty
    @Test
    void SearchProperty_ReturnsProperty() {
        Property found = service.findPropertyById("P101");
        assertNotNull(found, "Property should be found");
        assertEquals("123 Main Street", found.getAddress());
    }

    // 2. SearchProperty_NotFound
    @Test
    void SearchProperty_NotFound() {
        Property found = service.findPropertyById("P999");
        assertNull(found, "Should return null if property not found");
    }

    // 3. UpdateProperty_ReturnsSuccess
    @Test
    void UpdateProperty_ReturnsSuccess() {
        boolean updated = service.updateProperty("P101", "456 Oak Avenue", 6000, "Bob");
        assertTrue(updated, "Update should succeed");

        Property updatedProp = service.findPropertyById("P101");
        assertEquals("456 Oak Avenue", updatedProp.getAddress());
        assertEquals(6000, updatedProp.getRentalAmount());
        assertEquals("Bob", updatedProp.getAgentName());
    }

    // 4. DeleteProperty_ReturnsSuccess
    @Test
    void DeleteProperty_ReturnsSuccess() {
        boolean deleted = service.deleteProperty("P101");
        assertTrue(deleted, "Delete should succeed");
        assertNull(service.findPropertyById("P101"), "Deleted property should no longer exist");
    }

    // 5. PropertyAmountValidation_AmountIsValid
    @Test
    void PropertyAmountValidation_AmountIsValid() {
        Property valid = new Property("P102", "789 Pine Road", 7500, "Charlie");
        assertTrue(valid.getRentalAmount() > 0, "Rental amount should be positive");
    }

    // 6. PropertyAmountValidation_AmountInValid
    @Test
    void PropertyAmountValidation_AmountInValid() {
        Property invalid = new Property("P103", "987 Elm Street", -500, "David");
        assertFalse(invalid.getRentalAmount() > 0, "Negative rental should be invalid");
    }
}
