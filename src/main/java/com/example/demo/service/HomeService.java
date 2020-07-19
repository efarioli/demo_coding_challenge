package com.example.demo.service;

import com.example.demo.mapper.CustomerMapper;
import com.example.demo.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomeService {
    private CustomerMapper customerMapper;

    @Autowired
    public HomeService(CustomerMapper customerMapper) {
        this.customerMapper = customerMapper;
    }

    public Customer getCustomer(String email){
        return customerMapper.getCustomer(email);
    }



    public int addCustomer(Customer customer ) {
        customer.setEmail(customer.getEmail().toLowerCase());
        if (getCustomer(customer.getEmail()) == null) {
            return customerMapper.insertFile(customer);
        }
        return 0;
    }

    public int addCustomer(Customer customer , String site) {
        customer.setEmail(customer.getEmail().toLowerCase());
        if (getCustomer(customer.getEmail()) == null) {
            return customerMapper.insertFile(customer);
        }
        return 0;
    }
}
