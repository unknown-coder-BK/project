package zb.mall.controller.mall;

import org.springframework.data.redis.cache.RedisCache;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("seckill")
public class SeckillController {
    @Resource
    private RedisCache redisCache;

    @GetMapping("/list")
    public String listPage(HttpServletRequest request, HttpServletResponse response, Model model){
        return "mall/seckill-list";
    }
}
