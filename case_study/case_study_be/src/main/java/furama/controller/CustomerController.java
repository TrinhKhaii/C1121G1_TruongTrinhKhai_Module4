package furama.controller;

import furama.dto.customer_dto.CustomerDTO;
import furama.model.customer_entity.Customer;
import furama.model.customer_entity.CustomerType;
import furama.service.ICustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/*
    Created by Trinh Khai
    Date: 17/04/2022
    Time: 16:47
*/
@RestController
@RequestMapping(value = "/customer")
@CrossOrigin
public class CustomerController {
    @Autowired
    private ICustomerService iCustomerService;

    @GetMapping(value = "/customer_list")
    public ResponseEntity<Page<Customer>> showCustomerList(@RequestParam("searchVal") Optional<String> search,
                                                   @PageableDefault(value = 5) Pageable pageable) {
        String searchValue = search.orElse("");
        Page<Customer> customers = iCustomerService.findAllByName(searchValue, pageable);
        if (customers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @GetMapping(value = "/customer_type_list")
    public ResponseEntity<Iterable<CustomerType>> showCustomerTypeList() {
        return new ResponseEntity<>(iCustomerService.findAllCustomerType(), HttpStatus.OK);
    }

    @GetMapping(value = "/gender_list")
    public ResponseEntity<Iterable<String>> showGenderList() {
        Iterable<String> genderList = Arrays.asList("Nam", "Nữ", "Khác");
        return new ResponseEntity<>(genderList, HttpStatus.OK);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<Map<String, String>> saveCustomer(@Valid @RequestBody CustomerDTO customerDTO,
                                                            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errorMap = bindingResult.getFieldErrors()
                    .stream().collect(Collectors.toMap(
                            e -> e.getField(), e -> e.getDefaultMessage()));
            return new ResponseEntity<>(errorMap, HttpStatus.OK);
        }
        Customer customer = new Customer();
        CustomerType customerType = new CustomerType();
        BeanUtils.copyProperties(customerDTO, customer);
        BeanUtils.copyProperties(customerDTO.getCustomerType(), customerType);
        customer.setCustomerType(customerType);
        iCustomerService.save(customer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Customer> findCustomerById(@PathVariable("id") Integer id) {
        Optional<Customer> customerOptional = iCustomerService.findById(id);
        if (!customerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(customerOptional.get(), HttpStatus.OK);
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<Map<String, String>> updateCustomer(@PathVariable("id") Integer id,
                                                              @Valid @RequestBody CustomerDTO customerDTO,
                                                              BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errorMap = bindingResult.getFieldErrors()
                    .stream().collect(Collectors.toMap(
                            e -> e.getField(), e -> e.getDefaultMessage()));
            return new ResponseEntity<>(errorMap, HttpStatus.OK);
        }
        Customer customer = new Customer();
        CustomerType customerType = new CustomerType();
        BeanUtils.copyProperties(customerDTO, customer);
        BeanUtils.copyProperties(customerDTO.getCustomerType(), customerType);
        customer.setCustomerId(id);
        customer.setCustomerType(customerType);
        iCustomerService.save(customer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping(value = "/delete/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable("id") Integer id) {
        Optional<Customer> customerOptional = iCustomerService.findById(id);
        if (!customerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Customer customerDelete = customerOptional.get();
        customerDelete.setDeleteFlag(true);
        iCustomerService.save(customerDelete);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
