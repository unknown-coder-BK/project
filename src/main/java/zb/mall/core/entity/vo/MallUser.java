package zb.mall.core.entity.vo;

import lombok.Data;

import java.util.Date;

@Data
public class MallUser {

    private Long userId;

    private String nickName;

    private String loginName;

    private String passwordMd5;

    private String introduceSign;

    private String address;

    private Byte isDeleted;

    private Byte lockedFlag;

    private Date createTime;
}
