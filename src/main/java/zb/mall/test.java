package zb.mall;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class test {
    public static void main(String[] args) {
        try {
            String postURL = "http://bst.8315.cn:9892/cmppweb/sendsms";
            PostMethod postMethod = new PostMethod(postURL) ;
            postMethod.setRequestHeader("Accept","text/plain");
            postMethod.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8") ;
            //参数设置，需要注意的就是里边不能传NULL，要传空字符串
            NameValuePair[] data = {
                    new NameValuePair("uid", "175358"),
                    new NameValuePair("pwd", sign("Wytx2022@Whdy", "", "utf-8")),
                    new NameValuePair("mobile","13437269833"),
                    new NameValuePair("srcphone","10690123456"),
                    new NameValuePair("msg",URLEncoder.encode("【博士通】测试短信。", "UTF-8")),
            };
            postMethod.setRequestBody(data);
            org.apache.commons.httpclient.HttpClient httpClient = new org.apache.commons.httpclient.HttpClient();
            httpClient.executeMethod(postMethod); // 执行POST方法
            String result = postMethod.getResponseBodyAsString() ;
            System.out.println(result);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static String sign(String text, String key, String input_charset) {
        text = text + key;
        return DigestUtils.md5Hex(getContentBytes(text, input_charset));
    }

    private static byte[] getContentBytes(String content, String charset) {
        if (charset == null || "".equals(charset)) {
            return content.getBytes();
        }
        try {
            return content.getBytes(charset);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("MD5签名过程中出现错误,指定的编码集不对,您目前指定的编码集是:" + charset);
        }
    }
}
