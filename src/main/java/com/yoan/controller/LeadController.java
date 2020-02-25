package com.yoan.controller;

import java.security.Principal;
import org.json.simple.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yoan.model.Lead;
import com.yoan.service.LeadService;

@RestController
@CrossOrigin()
public class LeadController {
	
	@Autowired
	private LeadService leadService;
	
	// Get all leads
	@GetMapping(value="leads")
	public Iterable<Lead> getAllEmployee(Principal principal)
	{
		return leadService.getAllLeads(principal);
	}
	
	// Post an lead
	@PostMapping(value="lead")
	public ResponseEntity<Lead> addLead(@RequestBody JSONObject jsonObject,Principal principal)
	{
		return leadService.addLead(jsonObject,principal);
	}
	
	// Delete lead by passing leadId
	@DeleteMapping("lead/{leadId}")
	public void deleteLeadById(@PathVariable("leadId") int leadId)
	{
		leadService.deleteLeadById(leadId);
	}

}
