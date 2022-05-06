package zb.mall.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import zb.mall.core.dao.CouponUserDao;
import zb.mall.core.entity.vo.CouponUser;
import zb.mall.core.service.CouponUserService;

@Service
public class CouponUserServiceImpl extends ServiceImpl<CouponUserDao, CouponUser> implements CouponUserService {
}
