package msr.healthchain.service;

import msr.healthchain.model.MedicalRecord;
import msr.healthchain.repository.MedicalRecordRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalRecordService {

    private final MedicalRecordRepository medicalRecordRepository;

    public MedicalRecordService(MedicalRecordRepository medicalRecordRepository) {
        this.medicalRecordRepository = medicalRecordRepository;
    }

    // Save a new medical record
    public MedicalRecord saveMedicalRecord(MedicalRecord record) {
        return medicalRecordRepository.save(record);
    }

    // Get medical records for a patient
    public List<MedicalRecord> getRecordsForPatient(String patientEmail) {
        return medicalRecordRepository.findByPatientEmail(patientEmail);
    }

    // Get medical records for a doctor
    public List<MedicalRecord> getRecordsForDoctor(String doctorEmail) {
        return medicalRecordRepository.findByDoctorEmail(doctorEmail);
    }
}
