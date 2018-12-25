package org.fuelteam.watt.social.wechat.connect;

import org.fuelteam.watt.social.wechat.UrlConstants;
import org.fuelteam.watt.social.wechat.api.Wechat;
import org.fuelteam.watt.social.wechat.api.impl.WechatImpl;
import org.fuelteam.watt.social.wechat.connect.WechatOAuth2Template;
import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;
import org.springframework.social.oauth2.OAuth2Template;

public class WechatServiceProvider<T extends Wechat> extends AbstractOAuth2ServiceProvider<T> {

    public WechatServiceProvider(String appId, String appSecret) {
        super(getOAuth2Template(appId, appSecret, UrlConstants.QRCONNECT_API_URL));
    }

    public WechatServiceProvider(String appId, String appSecret, String authorizeUrl) {
        super(getOAuth2Template(appId, appSecret, authorizeUrl));
    }

    private static OAuth2Template getOAuth2Template(String appId, String appSecret, String authorizeUrl) {
        OAuth2Template oauth2Template = new WechatOAuth2Template(appId, appSecret, authorizeUrl,
                UrlConstants.ACCESS_TOKEN_API_URL);
        oauth2Template.setUseParametersForClientAuthentication(true);
        return oauth2Template;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T getApi(String accessToken) {
        return (T) new WechatImpl(accessToken);
    }
}