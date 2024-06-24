package com.pullstackdeveloper.leadform.service;

import com.pullstackdeveloper.leadform.dto.LeadDTO;
import com.pullstackdeveloper.leadform.model.Lead;
import com.pullstackdeveloper.leadform.repository.LeadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeadService {

    @Autowired
    private LeadRepository leadRepository;

    public Lead saveLead(LeadDTO leadDTO) {
        Lead lead = new Lead();
        lead.setName(leadDTO.getName());
        lead.setEmail(leadDTO.getEmail());
        lead.setMessage(leadDTO.getMessage());
        return leadRepository.save(lead);
    }
}