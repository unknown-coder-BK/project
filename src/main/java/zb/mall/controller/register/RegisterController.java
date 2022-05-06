package zb.mall.controller.register;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import zb.mall.base.resp.R;
import zb.mall.constans.Constants;
import zb.mall.pojo.user.MallUserReq;

import javax.servlet.http.HttpSession;

@Controller
public class RegisterController {

    @GetMapping(value = "register")
    public String registerPage(){
        return "mall/register";
    }

    @RequestMapping(value = "register",method = RequestMethod.POST)
    @ResponseBody
    public R register(@RequestBody @Validated(value = {MallUserReq.Register.class}) MallUserReq req, HttpSession session){
        String mobilePhone = req.getLoginName();
        String passWord = req.getPassWord();
        String verifyCode = req.getVerifyCode();
        String captchaCode = (String)session.getAttribute(Constants.MALL_VERIFY_CODE_KEY);
        if(!StringUtils.equalsIgnoreCase(verifyCode,captchaCode)){
            return R.error("验证码错误");
        }

        return null;
    }
}
