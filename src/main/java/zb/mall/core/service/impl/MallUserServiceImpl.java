package zb.mall.core.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zb.mall.base.resp.R;
import zb.mall.core.dao.MallUserDao;
import zb.mall.core.entity.vo.Coupon;
import zb.mall.core.entity.vo.CouponUser;
import zb.mall.core.entity.vo.MallUser;
import zb.mall.core.service.CouponService;
import zb.mall.core.service.CouponUserService;
import zb.mall.core.service.MallUserService;
import zb.mall.util.security.Md5Utils;

import javax.print.DocFlavor;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class MallUserServiceImpl extends ServiceImpl<MallUserDao, MallUser> implements MallUserService {
    @Autowired
    CouponService couponService;

    @Autowired
    CouponUserService couponUserService;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean register(String loginName, String passWord) {
        MallUser mallUser = new MallUser();
        mallUser.setLoginName(loginName);
        mallUser.setNickName(UUID.randomUUID().toString().substring(0, 5));
        mallUser.setPasswordMd5(Md5Utils.hash(passWord));
        if (!save(mallUser)) {
            return false;
        }
        List<Coupon> coupons = couponService.list(Wrappers.<Coupon>lambdaQuery().eq(Coupon::getCouponType, 1));
        List<CouponUser> CouponUserList = coupons.stream().map(coupon -> {
            CouponUser couponUser = new CouponUser();
            couponUser.setUserId(mallUser.getUserId());
            couponUser.setCouponId(coupon.getCouponId());
            couponUser.setStartTime(new Date());
            couponUser.setEndTime(couponService.calculateEndDate(coupon.getDays()));
            return couponUser;
        }).collect(Collectors.toList());
        return couponUserService.saveBatch(CouponUserList);
    }
}
