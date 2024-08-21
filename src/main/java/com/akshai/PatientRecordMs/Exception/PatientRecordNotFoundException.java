package com.akshai.PatientRecordMs.Exception;

public class PatientRecordNotFoundException extends RuntimeException {
    public PatientRecordNotFoundException(String message){
        super(message);
    }
}
