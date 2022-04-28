package product.repository;
/*
    Created by Trinh Khai
    Date: 27/04/2022
    Time: 21:28
*/

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import product.model.Product;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface IProductRepository extends JpaRepository<Product, Integer> {
    @Query(value = "select * from product " +
            "inner join category on product.product_id = category.category_id " +
            "where product.delete_flag = 0 and product.product_name like concat('%',:product_name,'%') and product.product_price like concat('%',:product_price,'%') " +
            "and category.category_name like concat('%',:category_name,'%') and product.product_color like concat('%',:product_color,'%') ",
    nativeQuery = true)
    Page<Product> findAllBySearchValue(@Param("product_name") String productName, @Param("product_price") String productPrice, @Param("category_name") String categoryName, @Param("product_color") String productColor, Pageable pageable);

    @Modifying
    @Query(value = "update product set delete_flag = 1 where product_id in :idMutiple ", nativeQuery = true)
    void setDeleteFlagMutiple(@Param("idMutiple") List<String> idMutiple);
}
