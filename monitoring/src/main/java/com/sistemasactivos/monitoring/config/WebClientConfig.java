package com.sistemasactivos.monitoring.config;

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ClientHttpConnector;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

@Configuration
public class WebClientConfig implements WebFluxConfigurer {

    @Bean(name = "webClientBenefits")
    public WebClient getWebClientBenefits(){
        return createWebClient("http://localhost:8086/actuator/metrics","benefits", "123");
    }

    @Bean(name = "webClientCostumer")
    public WebClient getWebClientCostumer(){
        return createWebClient("http://localhost:8087/actuator/metrics","costumer", "123");
    }

    @Bean(name = "webClientMonitoring")
    public WebClient getWebClientMonitoring(){
        return createWebClient("http://localhost:8088/actuator/metrics","monitoring", "123");
    }

    private WebClient createWebClient(String url, String user, String password) {
        HttpClient httpClient = HttpClient.create()
                .tcpConfiguration(tcpClient ->
                        tcpClient.option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 10000)
                                .doOnConnected(connection ->
                                        connection.addHandlerLast(new ReadTimeoutHandler(10))
                                                .addHandlerLast(new WriteTimeoutHandler(10))));
        ClientHttpConnector connector = new ReactorClientHttpConnector(httpClient.wiretap(true));
        return WebClient.builder()
                .baseUrl(url)
                .clientConnector(connector)
                .defaultHeaders(headers -> headers.setBasicAuth(user, password))
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

}