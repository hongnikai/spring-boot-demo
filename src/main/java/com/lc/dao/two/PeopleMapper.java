package com.lc.dao.two;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author baibing
 * @project: springboot-mybatis
 * @package: com.sailing.springbootmybatis.mapper
 * @Description: 日志mapper文件
 * @date 2018/10/16 14：17
 */
@Mapper
public interface PeopleMapper {

    int deleteByPrimaryId(Integer id);
}
