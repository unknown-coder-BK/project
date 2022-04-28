package zb.mall.controller.common;

import com.wf.captcha.ArithmeticCaptcha;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static zb.mall.constans.Constants.MALL_VERIFY_CODE_KEY;

@Controller
public class CommonController {
    @RequestMapping("common/captcha")
    public void captcha(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ArithmeticCaptcha captcha = new ArithmeticCaptcha(130, 48);
        captcha.setLen(2);//两位运算
        //request存key
        request.getSession().setAttribute(MALL_VERIFY_CODE_KEY, captcha.text().toLowerCase()); //captcha.text() 运算结果
        //输出图片流
        captcha.out(response.getOutputStream());
    }

}
