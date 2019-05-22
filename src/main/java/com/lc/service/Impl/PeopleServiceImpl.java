package com.lc.service.Impl;

import com.lc.dao.two.PeopleMapper;
import com.lc.service.PeopleService;
import com.lc.util.BuildResponseUtil;
import com.lc.util.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Lenovo
 * @project: springboot-mybatis
 * @package: com.sailing.springbootmybatis.service.impl
 * @Description:
 * @date 2018/10/191137
 */
@Service
@Transactional
public class PeopleServiceImpl implements PeopleService {

    @Autowired
    private PeopleMapper peopleMapper;


    @Override
    public ResponseData deleteByPrimaryId(Integer id) {
        peopleMapper.deleteByPrimaryId(id);
//        System.out.println(10/0);
        return BuildResponseUtil.buildSuccessResponse();
    }
}
