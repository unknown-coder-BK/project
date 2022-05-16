package zb.mall.controller.mall;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("seckill")
public class SeckillController {

    @GetMapping("/list")
    public String listPage(){
        return "mall/seckill-list";
    }
}
