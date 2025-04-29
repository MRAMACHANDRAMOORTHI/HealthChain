package msr.healthchain.controller;

import msr.healthchain.model.DoctorPatientRelationship;
import msr.healthchain.model.User;
import msr.healthchain.service.DoctorPatientRelationshipService;
import msr.healthchain.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@Controller
public class DoctorController {

    private final UserService userService;
    private final DoctorPatientRelationshipService relationshipService;

    public DoctorController(UserService userService, DoctorPatientRelationshipService relationshipService) {
        this.userService = userService;
        this.relationshipService = relationshipService;
    }

    @GetMapping("/doctor/dashboard")
    public String showDoctorDashboard(Model model, Authentication authentication) {
        String email = authentication.getName();
        User doctor = userService.getUser(email);
        List<DoctorPatientRelationship> relationships = relationshipService.getRelationshipsForDoctor(doctor);
        model.addAttribute("doctor", doctor);
        model.addAttribute("relationships", relationships);
        return "doctor-dashboard";
    }
}
