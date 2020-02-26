package com.zensar.model;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="campaign_tbl")
public class Campaign {
	
	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int campaignId;	
	private String campaignName;
	@OneToMany(cascade=CascadeType.PERSIST,fetch = FetchType.EAGER)
	@JoinColumn(name ="campaignId")
	private List<Asset> assetId;
	
	public int getCampaignId() {
		return campaignId;
	}
	public void setCampaignId(int campaignId) {
		this.campaignId = campaignId;
	}
	public String getCampaignName() {
		return campaignName;
	}
	public void setCampaignName(String campaignName) {
		this.campaignName = campaignName;
	}
}
