package com.zensar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zensar.model.Lead;

public interface LeadRepository extends JpaRepository<Lead, Integer> {

}
