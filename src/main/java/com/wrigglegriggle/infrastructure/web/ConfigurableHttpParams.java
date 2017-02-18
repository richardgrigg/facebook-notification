package com.wrigglegriggle.infrastructure.web;

import org.apache.http.client.params.ClientPNames;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.CoreConnectionPNames;

public class ConfigurableHttpParams extends BasicHttpParams {

    /*
        CoreProtocolPNames.PROTOCOL_VERSION
        CoreProtocolPNames.STRICT_TRANSFER_ENCODING
        CoreProtocolPNames.HTTP_ELEMENT_CHARSET
        CoreProtocolPNames.USE_EXPECT_CONTINUE
        CoreProtocolPNames.WAIT_FOR_CONTINUE
        CoreProtocolPNames.USER_AGENT
        CoreConnectionPNames.TCP_NODELAY
        CoreConnectionPNames.SO_TIMEOUT
        CoreConnectionPNames.SO_LINGER
        CoreConnectionPNames.SO_REUSEADDR
        CoreConnectionPNames.SOCKET_BUFFER_SIZE
        CoreConnectionPNames.CONNECTION_TIMEOUT
        CoreConnectionPNames.MAX_LINE_LENGTH
        CoreConnectionPNames.MAX_HEADER_COUNT
        CoreConnectionPNames.STALE_CONNECTION_CHECK
        ConnRoutePNames.FORCED_ROUTE
        ConnRoutePNames.LOCAL_ADDRESS
        ConnRoutePNames.DEFAULT_PROXY
        CookieSpecPNames.DATE_PATTERNS
        CookieSpecPNames.SINGLE_COOKIE_HEADER
        AuthPNames.CREDENTIAL_CHARSET
        ClientPNames.COOKIE_POLICY
        ClientPNames.HANDLE_AUTHENTICATION
        ClientPNames.HANDLE_REDIRECTS
        ClientPNames.MAX_REDIRECTS
        ClientPNames.ALLOW_CIRCULAR_REDIRECTS
        ClientPNames.VIRTUAL_HOST
        ClientPNames.DEFAULT_HOST
        ClientPNames.DEFAULT_HEADERS
        ClientPNames.CONN_MANAGER_TIMEOUT
     */

    public void setConnectionManagerTimeout(long timeout) {
        this.setLongParameter( ClientPNames.CONN_MANAGER_TIMEOUT, timeout);
    }

    public void setConnectionTimeout(int timeout) {
        this.setIntParameter( CoreConnectionPNames.CONNECTION_TIMEOUT, timeout);
    }

    public void setSocketTimeout(int timeout) {
        this.setIntParameter(CoreConnectionPNames.SO_TIMEOUT, timeout);
    }

}
