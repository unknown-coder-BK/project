package zb.mall.controller.register;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import zb.mall.controller.base.resp.R;
import zb.mall.controller.pojo.user.MallUserReq;

import javax.servlet.http.HttpSession;

@Controller
public class RegisterController {

    @GetMapping(value = "register")
    public String registerPage(){
        return "mall/register";
    }

    @RequestMapping(value = "register",method = RequestMethod.POST)
    @ResponseBody
    public R register(@RequestBody MallUserReq req,  HttpSession session){
        return R.error("验证码错误");
    }

}
