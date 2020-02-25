package com.yoan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yoan.model.Lead;

public interface LeadRepository extends JpaRepository<Lead, Integer> {

}
