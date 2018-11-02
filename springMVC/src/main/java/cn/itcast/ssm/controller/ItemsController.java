package cn.itcast.ssm.controller;

import cn.itcast.ssm.po.ItemsCustom;
import cn.itcast.ssm.po.ItemsQueryVo;
import cn.itcast.ssm.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
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
//    在需要效验的pojo前面添加@Validated在效验的pojp后面添加BindingResult bindingResult接收效验信息
//    注意：@Validated和BindingResult bindingResult是配对出现的，并且形参顺序是固定的（一前一后）有多个参数的效验的情况下
    @RequestMapping(value = "/editItemsSubmit" )
    public String editItemsSubmit(Model model,Integer id,@Validated ItemsCustom itemsCustom, BindingResult bindingResult)throws Exception{
        //       获取效验错误信息
        if (bindingResult.hasErrors()){
//            输出错误信息
            List<ObjectError> allErrors=bindingResult.getAllErrors();
            for (ObjectError objectError:allErrors){
//                输出错误信息
                System.out.println(objectError.getDefaultMessage());
            }
//            将错误信息传到页面
            model.addAttribute("allErrors",allErrors);
            return "/items/editItems";
        }
        itemsService.updateItems(id,itemsCustom);
//        ModelAndView modelAndView=new ModelAndView();
//        modelAndView.setViewName("success");
//        重定向商品查询列表
//        return "redirect:/items/queryItems";
//        页面转发
//        return "forward:/items/queryItems";
        return "/success";
    }

//    批量删除
    @RequestMapping(value = "/deleteItems")
    public String deleteItems(ItemsQueryVo itemsQueryVo)throws Exception{
        itemsService.deleteItemsList(itemsQueryVo);
        return "/success";
    }

//    修改产品名称页将商品信息查询出来在页面中可以编辑商品信息
    @RequestMapping(value = "/editItemsQuery")
    public String editItemsQuery(Model model, ItemsQueryVo itemsQueryVo)throws Exception{
        List<ItemsCustom>itemsCustoms=itemsService.findItemsList(itemsQueryVo);
        System.out.print(itemsCustoms);
        model.addAttribute("itemsList",itemsCustoms);

        return "/items/editItemsQuery";
    }

//    批量修改商品
//    通过ItemsQueryVo接收批量提交的商品信息，将商品信息存储到itemsQueryVo中的itemsList属性中
    @RequestMapping(value = "/editItemsAllSubmit")
    public String editItemsAllSubmit(ItemsQueryVo itemsQueryVo)throws Exception{

        return "/success";
    }
}
