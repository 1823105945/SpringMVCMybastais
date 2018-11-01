package cn.itcast.ssm.controller;

import cn.itcast.ssm.po.ItemsCustom;
import cn.itcast.ssm.po.ItemsQueryVo;
import cn.itcast.ssm.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/items")
public class ItemsController {

    @Autowired
    private ItemsService itemsService;

//    商品查询
    @RequestMapping("/queryItems")
    public String queryItems(Model model, ItemsQueryVo itemsQueryVo)throws Exception{

        List<ItemsCustom>itemsCustoms=itemsService.findItemsList(itemsQueryVo);
        System.out.print(itemsCustoms);
//        ModelAndView modelAndView=new ModelAndView();
//        modelAndView.addObject("itemsList",itemsCustoms);
//        modelAndView.setViewName("/items/itemsList");
        model.addAttribute("itemsList",itemsCustoms);
        return "/items/itemsList";
    }

//商品修改
    @RequestMapping(value = "/editItems")
    public String editItems(Model model, Integer id)throws Exception{
        ItemsCustom itemsCustom =itemsService.findItemsById(id);
//        ModelAndView modelAndView =new ModelAndView();
//        modelAndView.setViewName("/items/editItems");
//        modelAndView.addObject("itemsCustom",itemsCustom);
        model.addAttribute("itemsCustom",itemsCustom);
        return "/items/editItems";
    }

//    商品修改提交
    @RequestMapping(value = "/editItemsSubmit" )
    public String editItemsSubmit(Integer id,ItemsCustom itemsCustom)throws Exception{
        itemsService.updateItems(id,itemsCustom);
//        ModelAndView modelAndView=new ModelAndView();
//        modelAndView.setViewName("success");
//        重定向商品查询列表
//        return "redirect:/items/queryItems";
//        页面转发
//        return "forward:/items/queryItems";
        return "/success";
    }
}
