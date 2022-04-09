package passbook.dto;
/*
    Created by Trinh Khai
    Date: 08/04/2022
    Time: 09:06
*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import passbook.model.Customer;
import passbook.service.ICustomerService;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class PassbookDto implements Validator {
    @Autowired
    private ICustomerService iCustomerService;

    private Integer passbookId;

    @NotEmpty(message = "Start day can not empty.")
    private String startDate;

    private Integer period;

    @NotNull(message = "Deposit amount can not empty.")
    @Min(value = 30000000, message = "Deposit amount must be positive and greater than 30000000.")
    private Double depositAmount;

    @Valid
    private CustomerDto customerDto;

    public PassbookDto() {
    }

    public PassbookDto(Integer passbookId, String startDate, Integer period, Double depositAmount, CustomerDto customerDto) {
        this.passbookId = passbookId;
        this.startDate = startDate;
        this.period = period;
        this.depositAmount = depositAmount;
        this.customerDto = customerDto;
    }

    public Integer getPassbookId() {
        return passbookId;
    }

    public void setPassbookId(Integer passbookId) {
        this.passbookId = passbookId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public Double getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(Double depositAmount) {
        this.depositAmount = depositAmount;
    }

    public CustomerDto getCustomerDto() {
        return customerDto;
    }

    public void setCustomerDto(CustomerDto customerDto) {
        this.customerDto = customerDto;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }



    @Override
    public void validate(Object target, Errors errors) {
        PassbookDto passbookDto = (PassbookDto) target;
        String startDate = passbookDto.getStartDate();

        if (startDate.matches("^\\d{4}[\\-\\/\\s]?((((0[13578])|(1[02]))[\\-\\/\\s]?(([0-2][0-9])|(3[01])))|(((0[469])|(11))[\\-\\/\\s]?(([0-2][0-9])|(30)))|(02[\\-\\/\\s]?[0-2][0-9]))$")) {

            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate now = LocalDate.now();
            LocalDate date = LocalDate.parse(startDate, fmt);

            if (date.isBefore(now)) {
                errors.rejectValue("startDate", "createDate.before", "The date you entered is not valid");
            }
        }

        CustomerDto customerDto = passbookDto.getCustomerDto();
        String customerCode = customerDto.getCustomerCode();

        Customer customer = iCustomerService.findByCode(customerCode);
        if (customer.getCustomerCode().equals(customerDto.getCustomerCode()) && !customer.getCustomerName().equals(customerDto.getCustomerName())) {
            errors.rejectValue("customerCode", "customerCode.exist", "Already exist this customer code.");
        }
    }
}
