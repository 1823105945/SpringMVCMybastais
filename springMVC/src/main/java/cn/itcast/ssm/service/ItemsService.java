package cn.itcast.ssm.service;

import cn.itcast.ssm.po.ItemsCustom;
import cn.itcast.ssm.po.ItemsQueryVo;

import java.util.List;

public interface ItemsService {

//    商品查询列表
    public List<ItemsCustom> findItemsList (ItemsQueryVo itemsQueryVo)throws Exception;

//    根据id查询商品信息
    public ItemsCustom findItemsById(Integer id)throws Exception;

//    跟新商品信息
    public void updateItems(Integer id,ItemsCustom itemsCustom)throws Exception;

//    批量删除商品
    public void deleteItemsList(ItemsQueryVo itemsQueryVo)throws Exception;
}
