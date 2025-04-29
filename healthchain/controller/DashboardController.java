package msr.healthchain.controller;

import msr.healthchain.model.User;
import msr.healthchain.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {
    private final UserService userService;

    public DashboardController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/dashboard")
    public String showDashboard(Authentication authentication, Model model) {
        if (authentication != null && authentication.isAuthenticated()) {
            String email = authentication.getName();
            User user = userService.getUser(email);
            model.addAttribute("user", user);
        }
        return "dashboard";
    }


    @GetMapping("/bc-exp")
    public String bcExpPage() {
        return "blockchain-explorer";
    }

    @GetMapping("/edit-profile")
    public String profilePage() {
        return "edit-profile";
    }

    @GetMapping("/portfolio")
    public String portfolioPage() {
        return "portfolio-details";
    }
}
