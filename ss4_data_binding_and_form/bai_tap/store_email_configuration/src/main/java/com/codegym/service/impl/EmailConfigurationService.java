package com.codegym.service.impl;
/*
    Created by Trinh Khai
    Date: 01/04/2022
    Time: 15:35
*/

import com.codegym.model.EmailConfiguration;
import com.codegym.repository.IEmailConfigurationRepository;
import com.codegym.service.IEmailConfigurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailConfigurationService implements IEmailConfigurationService {
    @Autowired
    private IEmailConfigurationRepository iEmailConfigurationRepository;

    @Override
    public List<EmailConfiguration> emailConfigurationList() {
        return iEmailConfigurationRepository.emailConfigurationList();
    }

    @Override
    public void save(EmailConfiguration emailConfiguration) {
        iEmailConfigurationRepository.save(emailConfiguration);
    }

    @Override
    public EmailConfiguration getEmailConfigurationById(Integer id) {
        return iEmailConfigurationRepository.getEmailConfigurationById(id);
    }

    @Override
    public void updateEmailConfiguration(EmailConfiguration emailConfiguration) {
        iEmailConfigurationRepository.updateEmailConfiguration(emailConfiguration);
    }
}
