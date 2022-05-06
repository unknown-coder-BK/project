package zb.mall.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import zb.mall.core.dao.CouponDao;
import zb.mall.core.entity.vo.Coupon;
import zb.mall.core.service.CouponService;

@Service
public class CouponServiceImpl extends ServiceImpl<CouponDao, Coupon> implements CouponService {
}
