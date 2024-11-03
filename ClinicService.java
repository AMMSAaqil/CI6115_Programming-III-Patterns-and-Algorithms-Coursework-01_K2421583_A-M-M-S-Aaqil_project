import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ClinicService {
    private final Map<String, Appointment> appointments = new HashMap<>();
    private final InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
    private static final double REGISTRATION_FEE = 500.0;
    private static final Map<String, Double> TREATMENT_PRICES = Map.of(
            "Acne Treatment", 2750.0,
            "Skin Whitening", 7650.0,
            "Mole Removal", 3850.0,
            "Laser Treatment", 12500.0
    );

    public void bookAppointment(Scanner scanner) {
        System.out.print("Enter Patient NIC: ");
        String nic = scanner.nextLine();
        System.out.print("Enter Patient Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Patient Email: ");
        String email = scanner.nextLine();
        System.out.print("Enter Patient Phone: ");
        String phone = scanner.nextLine();
        Patient patient = new Patient(nic, name, email, phone);

        System.out.print("Enter Appointment Date (yyyy-mm-dd): ");
        String date = scanner.nextLine();
        System.out.print("Enter Appointment Time (e.g., 10:00am): ");
        String time = scanner.nextLine();
        System.out.print("Enter Dermatologist Name: ");
        String dermatologist = scanner.nextLine();

        Appointment appointment = new Appointment(date, time, dermatologist, patient);
        appointments.put(appointment.getAppointmentId(), appointment);
        System.out.println("Appointment booked successfully with ID: " + appointment.getAppointmentId());
    }

    public void updateAppointment(Scanner scanner) {
        System.out.print("Enter Appointment ID to update: ");
        String id = scanner.nextLine();
        Appointment appointment = appointments.get(id);

        if (appointment != null) {
            System.out.print("Enter new Date (yyyy-mm-dd): ");
            appointment.setDate(scanner.nextLine());
            System.out.print("Enter new Time: ");
            appointment.setTime(scanner.nextLine());
            System.out.print("Enter new Dermatologist: ");
            appointment.setDermatologist(scanner.nextLine());
            System.out.println("Appointment updated successfully.");
        } else {
            System.out.println("Appointment ID not found.");
        }
    }

    public void viewAppointmentsByDate(Scanner scanner) {
        System.out.print("Enter Date (yyyy-mm-dd): ");
        String date = scanner.nextLine();

        appointments.values().stream()
                .filter(appointment -> appointment.getDate().equals(date))
                .forEach(System.out::println);
    }

    public void searchAppointment(Scanner scanner) {
        System.out.print("Search by Patient Name or Appointment ID: ");
        String query = scanner.nextLine();

        appointments.values().stream()
                .filter(appointment -> appointment.getPatient().getName().equalsIgnoreCase(query)
                        || appointment.getAppointmentId().equals(query))
                .forEach(System.out::println);
    }

    public void generateInvoice(Scanner scanner) {
        System.out.print("Enter Appointment ID for Invoice: ");
        String id = scanner.nextLine();
        Appointment appointment = appointments.get(id);

        if (appointment != null) {
            System.out.print("Enter Treatment Type (e.g., Acne Treatment): ");
            String treatment = scanner.nextLine();
            Double price = TREATMENT_PRICES.get(treatment);

            if (price != null) {
                String invoice = invoiceGenerator.generateInvoice(appointment, treatment, price);
                System.out.println(invoice);
            } else {
                System.out.println("Invalid treatment type. Please try again.");
            }
        } else {
            System.out.println("Appointment ID not found.");
        }
    }
}
