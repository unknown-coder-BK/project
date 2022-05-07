package zb.mall.controller.user;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import zb.mall.base.resp.R;
import zb.mall.constans.Constants;
import zb.mall.core.service.MallUserService;
import zb.mall.pojo.user.MallUserReq;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String loginPage(){
        return "mall/login";
    }


//    @Autowired
//    MallUserService mallUserService;
//
//    @ResponseBody
//    @PostMapping("/login")
//    public R doLogin(@RequestBody @Validated(value = {MallUserReq.Login.class}) MallUserReq req, HttpSession session) {
//        R success = R.success();
//        String loginName = req.getLoginName();
//        String passWord = req.getPassWord();
//        String verifyCode = req.getVerifyCode();
//        String kaptchaCode = (String) session.getAttribute(Constants.MALL_VERIFY_CODE_KEY);
//        if (!StringUtils.equalsIgnoreCase(verifyCode, kaptchaCode)) {
//            return R.error("验证码错误");
//        }
//        mallUserService.getOne(Wrappers.lambdaQuery())
//
//    }
}
