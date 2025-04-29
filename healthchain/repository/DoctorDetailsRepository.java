package msr.healthchain.repository;

import msr.healthchain.model.DoctorDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface DoctorDetailsRepository extends JpaRepository<DoctorDetails, Long> {
    // Find DoctorDetails by the email of the associated user
    Optional<DoctorDetails> findByUser_Email(String email);
}
