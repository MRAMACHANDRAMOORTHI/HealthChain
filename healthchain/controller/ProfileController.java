package msr.healthchain.controller;

import msr.healthchain.model.DoctorDetails;
import msr.healthchain.model.Patient;
import msr.healthchain.model.User;
import msr.healthchain.service.DoctorDetailsService;
import msr.healthchain.service.PatientService;
import msr.healthchain.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
public class ProfileController {

    private final UserService userService;
    private final PatientService patientService;
    private final DoctorDetailsService doctorDetailsService;

    public ProfileController(UserService userService, PatientService patientService, DoctorDetailsService doctorDetailsService) {
        this.userService = userService;
        this.patientService = patientService;
        this.doctorDetailsService = doctorDetailsService;
    }

    @GetMapping("/profile")
    public String viewUserProfile(Model model, Principal principal) {
        String email = principal.getName();
        User user = userService.findByEmail(email);
        UserDetails userDetails = userService.getByUserId(user.getId());

        model.addAttribute("user", user);
        model.addAttribute("userDetails", userDetails); // might be null

        return "user-profile";
    }


//    @PostMapping("/profile/update")
//    public String updateProfile(Authentication authentication,
//                                @RequestParam String email,
//                                @RequestParam String password,
//                                @RequestParam(required = false) String specialty,
//                                @RequestParam(required = false) Integer experience,
//                                @RequestParam(required = false) String phone,
//                                Model model) {
//        User user = userService.getUser(authentication.getName());
//        user.setEmail(email);
//        user.setPassword(password); // (Ensure to encode the password in production!)
//        // Here, you might need to implement an update method in UserService; for now, we re-save.
//        userService.registerUser(email, password, user.getRole());
//        if (user.getRole() == User.Role.DOCTOR) {
//            DoctorDetails details = doctorDetailsService.getDoctorDetailsByUser(user).orElse(new DoctorDetails());
//            details.setUser(user);
//            details.setSpecialty(specialty);
//            details.setExperience(experience != null ? experience : 0);
//            details.setPhone(phone);
//            doctorDetailsService.saveDoctorDetails(details);
//        }
//        model.addAttribute("user", user);
//        return "edit-profile";
//    }
}
