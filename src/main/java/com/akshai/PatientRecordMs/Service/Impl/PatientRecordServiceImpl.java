package com.akshai.PatientRecordMs.Service.Impl;

import com.akshai.PatientRecordMs.Entity.PatientRecord;
import com.akshai.PatientRecordMs.Exception.PatientRecordNotFoundException;
import com.akshai.PatientRecordMs.Mapper.PatientRecordMapper;
import com.akshai.PatientRecordMs.Repository.PatientRecordRepository;
import com.akshai.PatientRecordMs.Service.PatientRecordService;
import com.akshai.PatientRecordMs.dto.PatientRecordDTO;
import lombok.RequiredArgsConstructor;
import org.hibernate.query.sqm.PathElementException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class PatientRecordServiceImpl implements PatientRecordService {
    private PatientRecordRepository patientRecordRepository;
    private PatientRecordMapper patientRecordMapper;

    @Override
    public PatientRecordDTO createPatientRecord(PatientRecordDTO patientRecordDTO) {
        return patientRecordMapper.toDTO
                (patientRecordRepository.save
                        (patientRecordMapper.toEntity(patientRecordDTO)));
    }

    @Override
    public PatientRecordDTO getRecordByPatientRecordId(Long patientRecordId) {
        return patientRecordRepository.findById(patientRecordId)
                .map(patientRecordMapper::toDTO)
                .orElseThrow(()->new PathElementException("no record with given id"));
    }

    @Override
    public List<PatientRecordDTO> getRecordsByPatientId(Long patientId) {
        return  patientRecordRepository.findByPatientId(patientId).stream()
                .map(x->patientRecordMapper.toDTO(x))
                .collect(Collectors.toList());
    }

    @Override
    public List<PatientRecordDTO> getRecordsByDoctorId(Long doctorId) {
        return  patientRecordRepository.findByPatientId(doctorId).stream()
                .map(x->patientRecordMapper.toDTO(x))
                .collect(Collectors.toList());
    }

    @Override
    public List<PatientRecordDTO> getRecordsByPatientIdAndDoctorId(Long patientId,Long doctorId) {
        return patientRecordRepository.findByPatientIdAndDoctorId(patientId,doctorId).stream()
                .map(x->patientRecordMapper.toDTO(x))
                .collect(Collectors.toList());
    }

    @Override
    public List<PatientRecordDTO> getAllRecords() {
        return patientRecordRepository.findAll().stream()
                .map(patientRecordMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PatientRecordDTO updatePatientRecord(Long patientRecordId, PatientRecordDTO patientRecordDTO) {
        PatientRecord patientRecord=patientRecordRepository.findById(patientRecordId)
                .orElseThrow(()->new PatientRecordNotFoundException("patient record not found with given id"));

        patientRecord.setPatientId(patientRecordDTO.getPatientId());
        patientRecord.setDiagnosis(patientRecordDTO.getDiagnosis());
        patientRecord.setTreatment(patientRecordDTO.getTreatment());
        patientRecord.setMedications(patientRecordDTO.getMedications());
        patientRecord.setVisitDate(patientRecordDTO.getVisitDate());
        patientRecord.setDoctorNotes(patientRecordDTO.getDoctorNotes());
        patientRecord.setDoctorId(patientRecordDTO.getDoctorId());

        PatientRecord updatedRecord = patientRecordRepository.save(patientRecord);
        return patientRecordMapper.toDTO(updatedRecord);
    }

    @Override
    public void deleteRecord(Long id) {
        patientRecordRepository.deleteById(id);
    }
}
