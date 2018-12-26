package org.fuelteam.watt.social.wechat.autoconfigurer;

import org.springframework.boot.autoconfigure.social.SocialProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

// 微信公众平台,需在微信中打开,测试号验证通过:网页授权获取用户基本信息->授权回调页面域名
@ConfigurationProperties(WechatMpProperties.Prefix)
public class WechatMpProperties extends SocialProperties {

    protected final static String Prefix = "spring.social.wechatmp";

    private String scope = "snsapi_userinfo";

    public String getScope() {
        return scope;
    }
}
