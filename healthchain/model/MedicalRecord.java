package msr.healthchain.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "medical_record")
public class MedicalRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String patientEmail;

    @Column(nullable = true)
    private String doctorEmail;

    @Column(nullable = false)
    private String recordName;

    @Column(nullable = false)
    private String recordUrl; // Path to the stored file

    @Column(nullable = false)
    private LocalDate uploadDate;

    public MedicalRecord() {}

    public MedicalRecord(String patientEmail, String doctorEmail, String recordName, String recordUrl, LocalDate uploadDate) {
        this.patientEmail = patientEmail;
        this.doctorEmail = doctorEmail;
        this.recordName = recordName;
        this.recordUrl = recordUrl;
        this.uploadDate = uploadDate;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public String getPatientEmail() {
        return patientEmail;
    }

    public void setPatientEmail(String patientEmail) {
        this.patientEmail = patientEmail;
    }


    public String getDoctorEmail() {
        return doctorEmail;
    }

    public void setDoctorEmail(String doctorEmail) {
        this.doctorEmail = doctorEmail;
    }

    public String getRecordName() {
        return recordName;
    }

    public void setRecordName(String recordName) {
        this.recordName = recordName;
    }

    public String getRecordUrl() {
        return recordUrl;
    }

    public void setRecordUrl(String recordUrl) {
        this.recordUrl = recordUrl;
    }

    public LocalDate getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(LocalDate uploadDate) {
        this.uploadDate = uploadDate;
    }
}
