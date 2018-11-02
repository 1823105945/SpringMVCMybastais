package cn.itcast.ssm.mapper;

import cn.itcast.ssm.po.ItemsCustom;
import cn.itcast.ssm.po.ItemsQueryVo;

import java.util.List;

public interface ItemsMapperCustom {

//    商品查询列表
    public List<ItemsCustom> findItemsList (ItemsQueryVo itemsQueryVo)throws Exception;

    //批量删除
    public void deleteItemsList(ItemsQueryVo itemsQueryVo)throws Exception;

    //    批量修改商品
    public void updateItemsList(ItemsQueryVo itemsQueryVo)throws Exception;
}