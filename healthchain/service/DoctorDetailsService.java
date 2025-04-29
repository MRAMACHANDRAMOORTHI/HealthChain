package msr.healthchain.service;

import msr.healthchain.model.DoctorDetails;
import msr.healthchain.model.User;
import msr.healthchain.repository.DoctorDetailsRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorDetailsService {
    private final DoctorDetailsRepository doctorDetailsRepository;

    public DoctorDetailsService(DoctorDetailsRepository doctorDetailsRepository) {
        this.doctorDetailsRepository = doctorDetailsRepository;
    }

    // Fetch doctor details by the associated user's email
    public Optional<DoctorDetails> getDoctorDetailsByUser(User user) {
        return doctorDetailsRepository.findByUser_Email(user.getEmail());
    }

    // Fetch all doctor details
    public List<DoctorDetails> getAllDoctorDetails() {
        return doctorDetailsRepository.findAll();
    }

    // Save or update doctor details
    public DoctorDetails saveDoctorDetails(DoctorDetails details) {
        return doctorDetailsRepository.save(details);
    }
}
