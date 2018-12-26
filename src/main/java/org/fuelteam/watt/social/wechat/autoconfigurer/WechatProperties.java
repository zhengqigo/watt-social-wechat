package org.fuelteam.watt.social.wechat.autoconfigurer;

import org.springframework.boot.autoconfigure.social.SocialProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

// 微信开放平台
@ConfigurationProperties(WechatProperties.Prefix)
public class WechatProperties extends SocialProperties {

    protected final static String Prefix = "spring.social.wechat";

    private String scope = "snsapi_login";

    public String getScope() {
        return scope;
    }
}
