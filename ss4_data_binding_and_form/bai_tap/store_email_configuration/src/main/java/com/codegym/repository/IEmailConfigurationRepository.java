package com.codegym.repository;
/*
    Created by Trinh Khai
    Date: 31/03/2022
    Time: 10:45
*/

import com.codegym.model.EmailConfiguration;

import java.util.List;

public interface IEmailConfigurationRepository {
    List<EmailConfiguration> emailConfigurationList();

    void save(EmailConfiguration emailConfiguration);

    EmailConfiguration getEmailConfigurationById(Integer id);

    void updateEmailConfiguration(EmailConfiguration emailConfiguration);
}
