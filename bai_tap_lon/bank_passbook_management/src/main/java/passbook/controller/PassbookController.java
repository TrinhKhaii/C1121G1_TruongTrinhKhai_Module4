package passbook.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import passbook.dto.CustomerDto;
import passbook.dto.PassbookDto;
import passbook.model.Customer;
import passbook.model.Passbook;
import passbook.service.ICustomerService;
import passbook.service.IPassbookService;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

/*
    Created by Trinh Khai
    Date: 08/04/2022
    Time: 09:07
*/
@Controller
@RequestMapping(value = "/passbook")
public class PassbookController {
    @Autowired
    private IPassbookService iPassbookService;

    @Autowired
    private ICustomerService iCustomerService;

    @ModelAttribute("periods")
    public Iterable<Integer> periods() {
        return Arrays.asList(3, 9, 12, 18, 24, 36);
    }

    @GetMapping(value = "")
    public ModelAndView showList() {
        List<Passbook> passbooks = iPassbookService.findAll();
        ModelAndView modelAndView = new ModelAndView("/passbook/list");
        modelAndView.addObject("passbooks", passbooks);
        return modelAndView;
    }

    @GetMapping(value = "/create")
    public ModelAndView goCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/passbook/create");
        modelAndView.addObject("passbookDto", new PassbookDto());
        return modelAndView;
    }

    @PostMapping(value = "/save")
    public String save(@Valid @ModelAttribute("passbookDto") PassbookDto passbookDto,
                       BindingResult bindingResult) {
        new PassbookDto().validate(passbookDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return "/passbook/create";
        }
        Passbook passbook = new Passbook();
        BeanUtils.copyProperties(passbookDto, passbook);
        Customer customerExist = iCustomerService.findByNameAndCode(passbookDto.getCustomerDto().getCustomerCode(), passbookDto.getCustomerDto().getCustomerName());
        Customer customer = new Customer();

        if (!(customerExist == null)) {
            passbook.setCustomer(customerExist);
        } else {
            customer.setCustomerId(passbookDto.getCustomerDto().getCustomerId());
            customer.setCustomerCode(passbookDto.getCustomerDto().getCustomerCode());
            customer.setCustomerName(passbookDto.getCustomerDto().getCustomerName());
            passbook.setCustomer(customer);
        }
        iPassbookService.save(passbook);
        return "redirect:/passbook";
    }

    @GetMapping(value = "/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Integer id) {
        ModelAndView modelAndView = new ModelAndView("passbook/edit");
        Passbook passbook =  iPassbookService.findById(id);
        PassbookDto passbookDto = new PassbookDto();
        BeanUtils.copyProperties(passbook, passbookDto);
        CustomerDto customerDto = new CustomerDto();
        customerDto.setCustomerId(passbook.getCustomer().getCustomerId());
        customerDto.setCustomerCode(passbook.getCustomer().getCustomerCode());
        customerDto.setCustomerName(passbook.getCustomer().getCustomerName());
        passbookDto.setCustomerDto(customerDto);
        modelAndView.addObject("passbookDto", passbookDto);
        return modelAndView;
    }

    @PostMapping(value = "/update")
    public String update(@Valid @ModelAttribute("passbookDto") PassbookDto passbookDto,
                         BindingResult bindingResult) {
        new PassbookDto().validate(passbookDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return "/passbook/edit";
        }
        Passbook passbook = new Passbook();
        BeanUtils.copyProperties(passbookDto, passbook);
        Customer customer = new Customer();
        customer.setCustomerId(passbookDto.getCustomerDto().getCustomerId());
        customer.setCustomerCode(passbookDto.getCustomerDto().getCustomerCode());
        customer.setCustomerName(passbookDto.getCustomerDto().getCustomerName());
        passbook.setCustomer(customer);
        iPassbookService.save(passbook);
        return "redirect:/passbook";
    }

    @PostMapping(value = "/delete")
        public String delete(@RequestParam("idDelete") Integer idDelete) {
        iPassbookService.remove(idDelete);
        return "redirect:/passbook";
    }
}
