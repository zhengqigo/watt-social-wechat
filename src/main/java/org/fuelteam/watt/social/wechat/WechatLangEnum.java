package org.fuelteam.watt.social.wechat;

public enum WechatLangEnum {

    CN("zh-CN"), EN("en");

    private WechatLangEnum(String value) {
        this.value = value;
    }

    private String value;

    public String getValue() {
        return value;
    }
}
