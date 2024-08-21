package com.akshai.PatientRecordMs.Repository;

import com.akshai.PatientRecordMs.Entity.PatientRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PatientRecordRepository extends JpaRepository<PatientRecord,Long> {
    List<PatientRecord> findByPatientId(Long patientId);
    List<PatientRecord> findByPatientIdAndDoctorId(Long patientId,Long doctorId);
}
