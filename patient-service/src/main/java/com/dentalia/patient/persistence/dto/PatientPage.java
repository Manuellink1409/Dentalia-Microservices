package com.dentalia.patient.persistence.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PatientPage<T> {
    private List<T> patientList;
    private int pageNumber;
    private int pageSize;
    private int totalPages;
    private boolean isFirst;
    private boolean isLast;
}
