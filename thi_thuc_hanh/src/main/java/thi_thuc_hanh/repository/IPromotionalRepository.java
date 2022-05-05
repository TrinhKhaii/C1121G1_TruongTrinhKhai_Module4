package thi_thuc_hanh.repository;
/*
    Created by Trinh Khai
    Date: 29/04/2022
    Time: 09:19
*/

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import thi_thuc_hanh.model.Promotional;

public interface IPromotionalRepository extends JpaRepository<Promotional, Integer> {
    @Query(value = "select * from promotional " +
            "where delete_flag = 0 and promotional.discount_rate like concat('%',:discount_rate,'%') " +
            "and promotional.start_date between :start_date1 and :end_date1 " +
            "and promotional.end_date between :start_date2 and :end_date2 ", nativeQuery = true)
    Page<Promotional> findAllBySearchValue(@Param("discount_rate") String discountRate, @Param("start_date1") String startDate1, @Param("end_date1") String endDate1, @Param("start_date2") String startDate2, @Param("end_date2") String endDate2, Pageable pageable);
}
