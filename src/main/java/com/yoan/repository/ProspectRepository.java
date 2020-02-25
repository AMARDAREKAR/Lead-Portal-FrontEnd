package com.yoan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yoan.model.Prospect;

public interface ProspectRepository extends JpaRepository<Prospect, Integer> {

}
