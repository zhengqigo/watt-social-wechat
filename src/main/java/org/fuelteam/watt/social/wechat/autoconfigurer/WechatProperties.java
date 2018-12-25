package org.fuelteam.watt.social.wechat.autoconfigurer;

import org.springframework.boot.autoconfigure.social.SocialProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "spring.social.wechat")
public class WechatProperties extends SocialProperties {

    private String scope = "snsapi_login";

    public String getScope() {
        return scope;
    }
}
