package zb.mall.core.service;

import com.baomidou.mybatisplus.extension.service.IService;
import zb.mall.core.entity.MallUser;

public interface MallUserService extends IService<MallUser> {
    boolean register(String loginName, String passWord) throws Exception;
}
