package com.example.demo.controller;

import com.example.demo.helper.DoValidation;
import com.example.demo.model.Customer;
import com.example.demo.service.CustomerSitesService;
import com.example.demo.service.HomeService;
import com.example.demo.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import static com.example.demo.helper.DoValidation.*;

@Controller
public class HomeController {

    private HomeService homeService;
    private CustomerSitesService customerSitesService;
    private SiteService siteService;

    @Autowired
    public HomeController(HomeService homeService, CustomerSitesService customerSitesService, SiteService siteService) {
        this.homeService = homeService;
        this.customerSitesService = customerSitesService;
        this.siteService = siteService;
    }

    @GetMapping("/avalon_city")
    public ModelAndView getHome(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("avalon_city");
        modelAndView.addObject("newCredential", new Form());
        modelAndView.addObject("errors", new HashMap<String, String>());
        return modelAndView;
    }
    @GetMapping("/aceparks")
    public ModelAndView getAceParks(){
        System.out.println("dsdfsdfsfd");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("avalon_city");

        modelAndView.addObject("newCredential", new Form());
        modelAndView.addObject("errors", new HashMap<String, String>());
        return modelAndView;
    }

    @PostMapping("/avalon_city")
    public ModelAndView submitForm(@ModelAttribute("newCredential") Form form, BindingResult bindingResult, @RequestHeader(value = "referer", required = false) final String referer){

        String referrer = referer;
        System.out.println("referer " + referer);

        String site = "avalon_city";
        ModelAndView modelAndView = new ModelAndView();
        Map<String, String> errors = doValidation(form);


        modelAndView.addObject("errors", errors);
//        for ( Map.Entry<String, String> entry : errors.entrySet()){
//            System.out.println(entry.getValue());
//
//        }

        if (errors.size()==0){
            String message = "";
            modelAndView.setViewName("result");
            System.out.println(form);
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());

            Customer customer = new Customer(null, timestamp , form.getEmail(), form.getTitle(), form.getFirstName(),
                    form.getLastName(), form.getAddressLine1(), form.getAddressLine2(),
                    form.getCity(), form.getPostcode(), form.getPhoneNumber());
            String refererFormatted = referer.toLowerCase().substring(referer.lastIndexOf('/')+1);
            refererFormatted = refererFormatted.replace("_" , " ");
            System.out.println("referer formatted \"" + refererFormatted + "\"");
            int i = homeService.addCustomer(customer, refererFormatted);
            int siteId = siteService.getSiteID(refererFormatted);

            if (i>0){
                customerSitesService.addCustomerSite(siteId, customer.getCustomerId());
                message = "User registered successfully";

            } else {
                customer = homeService.getCustomer(form.getEmail());
                if (customerSitesService.isCustomerRegisteredinThisSite(siteId, customer.getCustomerId())){
                    message = "Customer was already registered in this site";
                } else {
                    customerSitesService.addCustomerSite(siteId, customer.getCustomerId());
                    message = "Customer now also registered is this other site"                    ;
                }
                System.out.println( "is site already number" + siteService.getSiteID(refererFormatted));



            }
            modelAndView.addObject("message", message);
        } else
        {
            modelAndView.setViewName("avalon_city");
        }


        return modelAndView;
    }


    @GetMapping(value = "/*")
    public String Error(){
        System.out.println("dsdfsdfsfd");
        return "redirect:/avalon_city";
    }

}
