package zb.mall;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import zb.mall.core.dao.MallUserDao;
import zb.mall.core.entity.Coupon;
import zb.mall.core.entity.CouponUser;
import zb.mall.core.entity.MallUser;
import zb.mall.core.service.CouponService;
import zb.mall.core.service.CouponUserService;
import zb.mall.core.service.MallUserService;

import java.util.Date;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DaoTest {
    @Autowired
    MallUserDao mallUserDao;

    @Autowired
    MallUserService mallUserService;


    @Autowired
    CouponService couponService;

    @Autowired
    CouponUserService couponUserService;
    @Test
    public void test1(){
        List<MallUser> mallUsers = mallUserDao.selectList(null);
        System.out.println(mallUsers);
    }

    @Test
    public void test2(){
        List<MallUser> list = mallUserService.list(null);
        System.out.println(list);
    }

    @Test
    public void test3(){
        List<Coupon> list = couponService.list(null);
        System.out.println(list);
    }

    @Test
    public void test4(){
        List<CouponUser> list = couponUserService.list(null);
        System.out.println(list);
    }

    @Test
    public void test5(){
        Date date = couponService.calculateEndDate((short) 1);
        System.out.println(date);
    }
}
