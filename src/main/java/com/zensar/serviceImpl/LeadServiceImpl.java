package com.zensar.serviceImpl;

import java.security.Principal;
import java.util.Date;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.zensar.model.Address;
import com.zensar.model.Asset;
import com.zensar.model.Campaign;
import com.zensar.model.Company;
import com.zensar.model.Lead;
import com.zensar.model.Prospect;
import com.zensar.repository.AssetRepository;
import com.zensar.repository.CampaignRepository;
import com.zensar.repository.EmployeeRepository;
import com.zensar.repository.LeadRepository;
import com.zensar.service.LeadService;

@Service
public class LeadServiceImpl implements LeadService {

	@Autowired
	private LeadRepository leadRepository;
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private CampaignRepository campaignRepository;
	@Autowired
	private AssetRepository assetRepository;
	
	@Override
	public Iterable<Lead> getAllLeads(Principal principal) {
		if(employeeRepository.findById(Integer.parseInt(principal.getName())).get().getDesignation().equals("BDM"))
		{
			return leadRepository.findAll();
		}
		else if(employeeRepository.findById(Integer.parseInt(principal.getName())).get().getDesignation().equals("TEAM lEAD"))
		{
			return null;
		}
		else
		{
			return null;
		}
	}

	@Override
	public ResponseEntity<Lead> addLead(JSONObject jsonObject, Principal principal) {
		
		Prospect prospect = new Prospect(
				 0,
				(String) jsonObject.get("firstName"),
				(String) jsonObject.get("lastName"),
				(String) jsonObject.get("jobTitle"),
				(String) jsonObject.get("jobLevel"),
				(String) jsonObject.get("jobDepartment"),
				(String) jsonObject.get("email"),
				(String) jsonObject.get("jobTitleLink"),
				(Long) jsonObject.get("phoneNumber"),
				(Long) jsonObject.get("directNumber")
				);
		
		Address address = new Address(
				0,
				(String) jsonObject.get("country"),
				(String) jsonObject.get("state"),
				(String) jsonObject.get("city"),
				(String) jsonObject.get("zipcode"),
				(String) jsonObject.get("addressLine1"),
				(String) jsonObject.get("addressLine2")
				);
		Company company = new Company(
				0,
				(String) jsonObject.get("companyName"),
				(String) jsonObject.get("industryType"),
				(String) jsonObject.get("employeeSize"),
				(String) jsonObject.get("domain"),
				(String) jsonObject.get("sicCode"),
				(String) jsonObject.get("naicsCode"),
				(String) jsonObject.get("revenueSize"),
				(String) jsonObject.get("employeeSizeLink"),
				(String) jsonObject.get("industryTypeLink"),
				(String) jsonObject.get("revenueSizeLink"),
				(String) jsonObject.get("sicCodeLink"),
				(String) jsonObject.get("naicsCodeLink"),
				address
				);
		
		Campaign campaign =  campaignRepository.findById((int) jsonObject.get("campaign")).get();
		Asset asset =  assetRepository.findById((int) jsonObject.get("asset")).get();

		Lead lead = new Lead(
				0,
				new Date(),
				"PENDING",
				(String) jsonObject.get("department"),
				employeeRepository.findById(Integer.parseInt(principal.getName())).get(),
				company,
				campaign,
				asset,
				prospect
				);
		
		return new ResponseEntity<Lead>(leadRepository.save(lead), HttpStatus.CREATED);
	}
	@Override
	public ResponseEntity<Lead> getLeadById(int leadId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Lead> updateLead(Lead lead, Principal principal) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void deleteLeadById(int leadId) {
		leadRepository.deleteById(leadId);
	}

}
