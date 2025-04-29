package msr.healthchain.service;

import msr.healthchain.model.Appointment;
import msr.healthchain.repository.AppointmentRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;

    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    // Save an appointment
    public Appointment saveAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    // Fetch all appointments from the database
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }
}
