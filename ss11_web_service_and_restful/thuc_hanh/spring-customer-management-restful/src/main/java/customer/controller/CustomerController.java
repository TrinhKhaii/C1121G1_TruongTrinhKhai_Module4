package customer.controller;

import customer.model.Customer;
import customer.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/*
    Created by Trinh Khai
    Date: 14/04/2022
    Time: 05:16
*/
@RestController
@RequestMapping(value = "/api/customers")
public class CustomerController {
    @Autowired
    private ICustomerService iCustomerService;

    @GetMapping(value = "")
    public ResponseEntity<Iterable<Customer>> findAllCustomer() {
        List<Customer> customers = (List<Customer>) iCustomerService.findAll();
        if (customers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Customer> findCustomerById(@PathVariable("id") Long id) {
        Optional<Customer> customerOptional =iCustomerService.findById(id);
        if (!customerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customerOptional.get(), HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer) {
        return new ResponseEntity<>(iCustomerService.save(customer), HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable("id") Long id, @RequestBody Customer customer) {
        Optional<Customer> customerOptional = iCustomerService.findById(id);
        if (!customerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        customer.setId(customerOptional.get().getId());
        return new ResponseEntity<>(iCustomerService.save(customer), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable("id") Long id) {
        Optional<Customer> customerOptional = iCustomerService.findById(id);
        if (!customerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        iCustomerService.remove(id);
        return new ResponseEntity<>(customerOptional.get(), HttpStatus.NO_CONTENT);
    }
}
