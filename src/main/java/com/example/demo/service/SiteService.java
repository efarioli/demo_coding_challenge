package com.example.demo.service;

import com.example.demo.mapper.SiteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SiteService {
    private SiteMapper siteMapper;

    @Autowired
    public SiteService(SiteMapper siteMapper) {
        this.siteMapper = siteMapper;
    }
    public Integer getSiteID (String siteName){

        return siteMapper.getSite(siteName).getSiteId();
    }
}
