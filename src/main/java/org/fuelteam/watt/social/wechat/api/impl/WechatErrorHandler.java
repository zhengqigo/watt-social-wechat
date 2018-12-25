package org.fuelteam.watt.social.wechat.api.impl;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.social.UncategorizedApiException;
import org.springframework.web.client.DefaultResponseErrorHandler;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class WechatErrorHandler extends DefaultResponseErrorHandler {

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        if (HttpStatus.Series.CLIENT_ERROR.equals(response.getStatusCode().series())) {
            Map<String, Object> errorDetails = extractErrorDetailsFromResponse(response);
            String errmsg = errorDetails.containsKey("errmsg") ? (String) errorDetails.get("errmsg") : "unknown";
            throw new UncategorizedApiException("wechat", errmsg, null);
        }
        handleUncategorizedError(response);
    }

    private void handleUncategorizedError(ClientHttpResponse response) {
        try {
            super.handleError(response);
        } catch (Exception ex) {
            throw new UncategorizedApiException("wechat", "error consuming wechat api", ex);
        }
    }

    private Map<String, Object> extractErrorDetailsFromResponse(ClientHttpResponse response) throws IOException {
        try {
            return new ObjectMapper(new JsonFactory()).<Map<String, Object>>readValue(response.getBody(),
                    new TypeReference<Map<String, Object>>() {});
        } catch (JsonParseException jpe) {
            return Collections.emptyMap();
        }
    }
}
