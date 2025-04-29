package msr.healthchain.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String phone;
    private String department;
    private LocalDate appointmentDate;

    @Column(length = 1024)
    private String message;

    public Appointment() { }

    public Appointment(String name, String email, String phone, String department, LocalDate appointmentDate, String message) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.department = department;
        this.appointmentDate = appointmentDate;
        this.message = message;
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }
    public LocalDate getAppointmentDate() { return appointmentDate; }
    public void setAppointmentDate(LocalDate appointmentDate) { this.appointmentDate = appointmentDate; }
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
}
