package cn.itcast.ssm.service;

import cn.itcast.ssm.po.Items;
import cn.itcast.ssm.po.ItemsCustom;
import cn.itcast.ssm.po.ItemsQueryVo;

import java.util.List;

public interface ItemsService {

//    商品查询列表
    public List<ItemsCustom> findItemsList (ItemsQueryVo itemsQueryVo)throws Exception;
    public Items selectByPrimaryKey(Integer id)throws Exception;
}
