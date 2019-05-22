package com.lc.dao.one;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;
@Mapper
public interface UserinfoMapper {
    int deleteByPrimaryKey(Integer id);

}