/**
 * @author 明明不是下雨天
 */
package com.cn.app.chatgptbot.uitls;

import com.cn.app.chatgptbot.exception.CustomException;
import org.springframework.http.client.reactive.ClientHttpConnector;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.Duration;
import java.util.concurrent.TimeoutException;

/**
 * The type Web client util.
 */

public class WebClientUtil {

    /**
     * Build string.
     *
     * @param connector the connector
     * @param openKey   the open key
     * @param url       the url
     * @param body      the body
     * @return the string
     */
    public static String build(ClientHttpConnector connector, final String openKey, final String url, final Object body) {

        return WebClient.builder()
                .clientConnector(connector)
                .baseUrl("https://api.openai.com/v1/")
                .defaultHeader("Authorization", "Bearer " + openKey)
                .build()
                .post()
                .uri(url)
                .body(BodyInserters.fromValue(body))
                .retrieve()
                .bodyToMono(String.class)
                .timeout(Duration.ofSeconds(65)) // 添加超时
                .onErrorMap(TimeoutException.class, e -> new CustomException("OpenAi回复时间过长")) // 抛出异常
                .block();
    }
}
