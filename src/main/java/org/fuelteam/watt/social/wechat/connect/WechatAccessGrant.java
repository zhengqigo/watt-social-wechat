package org.fuelteam.watt.social.wechat.connect;

import org.springframework.social.oauth2.AccessGrant;

public class WechatAccessGrant extends AccessGrant {

    private static final long serialVersionUID = 1L;

    private String openid;

    private String unionid;

    public WechatAccessGrant(String accessToken, String scope, String refreshToken, Long expiresIn, String openId,
            String unionId) {
        super(accessToken, scope, refreshToken, expiresIn);
        this.openid = openId;
        this.unionid = unionId;
    }

    public String getOpenid() {
        return openid;
    }

    public String getUnionid() {
        return unionid;
    }
}
