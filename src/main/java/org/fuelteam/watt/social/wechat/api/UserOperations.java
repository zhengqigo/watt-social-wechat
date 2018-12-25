package org.fuelteam.watt.social.wechat.api;

import org.fuelteam.watt.social.wechat.WechatLangEnum;

public interface UserOperations {

    User getUserProfile(String openId);

    User getUserProfile(String openId, WechatLangEnum lang);
}
