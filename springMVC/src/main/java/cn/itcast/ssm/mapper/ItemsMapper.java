package cn.itcast.ssm.mapper;

import cn.itcast.ssm.po.ItemsWithBLOBs;

public interface ItemsMapper {
    int insert(ItemsWithBLOBs record);

    int insertSelective(ItemsWithBLOBs record);
}