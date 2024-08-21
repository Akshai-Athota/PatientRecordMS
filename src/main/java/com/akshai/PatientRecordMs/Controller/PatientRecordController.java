package com.akshai.PatientRecordMs.Controller;

import com.akshai.PatientRecordMs.Service.PatientRecordService;
import com.akshai.PatientRecordMs.dto.PatientRecordDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/patientRecord")
public class PatientRecordController {

    private PatientRecordService patientRecordService;

    @PostMapping
    ResponseEntity<PatientRecordDTO> createPatientRecord(@RequestBody  PatientRecordDTO patientRecordDTO){
        return ResponseEntity.ok(patientRecordService.createPatientRecord(patientRecordDTO));
    }

    @GetMapping("/{patientRecordId}")
    ResponseEntity<PatientRecordDTO> getPatientRecordById(@PathVariable(name="patientRecordId") Long patientRecordId){
        return ResponseEntity.ok(patientRecordService.getRecordByPatientRecordId(patientRecordId));
    }

    @GetMapping
    ResponseEntity<List<PatientRecordDTO>> getPatientRecordByPatientId(@RequestParam Long patientId){
        return ResponseEntity.ok(patientRecordService.getRecordsByPatientId(patientId));
    }

    @GetMapping
    ResponseEntity<List<PatientRecordDTO>> getPatientRecordByDoctorId(@RequestParam Long doctorId){
        return ResponseEntity.ok(patientRecordService.getRecordsByDoctorId(doctorId));
    }

    @GetMapping
    ResponseEntity<List<PatientRecordDTO>> getPatientRecordByPatientIdAndDoctorId(@RequestParam(name="patientId") Long patientId,
                                                                                  @RequestParam(name="doctorId") Long doctorId){
        return ResponseEntity.ok(patientRecordService.getRecordsByPatientIdAndDoctorId(patientId,doctorId));
    }

    @GetMapping
    ResponseEntity<List<PatientRecordDTO>> getAllPatientRecord(){
        return ResponseEntity.ok(patientRecordService.getAllRecords());
    }

    @PutMapping("/{patientRecordId}")
    ResponseEntity<PatientRecordDTO> updatePatientRecordById(@PathVariable(name="patientRecordId") Long patientRecordId,
                                                         @RequestBody  PatientRecordDTO patientRecordDTO){
        return ResponseEntity.ok(patientRecordService.updatePatientRecord(patientRecordId,patientRecordDTO));
    }

    @DeleteMapping("/{patientRecordId}")
    ResponseEntity deletePatientRecordById(@PathVariable(name="patientRecordId") Long patientRecordId){
        patientRecordService.deleteRecord(patientRecordId);
        return ResponseEntity.ok().build();
    }
}
