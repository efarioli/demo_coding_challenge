package com.example.demo.service;

import com.example.demo.mapper.CustomerSitesMapper;
import org.springframework.stereotype.Service;

@Service
public class CustomerSitesService {
    private CustomerSitesMapper customerSitesMapper;

    public CustomerSitesService(CustomerSitesMapper customerSitesMapper) {
        this.customerSitesMapper = customerSitesMapper;
    }


    public int addCustomerSite (Integer siteId, Integer customerId){
        return customerSitesMapper.insertFile(siteId, customerId);
    }
    public boolean isCustomerRegisteredinThisSite (Integer siteId, Integer customerId){
        return (customerSitesMapper.getCustomerSite(siteId, customerId) != null);
    }
}
