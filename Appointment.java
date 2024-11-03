import java.util.UUID;

public class Appointment {
    private final String appointmentId;
    private String date;
    private String time;
    private String dermatologist;
    private Patient patient;

    public Appointment(String date, String time, String dermatologist, Patient patient) {
        this.appointmentId = UUID.randomUUID().toString();
        this.date = date;
        this.time = time;
        this.dermatologist = dermatologist;
        this.patient = patient;
    }

    public String getAppointmentId() { return appointmentId; }
    public String getDate() { return date; }
    public String getTime() { return time; }
    public String getDermatologist() { return dermatologist; }
    public Patient getPatient() { return patient; }

    public void setDate(String date) { this.date = date; }
    public void setTime(String time) { this.time = time; }
    public void setDermatologist(String dermatologist) { this.dermatologist = dermatologist; }

    @Override
    public String toString() {
        return String.format("Appointment ID: %s\nDate: %s\nTime: %s\nDermatologist: %s\nPatient: %s",
                appointmentId, date, time, dermatologist, patient);
    }
}
