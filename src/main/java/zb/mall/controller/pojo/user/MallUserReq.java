package zb.mall.controller.pojo.user;

import lombok.Data;

@Data
public class MallUserReq {
    String loginName;
    String verifyCode;
    String passWord;
}
