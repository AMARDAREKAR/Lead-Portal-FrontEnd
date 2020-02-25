package com.yoan.service;

import java.security.Principal;

import org.springframework.http.ResponseEntity;

import com.yoan.model.Asset;
import com.yoan.model.Campaign;

public interface CampaignService {
	
	Iterable<Campaign> getAllCampaigns();
	ResponseEntity<Campaign> addCampaign(Campaign campaign,Principal principal);
	ResponseEntity<Campaign> getCampaignById(int campaignId);
	ResponseEntity<Campaign> updateCampaign(Campaign campaign,Principal principal);
	void deleteCampaignById(int campaignId, Principal principal);
	
	
	ResponseEntity<Asset> addAsset(Asset asset,Principal principal);
	Iterable<Asset> getAllAssets();
	
}
