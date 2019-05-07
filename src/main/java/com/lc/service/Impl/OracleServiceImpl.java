package com.lc.service.Impl;

import com.lc.dao.OralceDao;
import com.lc.dao.UserDao;
import com.lc.service.OracleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service(value = "oracleServiceo")
public class OracleServiceImpl implements OracleService {

    @Autowired
    private OralceDao oracleDao;

    @Transactional
    public List<Map<String,String>> selectTest() {
        return oracleDao.selectTest();
    }
}
