package thi_thuc_hanh.service;
/*
    Created by Trinh Khai
    Date: 29/04/2022
    Time: 09:21
*/

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import thi_thuc_hanh.model.Promotional;

public interface IPromotionalService extends IGeneralService<Promotional> {
    Page<Promotional> findAllBySearchValue(String discountRate, String startDate1, String endDate1, String startDate2, String endDate2, Pageable pageable);
}
