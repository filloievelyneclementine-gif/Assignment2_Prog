import java.util.Scanner;

// Main class
public class RunApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the city for road construction: ");
        String city = scanner.nextLine();

        System.out.print("Enter the total road construction for " + city + ": ");
        int totalRoads = scanner.nextInt();

        RoadConstructionReport report = new RoadConstructionReport(city, totalRoads);
        report.printRoadsConstructedReport();
    }
}
