package com.lc.service.Impl;

import com.lc.dao.UserDao;
import com.lc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service(value = "userService")
public class UserServiceImpl implements UserService{

        @Autowired
        private UserDao userDao;

        public Map<String,Object> selectAllUser(){
            return userDao.selectAllUser();
        }

        @Transactional
        public List<Map<String,Object>> selectPriceInnerJoinPriceOrder(Map<String,Object> map){
            return userDao.selectPriceInnerJoinPriceOrder(map);
        }

        @Transactional
        public void insertUsers(List list) {
            userDao.insertUsers(list);
        }

}
