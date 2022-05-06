package zb.mall.core.service;

import com.baomidou.mybatisplus.extension.service.IService;
import zb.mall.core.entity.vo.Coupon;

import java.util.Date;

public interface CouponService extends IService<Coupon> {

    /**
     * 计算优惠劵有效期结束时间
     * @param days 优惠劵可用天数
     */
    Date calculateEndDate(Short days);
}
