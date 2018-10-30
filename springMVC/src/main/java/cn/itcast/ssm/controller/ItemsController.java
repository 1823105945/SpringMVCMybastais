package cn.itcast.ssm.controller;

import cn.itcast.ssm.po.ItemsCustom;
import cn.itcast.ssm.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "items")
public class ItemsController {

    @Autowired
    private ItemsService itemsService;

//    商品查询
    @RequestMapping("/queryItems")
    public ModelAndView queryItems()throws Exception{

        List<ItemsCustom>itemsCustoms=itemsService.findItemsList(null);
        System.out.print(itemsCustoms);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("itemsList",itemsCustoms);
        modelAndView.setViewName("/items/itemsList");
        return modelAndView;
    }

//商品修改
    @RequestMapping(value = "/editItems")
    public ModelAndView editItems()throws Exception{
        ItemsCustom itemsCustom =itemsService.findItemsById(1);
        ModelAndView modelAndView =new ModelAndView();
        modelAndView.setViewName("/items/editItems");
        modelAndView.addObject("itemsCustom",itemsCustom);
        return modelAndView;
    }

//    商品修改提交
    @RequestMapping(value = "editItemsSubmit")
    public ModelAndView editItemsSubmit()throws Exception{
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("success");
        return modelAndView;
    }
}
