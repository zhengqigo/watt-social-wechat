package org.fuelteam.watt.social.wechat.api;

import org.springframework.social.ApiBinding;
import org.springframework.web.client.RestOperations;

public interface Wechat extends ApiBinding {

    UserOperations userOperations();

    RestOperations restOperations();
}
