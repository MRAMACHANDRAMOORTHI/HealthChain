package msr.healthchain.repository;

import msr.healthchain.model.DoctorPatientRelationship;
import msr.healthchain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DoctorPatientRelationshipRepository extends JpaRepository<DoctorPatientRelationship, Long> {
    List<DoctorPatientRelationship> findByDoctor(User doctor);
}
