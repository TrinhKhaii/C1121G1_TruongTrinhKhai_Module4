package furama.controller;

import furama.dto.contract_dto.ContractDTO;
import furama.dto.contract_dto.ContractDetailDTO;
import furama.model.contract_entity.AttachService;
import furama.model.contract_entity.Contract;
import furama.model.contract_entity.ContractDetail;
import furama.service.IAttachServiceService;
import furama.service.IContractDetailService;
import furama.service.IContractService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/*
    Created by Trinh Khai
    Date: 23/04/2022
    Time: 20:33
*/
@Controller
@RequestMapping(value = "/contract-detail")
public class ContractDetailController {
    @Autowired
    private IContractDetailService iContractDetailService;

    @Autowired
    private IContractService iContractService;

    @Autowired
    private IAttachServiceService iAttachServiceService;

    @ModelAttribute("contracts")
    public Iterable<Contract> sendContractList() {
        return iContractService.findAll();
    }

    @ModelAttribute("attactServices")
    public Iterable<AttachService> sendContractDetailList() {
        return iAttachServiceService.findAll();
    }

    @GetMapping(value = "")
    public ModelAndView showList() {
        ModelAndView modelAndView = new ModelAndView("contract_detail/list");
        Iterable<ContractDetail> contractDetails = iContractDetailService.findAll();
        modelAndView.addObject("contractDetails", contractDetails);
        return modelAndView;
    }

    @GetMapping(value = "/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("contract_detail/create");
        modelAndView.addObject("contractDetailDTO", new ContractDetailDTO());
        return modelAndView;
    }

    @PostMapping(value = "/save")
    public String save(@Valid @ModelAttribute("contractDetailDTO") ContractDetailDTO contractDetailDTO,
                       BindingResult bindingResult) {
        ContractDetailDTO contractDetailDTOError = new ContractDetailDTO();
        contractDetailDTOError.setiContractDetailService(iContractDetailService);
        contractDetailDTOError.validate(contractDetailDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            return "/contract_detail/create";
        }
        ContractDetail contractDetail = new ContractDetail();
        BeanUtils.copyProperties(contractDetailDTO, contractDetail);
        contractDetail.setContract(contractDetailDTO.getContract());
        contractDetail.setAttachService(contractDetailDTO.getAttachService());
        iContractDetailService.save(contractDetail);
        return "redirect:/contract-detail";
    }
}
