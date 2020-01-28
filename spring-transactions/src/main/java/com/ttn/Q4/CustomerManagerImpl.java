package com.ttn.Q4;

import com.ttn.Q4.Customer;
import com.ttn.Q4.CustomerDAO;
import com.ttn.Q4.CustomerManager;
import org.springframework.transaction.annotation.Transactional;

public class CustomerManagerImpl implements CustomerManager {

    private CustomerDAO customerDAO;

    public void setCustomerDAO(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    @Override
    @Transactional
    public void createCustomer(Customer cust) {
        customerDAO.create(cust);
    }

}
