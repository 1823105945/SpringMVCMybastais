package cn.itcast.ssm.controller;

import cn.itcast.ssm.po.ItemsCustom;
import cn.itcast.ssm.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ItemsController {

    @Autowired
    private ItemsService itemsService;

//    商品查询
    @RequestMapping("/queryItems")
    public ModelAndView queryItems()throws Exception{
        List<ItemsCustom>itemsCustoms=itemsService.findItemsList(null);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("itemsList",itemsCustoms);
        modelAndView.setViewName("items/itemsList");
        return modelAndView;
    }
}
