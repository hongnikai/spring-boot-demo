package com.lc.service.Impl;

import com.lc.dao.one.UserinfoMapper;
import com.lc.dao.two.PeopleMapper;
import com.lc.service.UserinfoService;
import com.lc.util.BuildResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author baibing
 * @project: springboot-mybatis
 * @package: com.sailing.springbootmybatis.service.impl
 * @Description: service实现类
 * @date 2018/9/12 10:03
 */
@Service
@Transactional
public class UserinfoServiceImpl implements UserinfoService {

    @Autowired
    @SuppressWarnings("SpringJavaAutowiringInspection")
    private UserinfoMapper userinfoMapper;

    @Autowired
    @SuppressWarnings("SpringJavaAutowiringInspection")
    private PeopleMapper peopleMapper;




    /**
     * 删除指定用户(如果多个数据源，没有使用jta的情况下只有transactionManagerOne会回滚，transactionManagerTwo不会回滚)
     * @param id 用户id
     * @return
     */
    @Override
    public Object deleteUser(Integer id) {
       Object a =  userinfoMapper.deleteByPrimaryKey(id);
       Object b = peopleMapper.deleteByPrimaryId(id);
//        System.out.println(10/0);
        return BuildResponseUtil.buildSuccessResponse();

    }


}
