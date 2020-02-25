package com.yoan.controller;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yoan.model.Asset;
import com.yoan.model.Campaign;
import com.yoan.service.CampaignService;

@RestController
@CrossOrigin()
public class CampaignController {
	
	@Autowired
	private CampaignService campaignService;
	
	@GetMapping(value="campaigns")
	public Iterable<Campaign> getAllCampaigns()
	{
		return campaignService.getAllCampaigns();
	}
	
	@GetMapping(value="assets")
	public Iterable<Asset> getAllAssets()
	{
		return campaignService.getAllAssets();
	}
	
	@GetMapping(value="campaign/{campaignId}")
	public ResponseEntity<Campaign> getCampaignById(@PathVariable("campaignId") int campaignId)
	{
		return campaignService.getCampaignById(campaignId);
	}
	
	@PostMapping(value="campaign")
	public ResponseEntity<Campaign> addcampaign(@Valid @RequestBody Campaign campaign,Principal principal)
	{
		return campaignService.addCampaign(campaign,principal);
	}

}
