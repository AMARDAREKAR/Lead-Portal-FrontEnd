package com.zensar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zensar.model.Prospect;

public interface ProspectRepository extends JpaRepository<Prospect, Integer> {

}
