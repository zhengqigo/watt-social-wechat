package org.fuelteam.watt.social.wechat.connect;

import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;

public class WechatAdapter<T> implements ApiAdapter<T> {

    @Override
    public boolean test(T api) {
        return false;
    }

    @Override
    public void setConnectionValues(T api, ConnectionValues values) {}

    @Override
    public UserProfile fetchUserProfile(T api) {
        return null;
    }

    @Override
    public void updateStatus(T api, String message) {}
}
