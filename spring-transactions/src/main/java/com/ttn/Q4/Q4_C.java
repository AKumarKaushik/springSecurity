package com.ttn.Q4;

import com.ttn.Q4.Address;
import com.ttn.Q4.Customer;
import com.ttn.Q4.CustomerManager;
import com.ttn.Q4.CustomerManagerImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Q4_C {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("Spring.xml");
        CustomerManager customerManager = ctx.getBean("customerManager", CustomerManagerImpl.class);
        Customer cust = createDummyCustomer();
        customerManager.createCustomer(cust);
    }

    private static Customer createDummyCustomer() {
        Customer customer = new Customer();
        customer.setId(3097);
        customer.setName("Akash");
        Address address = new Address();
        address.setId(110043);
        address.setCountry("India");
        // setting value more than 20 chars, so that SQLException occurs
//        address.setAddress("Albany Dr, San Jose, CA 95129");
        address.setAddress("Najafgarh");
        customer.setAddress(address);
        return customer;
    }
}
