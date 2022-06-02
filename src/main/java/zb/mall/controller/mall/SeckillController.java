package zb.mall.controller.mall;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import zb.mall.constans.Constants;
import zb.mall.core.entity.Seckill;
import zb.mall.core.entity.vo.Goods;
import zb.mall.core.service.GoodsService;
import zb.mall.core.service.SeckillService;
import zb.mall.redis.RedisCache;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("seckill")
public class SeckillController {
    @Resource
    private RedisCache redisCache;

    @Resource
    private SeckillService seckillService;

    @Resource
    private GoodsService goodsService;

    @Resource
    private ThymeleafViewResolver thymeleafViewResolver;

    @GetMapping("/list")
    @ResponseBody
    public String listPage(HttpServletRequest request, HttpServletResponse response, Model model){
        List<Seckill> seckillList = seckillService.list(new QueryWrapper<Seckill>().eq("status", 1).orderByDesc("seckill_rank"));
        List<Map<String, Object>> list = seckillList.stream().map(seckillGood -> {
            HashMap<String, Object> map = new HashMap<>();
            map.put("seckillId", seckillGood.getSeckillId());
            map.put("goodsId", seckillGood.getGoodsId());
            map.put("seckillPrice", seckillGood.getSeckillPrice());
            Goods goods = goodsService.getById(seckillGood.getGoodsId());
            map.put("goodsName", goods.getGoodsName());
            map.put("originalPrice", goods.getOriginalPrice());
            map.put("goodsCoverImg", goods.getGoodsCoverImg());
            map.put("goodsIntro", goods.getGoodsIntro());
            return map;
        }).collect(Collectors.toList());
        //themeleaf jar
        request.setAttribute("seckillList", list);
        WebContext ctx = new WebContext(request, response, request.getServletContext(), request.getLocale(), model.asMap());
        String html = thymeleafViewResolver.getTemplateEngine().process("mall/seckill-list", ctx);
        return html;
    }

    @GetMapping("detail/{seckillId}")
    @ResponseBody
    public String detailPage(@PathVariable("seckillId") Long seckillId,
                             HttpServletRequest request,
                             HttpServletResponse response,
                             Model model){
        WebContext ctx = new WebContext(request, response, request.getServletContext(), request.getLocale(), model.asMap());
        String html = thymeleafViewResolver.getTemplateEngine().process("mall/seckill-detail", ctx);
        return html;
    }

}
