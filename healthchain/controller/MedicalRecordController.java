package msr.healthchain.controller;

import msr.healthchain.model.MedicalRecord;
import msr.healthchain.service.MedicalRecordService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/records")
public class MedicalRecordController {

    private final MedicalRecordService medicalRecordService;

    public MedicalRecordController(MedicalRecordService medicalRecordService) {
        this.medicalRecordService = medicalRecordService;
    }

    // Display records based on user role (Doctor or Patient)
    @GetMapping
    public String getRecords(Model model, Authentication authentication) {
        String email = authentication.getName();
        Collection<? extends GrantedAuthority> roles = authentication.getAuthorities();

        List<MedicalRecord> records;
        if (roles.stream().anyMatch(role -> role.getAuthority().equals("ROLE_DOCTOR"))) {
            records = medicalRecordService.getRecordsForDoctor(email);
        } else {
            records = medicalRecordService.getRecordsForPatient(email);
        }

        model.addAttribute("records", records);
        return "records"; // Renders records.html
    }

    // Show the upload form
    @GetMapping("/upload-record")
    public String showUploadForm() {
        return "upload-record";
    }

    // Handle file upload with PDF support
    @PostMapping("/upload")
    public String uploadRecord(@RequestParam("record") MultipartFile file,
                               Authentication authentication) {
        if (file.isEmpty()) {
            return "records";
        }

        try {
            String uploadDir = "C:/HealthChain/uploads/";
            File uploadPath = new File(uploadDir);
            if (!uploadPath.exists()) {
                uploadPath.mkdirs();
            }

            String filePath = uploadDir + file.getOriginalFilename();
            file.transferTo(new File(filePath));

            MedicalRecord record = new MedicalRecord(authentication.getName(), null, file.getOriginalFilename(), filePath, LocalDate.now());
            medicalRecordService.saveMedicalRecord(record);
            return "records";
        } catch (IOException e) {
            return "records";
        }
    }
}
