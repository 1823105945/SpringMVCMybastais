package cn.itcast.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @RequestMapping(value = "/loginIndex")
    public String loginIndex()throws Exception{

        return "/login";
    }

//    登录
    @RequestMapping(value = "/login")
    public String login(HttpSession session,String username,String password)throws Exception{
//          调用server进行身份认证
//        把session中保存用胡身份信息
        session.setAttribute("username",username);
        //        redirect重定向到指定页面
        return "redirect:/items/queryItems";
    }

//    退出
    @RequestMapping(value = "/logout")
    public String logout(HttpSession session)throws Exception{
//        清除session
        session.invalidate();
        //        redirect重定向到指定页面
        return "redirect:/items/queryItems";
    }
}
