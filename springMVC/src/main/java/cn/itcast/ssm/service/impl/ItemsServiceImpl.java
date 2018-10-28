package cn.itcast.ssm.service.impl;

import cn.itcast.ssm.mapper.ItemsMapperCustom;
import cn.itcast.ssm.po.Items;
import cn.itcast.ssm.po.ItemsCustom;
import cn.itcast.ssm.po.ItemsQueryVo;
import cn.itcast.ssm.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ItemsServiceImpl implements ItemsService {

    @Autowired
    private ItemsMapperCustom itemsMapperCustom;

    @Override
    public List<ItemsCustom>findItemsList(ItemsQueryVo itemsQueryVo)throws Exception{
//        通过ItemsCustom
        return itemsMapperCustom.findItemsList(itemsQueryVo);
    }

    public Items selectByPrimaryKey(Integer id)throws Exception{

        return  selectByPrimaryKey(id);
    }
}
