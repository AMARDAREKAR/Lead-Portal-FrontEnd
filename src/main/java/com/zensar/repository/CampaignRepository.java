package com.zensar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zensar.model.Campaign;

public interface CampaignRepository extends JpaRepository<Campaign, Integer> {

}
