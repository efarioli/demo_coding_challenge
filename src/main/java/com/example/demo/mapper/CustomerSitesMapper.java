package com.example.demo.mapper;


import com.example.demo.model.Customer;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CustomerSitesMapper {
    @Insert("INSERT INTO CUSTOMERSITES (siteId, customerId) VALUES" +
            " (#{siteId}, #{customerId} )")
    int insertFile(Integer siteId, Integer customerId);

    @Select("SELECT * FROM CUSTOMERSITES WHERE siteId = #{siteId} AND customerId = #{customerId}")
    Customer getCustomerSite(int siteId, int customerId);
}
