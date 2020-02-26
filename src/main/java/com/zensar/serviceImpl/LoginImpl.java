package com.zensar.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User.UserBuilder;

import com.zensar.model.Employee;
import com.zensar.repository.EmployeeRepository;
import com.zensar.service.Login;

@Service
public class LoginImpl implements Login {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		int employeeId = Integer.parseInt(username);
		UserBuilder builder = null;		 
		try
		{
			Employee employee = employeeRepository.findById(employeeId).get();
			if (employee != null) 
			{
				if(employee.getEnabledFlag()==0)
					throw new UsernameNotFoundException("User not found.");
				builder = org.springframework.security.core.userdetails.User.withUsername(username);
				builder.password(employee.getPassword());
				builder.roles(employee.getDesignation());
				builder.disabled(employee.getEnabledFlag()==1?false:true);
			} 
			else 
			{
				throw new UsernameNotFoundException("User not found.");
			}	
		 }
		 catch(UsernameNotFoundException e)
		 {
			 System.out.println(e);
		 }
		 return builder.build();
	}

}
