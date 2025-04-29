package msr.healthchain.repository;

import msr.healthchain.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    // JpaRepository already provides findAll() for getting all appointments
}
