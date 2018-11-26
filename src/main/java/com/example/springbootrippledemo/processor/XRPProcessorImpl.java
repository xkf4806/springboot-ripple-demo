package com.example.springbootrippledemo.processor;

import com.ripple.client.Client;
import com.ripple.client.enums.Command;
import com.ripple.client.pubsub.Publisher;
import com.ripple.client.requests.Request;
import com.ripple.client.responses.Response;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * ripple接口服务
 * @author xj.x
 * @date 2018-11-25 23:55
 */
@Slf4j
@Component
public class XRPProcessorImpl implements XRPProcessor{

    private final Client client;

    @Autowired
    public XRPProcessorImpl(Client client) {
        this.client = client;
    }

    @Override
    public void requestServerInfo(Publisher.Callback<JSONObject> callback) {
        // TODO callback需自定义实现
        client.requestServerInfo(callback);
    }

    @Override
    public void requestAccountInfo(String address, Publisher.Callback<String> callback) {
        // TODO callback需自定义实现
        client.requestAccountInfo(address, callback);
    }

    @Override
    public void ping() {
        client.makeManagedRequest(Command.ping, new Request.Manager<JSONObject>() {
            @Override
            public void cb(Response response, JSONObject object) throws JSONException {
                log.info("ping结果：{}", object);
            }
        }, new Request.Builder<JSONObject>() {
            @Override
            public void beforeRequest(Request request) {

            }

            @Override
            public JSONObject buildTypedResponse(Response response) {
                return response.message;
            }
        });
    }

    @Override
    public void random() {
        client.makeManagedRequest(Command.random, new Request.Manager<JSONObject>() {
            @Override
            public void cb(Response response, JSONObject o) throws JSONException {
                log.info("random response: {}", o);
            }
        }, new Request.Builder<JSONObject>() {
            @Override
            public void beforeRequest(Request request) {

            }

            @Override
            public JSONObject buildTypedResponse(Response response) {
                return response.message;
            }
        });
    }

    @Override
    public void ledger() {
        client.makeManagedRequest(Command.ledger, new Request.Manager<JSONObject>() {
            @Override
            public void cb(Response response, JSONObject o) throws JSONException {
                log.info("validated Ledger info: {}", o);
            }
        }, new Request.Builder<JSONObject>() {
            @Override
            public void beforeRequest(Request request) {
                request.json("ledger_index","validated");
            }

            @Override
            public JSONObject buildTypedResponse(Response response) {
                return response.message;
            }
        });
    }

    /**
     * 生成钱包地址，密钥
     */
    @Override
    public void walletPropose() {
        client.makeManagedRequest(Command.wallet_propose, new Request.Manager<JSONObject>() {
            @Override
            public void cb(Response response, JSONObject o) throws JSONException {
                log.info("wallet propose info: {}", o);
            }
        }, new Request.Builder<JSONObject>() {
            @Override
            public void beforeRequest(Request request) {

            }

            @Override
            public JSONObject buildTypedResponse(Response response) {
                return response.message;
            }
        });
    }
}
