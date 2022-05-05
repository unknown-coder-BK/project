package zb.mall.pojo.user;

import lombok.Data;

import javax.validation.GroupSequence;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class MallUserReq {
    @Size(min = 1, max = 20, message = "手机号在1-20个字符之间", groups = LoginName.class)
    String loginName;

    @Size(min = 1, max = 20, message = "密码在1-20个字符之间", groups = Password.class)
    String passWord;

    @NotBlank(message = "验证码不能为空", groups = VerifyCode.class)
    String verifyCode;

    public interface LoginName {
    }

    public interface Password {

    }

    public interface VerifyCode {

    }

    /**
     * 顺序分组
     */
    @GroupSequence({LoginName.class, Password.class, VerifyCode.class})
    public interface Register {
    }
}
