package com.yoan.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="asset_tbl")
public class Asset {
	
	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int assetId;	
	private String assetName;
	private int campaignId;
		
	public Asset() {
		super();
	}
	public Asset(int assetId, String assetName, int campaignId) {
		super();
		this.assetId = assetId;
		this.assetName = assetName;
		this.campaignId = campaignId;
	}
	public int getAssetId() {
		return assetId;
	}
	public void setAssetId(int assetId) {
		this.assetId = assetId;
	}
	public String getAssetName() {
		return assetName;
	}
	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}
	public int getCampaignId() {
		return campaignId;
	}
	public void setCampaignId(int campaignId) {
		this.campaignId = campaignId;
	}
}