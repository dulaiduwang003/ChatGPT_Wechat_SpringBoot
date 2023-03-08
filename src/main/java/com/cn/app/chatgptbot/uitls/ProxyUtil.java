/**
 * @author 明明不是下雨天
 */
package com.cn.app.chatgptbot.uitls;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Component;
import reactor.netty.http.client.HttpClient;
import reactor.netty.transport.ProxyProvider;

/**
 * The type Proxy util.
 */
@Slf4j
@Component
public class ProxyUtil {

    @Value(value = "${broker.ip}")
    private String ip;

    @Value(value = "${broker.port}")
    private Integer port;


    /**
     * Gets proxy.
     *
     * @return the proxy
     */
    public  ReactorClientHttpConnector getProxy() {

        final HttpClient httpClient = HttpClient.create().tcpConfiguration(tcpClient -> {

            tcpClient = tcpClient.proxy(proxy -> proxy.type(ProxyProvider.Proxy.HTTP)
                    .host(ip)
                    .port(port)
                    .build());
            return tcpClient;
        });

        return new ReactorClientHttpConnector(httpClient);
    }

}
