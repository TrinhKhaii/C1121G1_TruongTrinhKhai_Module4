package thi_thuc_hanh.service.impl;
/*
    Created by Trinh Khai
    Date: 29/04/2022
    Time: 09:21
*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import thi_thuc_hanh.model.Promotional;
import thi_thuc_hanh.repository.IPromotionalRepository;
import thi_thuc_hanh.service.IPromotionalService;

import java.util.Optional;

@Service
public class PromotionalService implements IPromotionalService {
    @Autowired
    private IPromotionalRepository iPromotionalRepository;

    @Override
    public Iterable<Promotional> findAll() {
        return iPromotionalRepository.findAll();
    }

    @Override
    public Optional<Promotional> findById(Integer id) {
        return iPromotionalRepository.findById(id);
    }

    @Override
    public void save(Promotional promotional) {
        iPromotionalRepository.save(promotional);
    }

    @Override
    public void remove(Integer id) {
        iPromotionalRepository.deleteById(id);
    }

    @Override
    public Page<Promotional> findAllBySearchValue(String discountRate, String startDate1, String endDate1, String startDate2, String endDate2, Pageable pageable) {
        return iPromotionalRepository.findAllBySearchValue(discountRate, startDate1, endDate1, startDate2, endDate2, pageable);
    }
}
