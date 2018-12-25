package org.fuelteam.watt.social.wechat;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import com.google.common.collect.Lists;

public class WechatMappingJackson2HttpMessageConverter extends MappingJackson2HttpMessageConverter {

    public WechatMappingJackson2HttpMessageConverter() {
        List<MediaType> mediaTypes = Lists.newLinkedList();
        mediaTypes.add(MediaType.TEXT_PLAIN);
        setSupportedMediaTypes(mediaTypes);
    }
}
