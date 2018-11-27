package com.example.springbootrippledemo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author xinj.x
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "xrp.deposit")
public class XRPAccountProperties {
    private String address;
    private String secret;
}
