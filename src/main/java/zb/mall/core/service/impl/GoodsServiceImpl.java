package zb.mall.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import zb.mall.core.dao.GoodsDao;
import zb.mall.core.entity.vo.Goods;
import zb.mall.core.service.GoodsService;

@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsDao, Goods> implements GoodsService {

}
