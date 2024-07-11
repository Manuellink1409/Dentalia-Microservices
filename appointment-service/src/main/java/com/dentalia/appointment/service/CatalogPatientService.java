package com.dentalia.appointment.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "dentalia-patient")
public interface CatalogPatientService {

    @GetMapping("/patient/{productId}/exists")
    boolean patientExists(@PathVariable("productId") Long productId);

}