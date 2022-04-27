package com.brijesh.oauth.security;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;

@EnableGlobalMethodSecurity(securedEnabled = true)
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

    private final Log logger = LogFactory.getLog(WebSecurity.class);

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        this.logger.debug("Using default configure(HttpSecurity). If subclassed this will potentially override subclass configure(HttpSecurity).");

        JwtAuthenticationConverter jwtAuthenticationConverter= new JwtAuthenticationConverter();
        jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(new KeycloakRoleConverter());

        http.authorizeRequests((requests) -> {
            ((ExpressionUrlAuthorizationConfigurer.AuthorizedUrl)requests.antMatchers(HttpMethod.GET,"/users/status/check")
                     .hasRole("developer")
                    //.hasAnyRole("developer","user")
                    //.hasAnyAuthority("ROLE_developer")
                    .anyRequest()).authenticated();
        });
        http.oauth2ResourceServer().jwt().jwtAuthenticationConverter(jwtAuthenticationConverter);
    }
}
