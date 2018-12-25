package org.fuelteam.watt.social.wechat.api.impl;

import org.fuelteam.watt.social.wechat.WechatMappingJackson2HttpMessageConverter;
import org.fuelteam.watt.social.wechat.api.UserOperations;
import org.fuelteam.watt.social.wechat.api.UserTemplate;
import org.fuelteam.watt.social.wechat.api.Wechat;
import org.fuelteam.watt.social.wechat.utils.TemplateUtil;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.oauth2.OAuth2Version;
import org.springframework.social.oauth2.TokenStrategy;
import org.springframework.social.support.ClientHttpRequestFactorySelector;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

public class WechatImpl extends AbstractOAuth2ApiBinding implements Wechat {

    private UserOperations userOperations;

    public WechatImpl(String accessToken) {
        super(accessToken, TokenStrategy.ACCESS_TOKEN_PARAMETER);
        userOperations = new UserTemplate(TemplateUtil.addHttpMessageConverter(getRestTemplate(),
                new WechatMappingJackson2HttpMessageConverter()), accessToken);
    }

    @Override
    public UserOperations userOperations() {
        return userOperations;
    }

    @Override
    public RestOperations restOperations() {
        return getRestTemplate();
    }

    @Override
    public void setRequestFactory(ClientHttpRequestFactory requestFactory) {
        super.setRequestFactory(ClientHttpRequestFactorySelector.bufferRequests(requestFactory));
    }

    @Override
    protected OAuth2Version getOAuth2Version() {
        return OAuth2Version.BEARER_DRAFT_2;
    }

    @Override
    protected void configureRestTemplate(RestTemplate restTemplate) {
        super.configureRestTemplate(restTemplate);
        restTemplate.setErrorHandler(new WechatErrorHandler());
    }
}
