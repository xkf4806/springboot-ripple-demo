package com.example.springbootrippledemo.config;

import com.ripple.client.Client;
import com.ripple.client.transport.WebSocketTransport;
import com.ripple.client.transport.impl.JavaWebSocketTransportImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xinj.x
 */
@Configuration
public class RippleConfig {

    @Value("${ripple.server.url}")
    private String connectURI;

    @Bean
    public Client client() {
        return new Client(webSocketTransport()).connect(connectURI);
    }

    @Bean
    public WebSocketTransport webSocketTransport() {
        return new JavaWebSocketTransportImpl();
    }
}
