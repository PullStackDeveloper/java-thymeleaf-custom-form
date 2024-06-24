package com.pullstackdeveloper.leadform.repository;

import com.pullstackdeveloper.leadform.model.Lead;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeadRepository extends JpaRepository<Lead, Long> {}
