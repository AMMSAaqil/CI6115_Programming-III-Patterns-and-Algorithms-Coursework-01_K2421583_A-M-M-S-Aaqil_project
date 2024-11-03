import java.text.DecimalFormat;

public class InvoiceGenerator {
    private static final double REGISTRATION_FEE = 500.0;
    private static final double TAX_RATE = 0.025;  // 2.5% tax
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public String generateInvoice(Appointment appointment, String treatmentType, double treatmentPrice) {
        if (treatmentPrice <= 0) {
            return "Invalid treatment type or price. Cannot generate invoice.";
        }

        double tax = treatmentPrice * TAX_RATE;
        double total = treatmentPrice + tax + REGISTRATION_FEE;

        StringBuilder invoice = new StringBuilder();
        invoice.append("\n===== Aurora Skin Care Clinic Invoice =====\n");
        invoice.append("Appointment ID: ").append(appointment.getAppointmentId()).append("\n");
        invoice.append("Patient Name: ").append(appointment.getPatient().getName()).append("\n");
        invoice.append("Date: ").append(appointment.getDate()).append(" at ").append(appointment.getTime()).append("\n");
        invoice.append("Dermatologist: ").append(appointment.getDermatologist()).append("\n");
        invoice.append("Treatment: ").append(treatmentType).append("\n");
        invoice.append("------------------------------------------------\n");
        invoice.append("Treatment Cost: LKR ").append(df.format(treatmentPrice)).append("\n");
        invoice.append("Tax (2.5%): LKR ").append(df.format(tax)).append("\n");
        invoice.append("Registration Fee: LKR ").append(df.format(REGISTRATION_FEE)).append("\n");
        invoice.append("------------------------------------------------\n");
        invoice.append("Total Amount Due: LKR ").append(df.format(total)).append("\n");
        invoice.append("============================================\n");

        return invoice.toString();
    }
}
