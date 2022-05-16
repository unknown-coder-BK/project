package zb.mall.core.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("tb_newbee_mall_coupon_user")
public class CouponUser{
    private Long couponUserId;

    private Long userId;

    private Long couponId;

    private Byte status;

    private Date usedTime;

    private Date startTime;

    private Date endTime;

    private Long orderId;

    private Date createTime;

    private Date updateTime;

    private Byte isDeleted;
}
