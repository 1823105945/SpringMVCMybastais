package cn.itcast.ssm.controller;

import cn.itcast.ssm.po.ItemsCustom;
import cn.itcast.ssm.po.ItemsQueryVo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class JsonTest {

    @RequestMapping("/jsonTest")
    public String queryItems(Model model)throws Exception{

        return "/jsonTest";
    }

//    请求json输出json
//    @RequestBody将请求的json串转成ItemsCustom对象
//    @ResponseBody把ItemsCustom转成json串
    @RequestMapping(value = "/requestJson")
    public @ResponseBody ItemsCustom requestJson(@RequestBody ItemsCustom itemsCustom){

        return itemsCustom;
    }


    @RequestMapping(value = "/responseJson")
    public @ResponseBody ItemsCustom responseJson(ItemsCustom itemsCustom){

        return itemsCustom;
    }
}
