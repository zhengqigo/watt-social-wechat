package org.fuelteam.watt.social.wechat.autoconfigurer;

import org.fuelteam.watt.social.wechat.api.WechatMp;
import org.fuelteam.watt.social.wechat.connect.WechatMpConnectionFactory;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.autoconfigure.social.SocialAutoConfigurerAdapter;
import org.springframework.boot.autoconfigure.social.SocialWebAutoConfiguration;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.config.annotation.EnableSocial;
import org.springframework.social.config.annotation.SocialConfigurerAdapter;
import org.springframework.social.connect.ConnectionFactory;

@Configuration
@ConditionalOnClass({ SocialConfigurerAdapter.class, WechatMpConnectionFactory.class })
@AutoConfigureBefore(SocialWebAutoConfiguration.class)
@AutoConfigureAfter(WebMvcAutoConfiguration.class)
@EnableConfigurationProperties(WechatMpProperties.class)
public class WechatMpAutoConfiguration {

    @Configuration
    @EnableSocial
    @EnableConfigurationProperties(WechatMpProperties.class)
    @ConditionalOnWebApplication
    protected static class WechatConfigurerAdapter extends SocialAutoConfigurerAdapter {

        private final WechatMpProperties properties;

        public WechatConfigurerAdapter(WechatMpProperties properties) {
            super();
            this.properties = properties;
        }

        @Override
        protected ConnectionFactory<WechatMp> createConnectionFactory() {
            WechatMpConnectionFactory factory = new WechatMpConnectionFactory(this.properties.getAppId(),
                    this.properties.getAppSecret());
            factory.setScope(this.properties.getScope());
            return factory;
        }
    }
}
