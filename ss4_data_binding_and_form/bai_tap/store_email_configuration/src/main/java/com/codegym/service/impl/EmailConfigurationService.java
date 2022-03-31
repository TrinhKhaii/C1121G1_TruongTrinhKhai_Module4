package com.codegym.service.impl;
/*
    Created by Trinh Khai
    Date: 31/03/2022
    Time: 10:47
*/

import com.codegym.model.EmailConfiguration;
import com.codegym.service.IEmailConfigurationService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class EmailConfigurationService implements IEmailConfigurationService {
    private static final List<EmailConfiguration> emailConfigurationList = new ArrayList<>();
    static {
        emailConfigurationList.add(new EmailConfiguration(1, "English", 10, true, "Khai..."));
    }
    @Override
    public List<EmailConfiguration> emailConfigurationList() {
        return emailConfigurationList;
    }

    @Override
    public void save(EmailConfiguration emailConfiguration) {
        emailConfiguration.setId(emailConfigurationList.get(emailConfigurationList.size() - 1).getId() + 1);
        emailConfigurationList.add(emailConfiguration);
    }

    @Override
    public EmailConfiguration getEmailConfigurationById(Integer id) {
        for (EmailConfiguration e: emailConfigurationList) {
            if (Objects.equals(e.getId(), id)) {
                return e;
            }
        }
        return null;
    }

    @Override
    public void updateEmailConfiguration(EmailConfiguration emailConfiguration) {
        for (EmailConfiguration e: emailConfigurationList) {
            if (Objects.equals(e.getId(), emailConfiguration.getId())) {
                e.setLanguage(emailConfiguration.getLanguage());
                e.setPageSize(emailConfiguration.getPageSize());
                e.setSpamsFilter(emailConfiguration.isSpamsFilter());
                e.setSignature(emailConfiguration.getSignature());
            }
        }
    }
}
