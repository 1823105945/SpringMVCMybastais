package cn.itcast.ssm.service.impl;

import cn.itcast.ssm.mapper.ItemsMapper;
import cn.itcast.ssm.mapper.ItemsMapperCustom;
import cn.itcast.ssm.po.Items;
import cn.itcast.ssm.po.ItemsCustom;
import cn.itcast.ssm.po.ItemsQueryVo;
import cn.itcast.ssm.service.ItemsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ItemsServiceImpl implements ItemsService {

    @Autowired
    private ItemsMapperCustom itemsMapperCustom;

    @Autowired
    private ItemsMapper itemsMapper;

    @Override
    public List<ItemsCustom>findItemsList(ItemsQueryVo itemsQueryVo)throws Exception{
//        通过ItemsCustom
        return itemsMapperCustom.findItemsList(itemsQueryVo);
    }

    //    根据id查询商品信息
    @Override
    public ItemsCustom findItemsById(Integer id)throws Exception{
        Items items=itemsMapper.selectByPrimaryKey(id);
        ItemsCustom itemsCustom=new ItemsCustom();
        BeanUtils.copyProperties(items,itemsCustom);
        return itemsCustom;
    }

    //    跟新商品信息
    @Override
    public void updateItems(Integer id,ItemsCustom itemsCustom)throws Exception{
        itemsCustom.setId(id);
//        大文本类型可以根据id更新表里面的所有的字段包括大文本
        itemsMapper.updateByPrimaryKeyWithBLOBs(itemsCustom);
    }
}
