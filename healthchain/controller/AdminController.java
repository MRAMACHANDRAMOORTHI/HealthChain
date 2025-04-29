package msr.healthchain.controller;

import msr.healthchain.model.Appointment;
import msr.healthchain.model.DoctorDetails;
import msr.healthchain.model.Patient;
import msr.healthchain.service.AppointmentService;
import msr.healthchain.service.DoctorDetailsService;
import msr.healthchain.service.PatientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@Controller
public class AdminController {

    private final PatientService patientService;
    private final DoctorDetailsService doctorDetailsService;
    private final AppointmentService appointmentService;

    public AdminController(PatientService patientService,
                           DoctorDetailsService doctorDetailsService,
                           AppointmentService appointmentService) {
        this.patientService = patientService;
        this.doctorDetailsService = doctorDetailsService;
        this.appointmentService = appointmentService;
    }

    @GetMapping("/admin/dashboard")
    public String showAdminDashboard(Model model) {
        // Fetch all data from the database
        List<Patient> patients = patientService.getAllPatients();
        List<DoctorDetails> doctors = doctorDetailsService.getAllDoctorDetails();
        List<Appointment> appointments = appointmentService.getAllAppointments();

        // Add to the model so that they can be displayed in the view
        model.addAttribute("patients", patients);
        model.addAttribute("doctors", doctors);
        model.addAttribute("appointments", appointments);

        // Dummy blockchain data (or real if available)
        model.addAttribute("currentBlock", 854392);
        model.addAttribute("txCount", 2431);

        return "admin-dashboard"; // Renders admin-dashboard.html
    }
}
