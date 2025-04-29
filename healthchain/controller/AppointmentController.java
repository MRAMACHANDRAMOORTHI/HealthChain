package msr.healthchain.controller;

import msr.healthchain.model.Appointment;
import msr.healthchain.service.AppointmentService;
import msr.healthchain.service.MailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.time.LocalDate;

@Controller
public class AppointmentController {

    private final AppointmentService appointmentService;
    private final MailService mailService;

    public AppointmentController(AppointmentService appointmentService, MailService mailService) {
        this.appointmentService = appointmentService;
        this.mailService = mailService;
    }

    @PostMapping("/book-appointment")
    public String bookAppointment(@RequestParam String name,
                                  @RequestParam String email,
                                  @RequestParam String phone,
                                  @RequestParam String department,
                                  @RequestParam String appointment_date,
                                  @RequestParam(required = false) String message,
                                  Model model) {
        LocalDate date = LocalDate.parse(appointment_date);
        Appointment appointment = new Appointment(name, email, phone, department, date, message);
        appointmentService.saveAppointment(appointment);

        // Send confirmation email
        mailService.sendAppointmentConfirmation(email,
                "Appointment Confirmation",
                "Dear " + name + ",\n\nYour appointment has been booked for " + date + ".\n\nThank you!");

        model.addAttribute("appointment", appointment);
        return "appointment-success";
    }
}
