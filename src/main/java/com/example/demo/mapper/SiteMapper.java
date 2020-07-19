package com.example.demo.mapper;

import com.example.demo.model.Site;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SiteMapper {
    @Select("SELECT * FROM SITES WHERE lower(siteName) = #{siteName} ")
    Site getSite(String siteName);
}
