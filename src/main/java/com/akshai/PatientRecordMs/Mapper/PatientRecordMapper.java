package com.akshai.PatientRecordMs.Mapper;

import com.akshai.PatientRecordMs.Entity.PatientRecord;
import com.akshai.PatientRecordMs.dto.PatientRecordDTO;
import org.mapstruct.Mapper;

@Mapper
public interface PatientRecordMapper {
    PatientRecord toEntity(PatientRecordDTO patientRecordDTO);
    PatientRecordDTO toDTO(PatientRecord patientRecord);
}
