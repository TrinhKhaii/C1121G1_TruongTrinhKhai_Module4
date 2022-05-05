package thi_thuc_hanh.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import thi_thuc_hanh.dto.PromotionalDTO;
import thi_thuc_hanh.model.Promotional;
import thi_thuc_hanh.service.IPromotionalService;

import javax.validation.Valid;
import java.util.Optional;

/*
    Created by Trinh Khai
    Date: 29/04/2022
    Time: 09:18
*/
@Controller
@RequestMapping(value = "/promotional")
public class PromotionalController {
    @Autowired
    private IPromotionalService iPromotionalService;

    @GetMapping(value = {"", "/search"})
    public ModelAndView showProductList(@RequestParam("searchDiscountRateValue") Optional<String> discountNameSearch,
                                        @RequestParam(value = "searchStartDate1Value", defaultValue = "1900-01-01", required = false) String startDate1,
                                        @RequestParam(value = "searchEndDate1Value", defaultValue = "3000-01-01", required = false) String endDate1,
                                        @RequestParam(value = "searchStartDate2Value", defaultValue = "1900-01-01", required = false) String startDate2,
                                        @RequestParam(value = "searchEndDate2Value", defaultValue = "3000-01-01", required = false) String endDate2,
                                        @PageableDefault(value = 50) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("/list");
        String discountNameSearchValue = discountNameSearch.orElse("");

        Page<Promotional> promotionals = iPromotionalService.findAllBySearchValue(discountNameSearchValue, startDate1, endDate1, startDate2, endDate2, pageable);
        modelAndView.addObject("promotionals", promotionals);
        return modelAndView;
    }

    @GetMapping(value = "/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("promotionalDTO", new PromotionalDTO());
        return modelAndView;
    }

    @PostMapping(value = "/save")
    public String save(@Valid @ModelAttribute("promotionalDTO") PromotionalDTO promotionalDTO,
                       BindingResult bindingResult,
                       RedirectAttributes redirectAttributes) {
        new PromotionalDTO().validate(promotionalDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            return "/create";
        }
        Promotional promotional = new Promotional();
        BeanUtils.copyProperties(promotionalDTO, promotional);
        iPromotionalService.save(promotional);
        redirectAttributes.addFlashAttribute("callSuccessModal", true);
        return "redirect:/promotional";
    }

    @PostMapping(value = "/delete")
    public String delete(@RequestParam("idDelete") Integer id,
                         RedirectAttributes redirectAttributes) {
        Optional<Promotional> promotionalOptional = iPromotionalService.findById(id);
        if (promotionalOptional.isPresent()) {
            Promotional promotional = promotionalOptional.get();
            promotional.setDeleteFlag(true);
            iPromotionalService.save(promotional);
            redirectAttributes.addFlashAttribute("callSuccessModal", true);
        }
        return "redirect:/promotional";
    }

    @GetMapping(value = "/edit/{id}")
    public ModelAndView showEditForm(@PathVariable("id") Integer id) {
        ModelAndView modelAndView = new ModelAndView("/edit");
        Promotional promotional = iPromotionalService.findById(id).orElse(null);
        PromotionalDTO promotionalDTO = new PromotionalDTO();
        if (promotional != null) {
            BeanUtils.copyProperties(promotional, promotionalDTO);
            modelAndView.addObject("promotionalDTO", promotionalDTO);
        }
        return modelAndView;
    }

    @PostMapping(value = "/update")
    public String update(@Valid @ModelAttribute("promotionalDTO") PromotionalDTO promotionalDTO,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes) {
        new PromotionalDTO().validate(promotionalDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            return "/edit";
        }
        Promotional promotional = new Promotional();
        BeanUtils.copyProperties(promotionalDTO, promotional);
        iPromotionalService.save(promotional);
        redirectAttributes.addFlashAttribute("callSuccessModal", true);
        return "redirect:/promotional";
    }
}
