package com.example.springbootrippledemo;

import com.example.springbootrippledemo.processor.XRPProcessor;
import com.example.springbootrippledemo.service.CoinXrpService;
import com.ripple.client.Client;
import com.ripple.client.responses.Response;
import com.ripple.client.transactions.AccountTxPager;
import com.ripple.core.coretypes.AccountID;
import com.ripple.core.types.known.tx.result.TransactionResult;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SpringbootRippleDemoApplicationTests {

    @Autowired
    private XRPProcessor xrpProcessor;

    @Test
    public void testQueryServerInfo() {
        xrpProcessor.requestServerInfo(System.out::println);
    }

    @Test
    public void testPing() {
        xrpProcessor.ping();
    }

    @Test
    public void testRandom() {
        xrpProcessor.random();
    }

    @Test
    public void testLedger() {
        xrpProcessor.ledger();
    }

    @Test
    public void testWalletPropose() {
        xrpProcessor.walletPropose();
    }

    @Test
    public void testSign() {
        xrpProcessor.sign("rwXh8Pgx1C5VBPkr8xyMDB7SqeP9z5nMvR", 2.89);
    }
}
