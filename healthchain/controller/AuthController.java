package msr.healthchain.controller;

import msr.healthchain.model.Patient;
import msr.healthchain.model.User;
import msr.healthchain.service.PatientService;
import msr.healthchain.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {

    private final UserService userService;
    private final PatientService patientService;

    public AuthController(UserService userService, PatientService patientService) {
        this.userService = userService;
        this.patientService = patientService;
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @GetMapping("/signup")
    public String showSignupPage() {
        return "signup";
    }

    @PostMapping("/auth/signup")
    public String registerUser(@RequestParam String email,
                               @RequestParam String password,
                               @RequestParam String role,
                               @RequestParam(required = false) String name,
                               @RequestParam(required = false) Integer age,
                               @RequestParam(required = false) String gender,
                               @RequestParam(required = false) String condition,
                               @RequestParam(required = false) String specialty,
                               @RequestParam(required = false) Integer experience,
                               @RequestParam(required = false) String phone,
                               Model model) {
        try {
            userService.registerUser(email, password, User.Role.valueOf(role));
            if (User.Role.valueOf(role) == User.Role.PATIENT && name != null && !name.isEmpty()) {
                Patient patient = new Patient(name, age != null ? age : 0, gender, condition);
                patientService.savePatient(patient);
            }
            // For DOCTOR, let them update details later via the profile page.
            return "redirect:/login?success";
        } catch(Exception e) {
            model.addAttribute("error", e.getMessage());
            return "signup";
        }
    }
}
