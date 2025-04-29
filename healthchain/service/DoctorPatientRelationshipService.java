package msr.healthchain.service;

import msr.healthchain.model.DoctorPatientRelationship;
import msr.healthchain.model.User;
import msr.healthchain.repository.DoctorPatientRelationshipRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DoctorPatientRelationshipService {
    private final DoctorPatientRelationshipRepository repository;

    public DoctorPatientRelationshipService(DoctorPatientRelationshipRepository repository) {
        this.repository = repository;
    }

    public List<DoctorPatientRelationship> getRelationshipsForDoctor(User doctor) {
        return repository.findByDoctor(doctor);
    }
}
