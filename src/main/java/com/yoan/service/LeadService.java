package com.yoan.service;

import java.security.Principal;

import org.json.simple.JSONObject;
import org.springframework.http.ResponseEntity;

import com.yoan.model.Lead;

public interface LeadService {
	Iterable<Lead> getAllLeads(Principal principal);
	ResponseEntity<Lead> addLead(JSONObject jsonObject,Principal principal);
	ResponseEntity<Lead> getLeadById(int leadId);
	ResponseEntity<Lead> updateLead(Lead lead,Principal principal);
	void deleteLeadById(int leadId);
}
