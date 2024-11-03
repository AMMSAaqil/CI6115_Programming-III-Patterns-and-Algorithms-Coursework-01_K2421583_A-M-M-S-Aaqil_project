import java.util.Scanner;

public class Main {
    private static final ClinicService clinicService = new ClinicService();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n==== Aurora Skin Care System ====");
            System.out.println("1. Book an Appointment");
            System.out.println("2. Update an Appointment");
            System.out.println("3. View Appointments by Date");
            System.out.println("4. Search for an Appointment");
            System.out.println("5. Generate Invoice");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> clinicService.bookAppointment(scanner);
                case 2 -> clinicService.updateAppointment(scanner);
                case 3 -> clinicService.viewAppointmentsByDate(scanner);
                case 4 -> clinicService.searchAppointment(scanner);
                case 5 -> clinicService.generateInvoice(scanner);
                case 6 -> exit = true;
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();
    }
}
