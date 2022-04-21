package furama.controller;

import furama.dto.customer_dto.CustomerDTO;
import furama.dto.service_dto.HouseDTO;
import furama.dto.service_dto.RoomDTO;
import furama.dto.service_dto.ServiceDTO;
import furama.dto.service_dto.VillaDTO;
import furama.model.customer_entity.Customer;
import furama.model.service_entity.RentType;
import furama.model.service_entity.Service;
import furama.model.service_entity.ServiceType;
import furama.service.IServiceService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.Optional;

/*
    Created by Trinh Khai
    Date: 21/04/2022
    Time: 10:13
*/
@Controller
@RequestMapping(value = "/service")
public class ServiceController {
    @Autowired
    private IServiceService iServiceService;

    @ModelAttribute("serviceTypes")
    public Iterable<ServiceType> sendServiceTypeList() {
        return iServiceService.findAllServiceType();
    }

    @ModelAttribute("rentTypes")
    public Iterable<RentType> sendRentTypeList() {
        return iServiceService.findAllRentType();
    }

    @ModelAttribute("standardRooms")
    public Iterable<String> sendStandardRoomList() {
        return Arrays.asList("Diamond", "Platinium", "Gold", "Silver", "Member");
    }

    @GetMapping(value = {"", "/search"})
    public ModelAndView showList(@RequestParam("searchValue") Optional<String> search,
                                 @PageableDefault(value = 5) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("/service/list");
        String searchValue = search.orElse("");
        Page<Service> services = iServiceService.findAllByName(searchValue, pageable);
        modelAndView.addObject("services", services);
        modelAndView.addObject("searchValue", searchValue);
        return modelAndView;
    }

    @GetMapping(value = "/create")
    public ModelAndView showCreateForm(@RequestParam("options") Integer serviceType) {
        ModelAndView modelAndView = new ModelAndView("service/create");
        if (serviceType == 1) {
            modelAndView.addObject("villaDTO", new VillaDTO());
        } else if (serviceType == 2) {
            modelAndView.addObject("houseDTO", new HouseDTO());
        } else if (serviceType == 3) {
            modelAndView.addObject("roomDTO", new RoomDTO());
        }
        modelAndView.addObject("serviceTypeId", serviceType);
        return modelAndView;
    }

    @PostMapping(value = "/saveVilla")
    public String saveVilla(@Valid @ModelAttribute("villaDTO") VillaDTO villaDTO,
                       BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/service/create";
        }
        villaDTO.setServiceType(new ServiceType(1, "Villa"));
        Service service = new Service();
        BeanUtils.copyProperties(villaDTO, service);
        service.setRentType(villaDTO.getRentType());
        service.setServiceType(villaDTO.getServiceType());
        iServiceService.save(service);
        return "redirect:/service";
    }

    @PostMapping(value = "/saveHouse")
    public String saveHouse(@Valid @ModelAttribute("houseDTO") HouseDTO houseDTO,
                       BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/service/create";
        }
        houseDTO.setServiceType(new ServiceType(2, "House"));
        Service service = new Service();
        BeanUtils.copyProperties(houseDTO, service);
        service.setRentType(houseDTO.getRentType());
        service.setServiceType(houseDTO.getServiceType());
        iServiceService.save(service);
        return "redirect:/service";
    }

    @PostMapping(value = "/saveRoom")
    public String saveRoom(@Valid @ModelAttribute("roomDTO") RoomDTO roomDTO,
                            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/service/create";
        }
        roomDTO.setServiceType(new ServiceType(3, "Room"));
        Service service = new Service();
        BeanUtils.copyProperties(roomDTO, service);
        service.setRentType(roomDTO.getRentType());
        service.setServiceType(roomDTO.getServiceType());
        iServiceService.save(service);
        return "redirect:/service";
    }

    @PostMapping(value = "/delete")
    public String delete(@RequestParam("idDelete") Integer id) {
        Optional<Service> serviceOptional = iServiceService.findById(id);
        if (serviceOptional.isPresent()) {
            Service serviceDelete = serviceOptional.get();
            serviceDelete.setDeleteFlag(true);
            iServiceService.save(serviceDelete);
        }
        return "redirect:/service";
    }
}
