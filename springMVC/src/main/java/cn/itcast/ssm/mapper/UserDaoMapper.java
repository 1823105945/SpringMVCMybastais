package cn.itcast.ssm.mapper;

import cn.itcast.ssm.po.UserDao;

public interface UserDaoMapper {
    int insert(UserDao record);

    int insertSelective(UserDao record);
}