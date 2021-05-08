package com.crud.springboot.rest.service.customer;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;



@RestController
public class CustomerResource {

	@Autowired
	private CustomerRepository customerRepository;
	
	@GetMapping("/customer")
	public List<Customer> retrieveAllDataUser() {
		return customerRepository.findAll();
	}
	
	@GetMapping("/customer/{id}")
	public Customer retrieveCustomer(@PathVariable long id) {
		Optional<Customer> customer = customerRepository.findById(id);

		if (!customer.isPresent()) {
			throw new CustomerNotFoundException("id-" + id);			
		}
			
		return customer.get();
	}
	
	@DeleteMapping("/customer/{id}")	
	public void deleteCustomer(@PathVariable long id) {				
		Optional<Customer> customerOptional = customerRepository.findById(id);
		
		if (!customerOptional.isPresent()) {
			throw new CustomerNotFoundException("id-" + id);			
		}
		
		customerRepository.deleteById(id);
	}
	
	@PostMapping("/customer")
	public ResponseEntity<Object> createCustomer(@RequestBody Customer customer) {
		Customer savedCustomer = customerRepository.save(customer);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedCustomer.getId()).toUri();

		return ResponseEntity.created(location).build();
	}
	
	@PutMapping("/customer/{id}")
	public ResponseEntity<Object> updateCustomer(@RequestBody Customer customer, @PathVariable long id) {

		Optional<Customer> customerOptional = customerRepository.findById(id);

		if (!customerOptional.isPresent()) {
			throw new CustomerNotFoundException("id-" + id);			
		}			

		customer.setId(id);		
		customerRepository.save(customer);

		return ResponseEntity.noContent().build();
	}
	
}
