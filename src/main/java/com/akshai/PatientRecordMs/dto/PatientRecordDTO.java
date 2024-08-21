package com.akshai.PatientRecordMs.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PatientRecordDTO {
    private Long id;
    private Long patientId;
    private String diagnosis;
    private String treatment;
    private String medications;
    private Date visitDate;
    private Long doctorId;
    private String doctorNotes;
}
