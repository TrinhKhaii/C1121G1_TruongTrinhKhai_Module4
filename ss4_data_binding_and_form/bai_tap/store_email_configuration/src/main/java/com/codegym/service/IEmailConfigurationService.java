package com.codegym.service;
/*
    Created by Trinh Khai
    Date: 01/04/2022
    Time: 15:34
*/

import com.codegym.model.EmailConfiguration;

import java.util.List;

public interface IEmailConfigurationService {
    List<EmailConfiguration> emailConfigurationList();

    void save(EmailConfiguration emailConfiguration);

    EmailConfiguration getEmailConfigurationById(Integer id);

    void updateEmailConfiguration(EmailConfiguration emailConfiguration);
}
