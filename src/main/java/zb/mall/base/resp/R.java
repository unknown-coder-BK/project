package zb.mall.base.resp;

public class R {
    private int code;
    private String msg;

    public static R error(String msg){
        R r = new R();
        r.code = 500;
        r.msg = msg;
        return r;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
