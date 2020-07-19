package com.example.demo.mapper;

import com.example.demo.model.Customer;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;


@Repository
@Mapper
public interface CustomerMapper {
    @Insert("INSERT INTO CUSTOMERS (registered, email, title, firstname, lastname, addressline1, addressline2, "+
            " city, postcode, telephone ) VALUES" +
            " (#{registered}, #{email}, #{title} , #{firstName}, #{lastName}, #{addressLine1}, #{addressLine2}, " + "" +
            " #{city}, #{postCode}, #{telephone})")
    @Options(useGeneratedKeys = true, keyProperty = "customerId")
    int insertFile(Customer customer);

    @Select("SELECT * FROM CUSTOMERS WHERE email = #{email}")
    Customer getCustomer(String email);
}
