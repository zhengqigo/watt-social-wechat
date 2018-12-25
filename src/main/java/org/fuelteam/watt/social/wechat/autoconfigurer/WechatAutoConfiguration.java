package org.fuelteam.watt.social.wechat.autoconfigurer;

import org.fuelteam.watt.social.wechat.api.Wechat;
import org.fuelteam.watt.social.wechat.connect.WechatConnectionFactory;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
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
@ConditionalOnClass({ SocialConfigurerAdapter.class, WechatConnectionFactory.class })
@ConditionalOnProperty(prefix = "spring.social.wechat", name = "app-id")
@AutoConfigureBefore(SocialWebAutoConfiguration.class)
@AutoConfigureAfter(WebMvcAutoConfiguration.class)
public class WechatAutoConfiguration {

    @Configuration
    @EnableSocial
    @EnableConfigurationProperties(WechatProperties.class)
    @ConditionalOnWebApplication
    protected static class WechatConfigurerAdapter extends SocialAutoConfigurerAdapter {

        private final WechatProperties properties;

        public WechatConfigurerAdapter(WechatProperties properties) {
            super();
            this.properties = properties;
        }

        @Override
        protected ConnectionFactory<Wechat> createConnectionFactory() {
            WechatConnectionFactory factory = new WechatConnectionFactory(this.properties.getAppId(),
                    this.properties.getAppSecret());
            factory.setScope(this.properties.getScope());
            return factory;
        }
    }
}
