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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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
//    items_pic接收商品图片
    @RequestMapping(value = "/editItemsSubmit" )
    public String editItemsSubmit(Model model, Integer id, @Validated ItemsCustom itemsCustom, BindingResult bindingResult, MultipartFile items_pic)throws Exception{
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
//        上传图片处理
        String originalFilename=items_pic.getOriginalFilename();

        if (items_pic!=null&&originalFilename!=null&&originalFilename.length()>0){
//            存储图片的物理路径
            String pic_path="/Users/liu_yakai/Documents/apache-tomcat-8.5.34/work";
//            原始名称
//            新的图片名称
            String newFileName= UUID.randomUUID()+originalFilename.substring(originalFilename.lastIndexOf("."));
//            新图片
            File newFile=new File(pic_path+newFileName);
//            将内存中的数据写入磁盘
            items_pic.transferTo(newFile);
//            将新图片名称写入itemsCusto中
            itemsCustom.setPic(newFileName);
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

//    商品信息输出json
//    /itemsView/{id}里的{id}表示将这个位置的参数传到@PathVariable指定名称中
    @RequestMapping(value = "/itemsView")
    public @ResponseBody ItemsCustom itemsView(Integer id)throws Exception{
//        调用service查询商品信息
        ItemsCustom itemsCustom=itemsService.findItemsById(id);
        return itemsCustom;
    }

//    商品分类
//    itemTypes表示最终的返回值放在request中的key
    @ModelAttribute("itemTypes")
    public Map<String,String>getItemsTypes(){
        Map<String,String>itemTypes=new HashMap<String,String>();
        itemTypes.put("101","数码");
        itemTypes.put("102","母婴");
        return itemTypes;
    }
}
