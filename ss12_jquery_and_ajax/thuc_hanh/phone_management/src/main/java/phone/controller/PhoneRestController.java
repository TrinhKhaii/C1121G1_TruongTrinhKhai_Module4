package phone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import phone.model.Phone;
import phone.service.IPhoneService;

import java.util.Optional;

/*
    Created by Trinh Khai
    Date: 14/04/2022
    Time: 22:07
*/
@RestController
@RequestMapping(value = "/phone")
public class PhoneRestController {
    @Autowired
    private IPhoneService iPhoneService;

    @PostMapping
    public ResponseEntity<Phone> createPhone(@RequestBody Phone phone) {
        return new ResponseEntity<>(iPhoneService.save(phone), HttpStatus.CREATED);
    }

    @GetMapping(value = "/list")
    public ModelAndView getAllPhonePage() {
        ModelAndView modelAndView = new ModelAndView("/phone/list");
        modelAndView.addObject("phones", iPhoneService.findAll());
        return modelAndView;
    }

    @GetMapping
    public ResponseEntity<Iterable<Phone>> allPhones() {
        return new ResponseEntity<>(iPhoneService.findAll(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Phone> deletePhone(@PathVariable("id") Long id) {
        Optional<Phone> phoneOptional = iPhoneService.findById(id);
        if (!phoneOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        iPhoneService.remove(id);
        return new ResponseEntity<>(phoneOptional.get(), HttpStatus.NO_CONTENT);
    }
}
