package cn.itcast.ssm.mapper;

import cn.itcast.ssm.po.Items;
import cn.itcast.ssm.po.ItemsWithBLOBs;

public interface ItemsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ItemsWithBLOBs record);

    int insertSelective(ItemsWithBLOBs record);

    ItemsWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ItemsWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ItemsWithBLOBs record);

    int updateByPrimaryKey(Items record);
}