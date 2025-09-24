import java.util.Scanner;

// Interface
public interface IRoadsConstructed {
    String getCity();
    int getTotalRoadsConstructed();
}

// Abstract class
abstract class RoadsConstructed implements IRoadsConstructed {
    protected String city;
    protected int totalRoadsConstructed;

    public RoadsConstructed(String city, int totalRoadsConstructed) {
        this.city = city;
        this.totalRoadsConstructed = totalRoadsConstructed;
    }

    @Override
    public String getCity() {
        return city;
    }

    @Override
    public int getTotalRoadsConstructed() {
        return totalRoadsConstructed;
    }
}

// Subclass
class RoadConstructionReport extends RoadsConstructed {
    public RoadConstructionReport(String city, int totalRoadsConstructed) {
        super(city, totalRoadsConstructed);
    }

    public void printRoadsConstructedReport() {
        System.out.println("\nROAD CONSTRUCTION REPORT");
        System.out.println("************************");
        System.out.println("CITY: " + getCity());
        System.out.println("ROADS CONSTRUCTED: " + getTotalRoadsConstructed());
        System.out.println("************************");
    }
}

