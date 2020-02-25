package com.yoan.serviceImpl;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.yoan.model.Asset;
import com.yoan.model.Campaign;
import com.yoan.repository.AssetRepository;
import com.yoan.repository.CampaignRepository;
import com.yoan.service.CampaignService;

@Service
public class CampaignServiceImpl implements CampaignService {

	@Autowired
	private CampaignRepository campaignRepository;
	@Autowired
	private AssetRepository assetRepository;

	@Override
	public List<Campaign> getAllCampaigns() {
		return campaignRepository.findAll();
	}
	
	@Override
	public List<Asset> getAllAssets() {
		return assetRepository.findAll();
	}
	
	@Override
	public ResponseEntity<Campaign> getCampaignById(int campaignId) {
		if (campaignRepository.existsById(campaignId))
			return new ResponseEntity<Campaign>(campaignRepository.findById(campaignId).get(), HttpStatus.OK);
		else
			return new ResponseEntity<Campaign>(HttpStatus.NOT_FOUND);
	}
	
	@Override
	public void deleteCampaignById(int campaignId,Principal principal) {
		if (campaignRepository.existsById(campaignId))
		{
			campaignRepository.deleteById(campaignId);
		}
	}
	
	@Override
	public ResponseEntity<Campaign> addCampaign(Campaign campaign, Principal principal) {
		ResponseEntity<Campaign> camp = new ResponseEntity<Campaign>(campaignRepository.save(campaign), HttpStatus.CREATED);
		addAsset(new Asset(0,campaign.getCampaignName(),campaign.getCampaignId()),principal);
		return camp;
	}
	
	@Override
	public ResponseEntity<Asset> addAsset(Asset asset, Principal principal) {
		return new ResponseEntity<Asset>(assetRepository.save(asset), HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<Campaign> updateCampaign(Campaign campaign, Principal principal) {
		return new ResponseEntity<Campaign>(campaignRepository.save(campaign), HttpStatus.OK);
	}
}
