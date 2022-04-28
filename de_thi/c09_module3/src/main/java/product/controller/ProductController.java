package product.controller;

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
import product.dto.ProductDTO;
import product.model.Category;
import product.model.Product;
import product.service.ICategoryService;
import product.service.IProductService;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/*
    Created by Trinh Khai
    Date: 27/04/2022
    Time: 21:27
*/
@Controller
@RequestMapping(value = "/product")
public class ProductController {
    @Autowired
    private IProductService iProductService;

    @Autowired
    private ICategoryService iCategoryService;

    @ModelAttribute("categories")
    public Iterable<Category> sendCategoryList() {
        return iCategoryService.findAll();
    }

    @GetMapping(value = {"", "/search"})
    public ModelAndView showProductList(@RequestParam("searchProductNameValue") Optional<String> productNamesearch,
                                        @RequestParam("searchProductPriceValue") Optional<String> productPricesearch,
                                        @RequestParam("searchCategoryNameValue") Optional<String> categoryNamesearch,
                                        @RequestParam("searchProductColorValue") Optional<String> productColorsearch,
                                        @PageableDefault(value = 20) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("/product-list");
        String searchProductNameValue = productNamesearch.orElse("");
        String productPricesearchValue = productPricesearch.orElse("");
        String categoryNamesearchValue = categoryNamesearch.orElse("");
        String productColorsearchValue = productColorsearch.orElse("");
        Page<Product> products = iProductService.findBySearchValue(searchProductNameValue, productPricesearchValue, categoryNamesearchValue, productColorsearchValue, pageable);
        modelAndView.addObject("products", products);
        modelAndView.addObject("searchProductNameValue", searchProductNameValue);
        modelAndView.addObject("productPricesearchValue", productPricesearchValue);
        modelAndView.addObject("categoryNamesearchValue", categoryNamesearchValue);
        modelAndView.addObject("productColorsearchValue", productColorsearchValue);
        return modelAndView;
    }

    @GetMapping(value = "/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("productDTO", new ProductDTO());
        return modelAndView;
    }

    @PostMapping(value = "/save")
    public String save(@Valid @ModelAttribute("productDTO") ProductDTO productDTO,
                       BindingResult bindingResult,
                       RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "/create";
        }
        Product product = new Product();
        Category category = new Category();
        BeanUtils.copyProperties(productDTO, product);
        BeanUtils.copyProperties(productDTO.getCategory(), category);
        product.setCategory(category);
        iProductService.save(product);
        redirectAttributes.addFlashAttribute("callSuccessModal", true);
        return "redirect:/product";
    }

    @GetMapping(value = "/edit/{id}")
    public ModelAndView showEditForm(@PathVariable("id") Integer id) {
        ModelAndView modelAndView = new ModelAndView("/edit");
        Product product = iProductService.findById(id).orElse(null);
        ProductDTO productDTO = new ProductDTO();
        if (product != null) {
            BeanUtils.copyProperties(product, productDTO);
            BeanUtils.copyProperties(product.getCategory(), productDTO.getCategory());
            modelAndView.addObject("productDTO", productDTO);
        }
        return modelAndView;
    }

    @PostMapping(value = "/update")
    public String update(@Valid @ModelAttribute("productDTO") ProductDTO productDTO,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "/edit";
        }
        Product product = new Product();
        Category category = new Category();
        BeanUtils.copyProperties(productDTO, product);
        BeanUtils.copyProperties(productDTO.getCategory(), category);
        product.setCategory(category);
        iProductService.save(product);
        redirectAttributes.addFlashAttribute("callSuccessModal", true);
        return "redirect:/product";
    }

    @PostMapping(value = "/delete")
    public String delete(@RequestParam("idDelete") Integer id,
                         RedirectAttributes redirectAttributes) {
        Optional<Product> productOptional = iProductService.findById(id);
        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            product.setDeleteFlag(true);
            iProductService.save(product);
            redirectAttributes.addFlashAttribute("callSuccessModal", true);
        }
        return "redirect:/product";
    }

    @PostMapping(value = "/deleteMultiple")
    public String deleteMutiMedicalRecord(@RequestParam("idMultiple") Optional<String> idMultiple,
                                          RedirectAttributes redirectAttributes) {
        if (idMultiple.isPresent()) {
            String idMMutipleValue = idMultiple.get();
            List<String> arr = Arrays.asList(idMMutipleValue.split(","));
            iProductService.setDeleteFlagMutiple(arr);
            redirectAttributes.addFlashAttribute("callSuccessModal", true);
        }
        return "redirect:/product";
    }
}
