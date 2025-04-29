package msr.healthchain.controller;

import msr.healthchain.model.Patient;
import msr.healthchain.service.PatientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PatientController {

    @GetMapping("/patient")
    public String patient(Model model) {
        return "patient-profile";
    }
}
