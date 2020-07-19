package com.example.demo.model;

public class CustomerSite {
    private int siteId;
    private  int customerId;

    public CustomerSite() {
    }

    public CustomerSite(int siteId, int customerId) {
        this.siteId = siteId;
        this.customerId = customerId;
    }

    public int getSiteId() {
        return siteId;
    }

    public void setSiteId(int siteId) {
        this.siteId = siteId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
}
