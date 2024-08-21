package com.akshai.PatientRecordMs.Service;

import com.akshai.PatientRecordMs.dto.PatientRecordDTO;

import java.util.List;

public interface PatientRecordService {
    PatientRecordDTO createPatientRecord(PatientRecordDTO patientRecordDTO);
    PatientRecordDTO getRecordByPatientRecordId(Long patientRecordId);
    List<PatientRecordDTO> getRecordsByPatientId(Long patientId);
    List<PatientRecordDTO> getRecordsByDoctorId(Long doctorId);
    List<PatientRecordDTO> getRecordsByPatientIdAndDoctorId(Long patientId,Long doctorId);
    List<PatientRecordDTO> getAllRecords();
    PatientRecordDTO updatePatientRecord(Long patientRecordId,PatientRecordDTO patientRecordDTO);
    void deleteRecord(Long id);
}
