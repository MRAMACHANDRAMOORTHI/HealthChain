package msr.healthchain.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "doctor_details")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoctorDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // One-to-one link to User (doctor)
    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;

    // Additional doctor-specific details
    private String specialty;
    private int experience;
    private String phone;
}
