package io.jittakal.api.gateway.zuul;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableZuulProxy //Enabling proxy Server
@EnableEurekaClient //Registering with Eureka
@EnableOAuth2Sso
@SpringBootApplication
@RestController
public class ApiGatewayZuulApplication {

	@Autowired
	private OAuth2ClientContext context;

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayZuulApplication.class, args);
	}


	@RequestMapping("/token")
	public String getToken(){
		System.out.println("token: "+context.getAccessToken().getValue());
		return context.getAccessToken().getValue();
	}
}
