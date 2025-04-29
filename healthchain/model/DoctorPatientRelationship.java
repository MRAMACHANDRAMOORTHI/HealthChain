package msr.healthchain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class DoctorPatientRelationship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User doctor;

    @ManyToOne
    private Patient patient;

    private boolean isActive;
    private String accessLevel; // e.g., "VIEW", "EDIT"
}
