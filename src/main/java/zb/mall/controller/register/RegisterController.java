package zb.mall.controller.register;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegisterController {

    @RequestMapping(value = "register")
    public String registerPage(){
        return "mall/register";
    }
}
