package com.lc.service;

import java.util.List;
import java.util.Map;

public interface UserService {

    Map<String,Object> selectAllUser();

    List<Map<String,Object>> selectPriceInnerJoinPriceOrder(Map<String, Object> map);

    void insertUsers(List list);
}
