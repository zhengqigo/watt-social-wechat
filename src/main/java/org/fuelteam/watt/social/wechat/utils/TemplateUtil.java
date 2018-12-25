package org.fuelteam.watt.social.wechat.utils;

import java.util.List;

import org.fuelteam.watt.social.wechat.WechatMappingJackson2HttpMessageConverter;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.social.support.FormMapHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.google.common.collect.Lists;

public class TemplateUtil {

    public static RestTemplate addHttpMessageConverter(RestTemplate restTemplate,
            HttpMessageConverter<?> httpMessageConverter) {
        List<HttpMessageConverter<?>> converters = Lists.newLinkedList();
        converters.add(new FormHttpMessageConverter());
        converters.add(new FormMapHttpMessageConverter());
        converters.add(new WechatMappingJackson2HttpMessageConverter());
        restTemplate.setMessageConverters(converters);
        return restTemplate;
    }
}