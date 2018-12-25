package org.fuelteam.watt.social.wechat.autoconfigurer;

import org.springframework.boot.autoconfigure.social.SocialProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "spring.social.wechatmp")
public class WechatMpProperties extends SocialProperties {

    private String scope = "snsapi_userinfo";

    public String getScope() {
        return scope;
    }
}
