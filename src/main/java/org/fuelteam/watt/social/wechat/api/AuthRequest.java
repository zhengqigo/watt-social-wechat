package org.fuelteam.watt.social.wechat.api;

public class AuthRequest {

    public String accessToken;

    public String openid;

    public AuthRequest(String accessToken, String openid) {
        super();
        this.accessToken = accessToken;
        this.openid = openid;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }
}
