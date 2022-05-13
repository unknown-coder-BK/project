package zb.mall.controller.user;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import zb.mall.base.resp.R;
import zb.mall.constans.Constants;
import zb.mall.core.entity.vo.MallUser;
import zb.mall.core.service.MallUserService;
import zb.mall.pojo.user.MallUserReq;
import zb.mall.util.security.Md5Utils;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    MallUserService mallUserService;


    @GetMapping("/login")
    public String loginPage(){
        return "mall/login";
    }


    @ResponseBody
    @PostMapping("/login")
    public R doLogin(@RequestBody @Validated(value = {MallUserReq.Login.class}) MallUserReq req, HttpSession session) {
        String loginName = req.getLoginName();
        String passWord = req.getPassWord();
        String verifyCode = req.getVerifyCode();
        String kaptchaCode = (String) session.getAttribute(Constants.MALL_VERIFY_CODE_KEY);
        if (!StringUtils.equalsIgnoreCase(verifyCode, kaptchaCode)) {
            return R.error("验证码错误");
        }
        MallUser user = mallUserService.getOne(Wrappers.<MallUser>lambdaQuery().eq(MallUser::getLoginName, loginName).eq(MallUser::getPasswordMd5, Md5Utils.hash(passWord)).last("limit 1"));
        if(user == null){
            return R.error("账户名或者密码错误");
        }
        session.setAttribute(Constants.MALL_USER_SESSION_KEY, req);
        return R.success();
    }
}
