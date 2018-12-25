package org.fuelteam.watt.social.wechat.api;

import org.fuelteam.watt.social.wechat.UrlConstants;
import org.fuelteam.watt.social.wechat.WechatLangEnum;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestOperations;

public class UserTemplate implements UserOperations {

    private RestOperations restOperations;

    private String accessToken;

    public UserTemplate(RestOperations restOperations, String accessToken) {
        super();
        this.restOperations = restOperations;
        this.accessToken = accessToken;
    }

    @Override
    public User getUserProfile(String openId) {
        return getUserProfile(openId, WechatLangEnum.EN);
    }

    @Override
    public User getUserProfile(String openId, WechatLangEnum lang) {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>(3);
        params.add("openid", openId);
        params.add("lang", lang.getValue());
        params.add("access_token", accessToken);
        return restOperations.postForObject(UrlConstants.USERINFO_API_URL, params, User.class);
    }
}
