package com.yoan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yoan.model.Campaign;

public interface CampaignRepository extends JpaRepository<Campaign, Integer> {

}
