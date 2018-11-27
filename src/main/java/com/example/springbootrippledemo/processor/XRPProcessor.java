package com.example.springbootrippledemo.processor;

import com.ripple.client.pubsub.Publisher;
import org.json.JSONObject;

/**
 * @author xinj.x
 */
public interface XRPProcessor {
    /**
     * 查询rippled服务器状态
     * @param callback
     */
    void requestServerInfo(Publisher.Callback<JSONObject> callback);

    void requestAccountInfo(String address, Publisher.Callback<String> callback);

    void ping();

    void random();

    void ledger();

    void walletPropose();

    /**
     * only for development and test
     */
    void submit(String toAddress, double value);

    void sign(String toAddress, double value);
}
