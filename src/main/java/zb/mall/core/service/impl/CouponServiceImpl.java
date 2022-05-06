package zb.mall.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import zb.mall.core.dao.CouponDao;
import zb.mall.core.entity.vo.Coupon;
import zb.mall.core.service.CouponService;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Service
public class CouponServiceImpl extends ServiceImpl<CouponDao, Coupon> implements CouponService {
    @Override
    public Date calculateEndDate(Short days) {
        LocalDate startLocalDate = LocalDate.now();
        LocalDate endLocalDate = startLocalDate.plusDays(days);
        ZoneId zone = ZoneId.systemDefault();
        System.out.println(startLocalDate);
        System.out.println(endLocalDate);
        System.out.println(endLocalDate.atStartOfDay());
        System.out.println(endLocalDate.atStartOfDay().atZone(zone));
        System.out.println(endLocalDate.atStartOfDay().atZone(zone).toInstant());
        return Date.from(endLocalDate.atStartOfDay().atZone(zone).toInstant());
    }
}
