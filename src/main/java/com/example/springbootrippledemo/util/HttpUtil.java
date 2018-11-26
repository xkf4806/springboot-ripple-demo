package com.example.springbootrippledemo.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.SimpleHttpConnectionManager;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

import java.util.Map;

/**
 * @author xinj.x
 */
@Slf4j
public class HttpUtil {
    public static String postHttp(String url, Map<String, String> map) {
        HttpClient httpclient = null;
        PostMethod post = null;
        SimpleHttpConnectionManager simpleHttpConnectionManager;
        String info = null;
        try {
            httpclient = new HttpClient();
            post = new PostMethod(url);
            // 设置编码方式
            post.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");
            httpclient.getHttpConnectionManager().getParams().setConnectionTimeout(30000);
            httpclient.getHttpConnectionManager().getParams().setSoTimeout(30000);
            // 添加参数
            if (map != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    String key = entry.getKey();
                    post.addParameter(key, entry.getValue());
                }
            }
            // 执行
            httpclient.executeMethod(post);
            // 接口返回信息
            info = new String(post.getResponseBody(), "UTF-8");
        } catch (Exception e) {
            log.error("异常发生", e);
        } finally {
            // 关闭连接，释放资源
            if (post != null) {
                post.releaseConnection();
            }
            if (httpclient != null) {
                simpleHttpConnectionManager = ((SimpleHttpConnectionManager) httpclient.getHttpConnectionManager());
                if (simpleHttpConnectionManager != null) {
                    simpleHttpConnectionManager.shutdown();
                }
            }

        }
        return info;
    }
}
