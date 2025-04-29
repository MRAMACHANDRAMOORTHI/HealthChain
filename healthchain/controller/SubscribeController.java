package msr.healthchain.controller;

import msr.healthchain.service.MailService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SubscribeController {

    private final MailService mailService;

    public SubscribeController(MailService mailService) {
        this.mailService = mailService;
    }

    @PostMapping("/subscribe")
    public String subscribe(@RequestParam("email") String email) {
        // Here, you could also save the subscriber's email in a database if needed.
        // For now, we'll send a confirmation email.
        mailService.sendSubscriptionConfirmation(
                email,
                "Subscription Confirmed",
                "Dear subscriber,\n\nThank you for subscribing to HealthChain updates!\n\nBest regards,\nHealthChain Team"
        );
        return "redirect:/?subscribed=true";
    }
}
