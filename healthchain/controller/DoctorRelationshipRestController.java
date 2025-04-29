package msr.healthchain.controller;

import msr.healthchain.model.DoctorPatientRelationship;
import msr.healthchain.model.User;
import msr.healthchain.service.DoctorPatientRelationshipService;
import msr.healthchain.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class DoctorRelationshipRestController {

    private final UserService userService;
    private final DoctorPatientRelationshipService relationshipService;

    public DoctorRelationshipRestController(UserService userService, DoctorPatientRelationshipService relationshipService) {
        this.userService = userService;
        this.relationshipService = relationshipService;
    }

    @GetMapping("/api/doctor/relationships")
    public List<DoctorPatientRelationship> getDoctorRelationships(Authentication authentication) {
        String email = authentication.getName();
        User doctor = userService.getUser(email);
        return relationshipService.getRelationshipsForDoctor(doctor);
    }
}
