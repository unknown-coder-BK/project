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

    public static R error() {
        R r = new R();
        r.code = 500;
        r.msg = "请求失败";
        return r;
    }


    public static R success() {
        R r = new R();
        r.code = 200;
        r.msg = "请求成功";
        return r;
    }

    public static R result(boolean result) {
        return result ? success() : error();
    }


    public static R result(boolean result, String errorMessage) {
        return result ? success() : error(errorMessage);
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
