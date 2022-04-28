package product.service;
/*
    Created by Trinh Khai
    Date: 27/04/2022
    Time: 21:31
*/

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import product.model.Product;

import java.util.List;

public interface IProductService extends IGeneralService<Product> {
    Page<Product> findBySearchValue(String productName, String productPrice, String categgoryName, String color, Pageable pageable);

    void setDeleteFlagMutiple(List<String> idMutiple);
}
