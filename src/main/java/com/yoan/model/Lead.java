package com.yoan.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="lead_tbl")
public class Lead {
	
	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int leadId;
	@Temporal(TemporalType.DATE)@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date;
	private String leadStatus,department;

	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name ="agentId")
	private Employee agent;	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "companyId")
	@Valid
	private Company company;

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "campaignId")
	@Valid
	private Campaign campaign;

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "assetId")
	@Valid
	private Asset asset;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="prospectId")
	@Valid
	private Prospect prospect;
	
	public Lead() {
		super();
	}
	public Lead(int leadId, Date date, String leadStatus, String department, Employee agent, @Valid Company company,
			@Valid Campaign campaign, @Valid Asset asset, @Valid Prospect prospect) {
		super();
		this.leadId = leadId;
		this.date = date;
		this.leadStatus = leadStatus;
		this.department = department;
		this.agent = agent;
		this.company = company;
		this.campaign = campaign;
		this.asset = asset;
		this.prospect = prospect;
	}
	@Override
	public String toString() {
		return "Lead [leadId=" + leadId + ", date=" + date + ", leadStatus=" + leadStatus + ", department=" + department
				+ ", agent=" + agent + ", company=" + company + ", campaign=" + campaign + ", asset=" + asset
				+ ", prospect=" + prospect + "]";
	}
	
	public Campaign getCampaign() {
		return campaign;
	}
	public void setCampaign(Campaign campaign) {
		this.campaign = campaign;
	}
	public Asset getAsset() {
		return asset;
	}
	public void setAsset(Asset asset) {
		this.asset = asset;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public int getLeadId() {
		return leadId;
	}
	public void setLeadId(int leadId) {
		this.leadId = leadId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getLeadStatus() {
		return leadStatus;
	}
	public void setLeadStatus(String leadStatus) {
		this.leadStatus = leadStatus;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public Employee getAgent() {
		return agent;
	}
	public void setAgent(Employee agent) {
		this.agent = agent;
	}
	public Prospect getProspect() {
		return prospect;
	}
	public void setProspect(Prospect prospect) {
		this.prospect = prospect;
	}
}