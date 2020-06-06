package org.inori.game.bns.goods_manager.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.UserDetailsRepositoryReactiveAuthenticationManager;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.authentication.HttpBasicServerAuthenticationEntryPoint;
import org.springframework.security.web.server.authentication.logout.RedirectServerLogoutSuccessHandler;
import org.springframework.security.web.server.authentication.logout.ServerLogoutSuccessHandler;
import org.springframework.security.web.server.csrf.CookieServerCsrfTokenRepository;

import java.net.URI;

@Configuration
@Slf4j
@EnableWebFluxSecurity
public class WebFluxSecurityConfig {

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
        log.info("WebFlux Security begin");
        return http.authorizeExchange()
                .pathMatchers(HttpMethod.POST)
                .authenticated()
                .pathMatchers(HttpMethod.DELETE)
                .authenticated()
                .pathMatchers(HttpMethod.PUT)
                .authenticated()
                .pathMatchers("/", "/swagger-ui.html")
                .authenticated()
                .anyExchange()
                .permitAll()
                .and()
                .csrf()
                //.csrfTokenRepository(CookieServerCsrfTokenRepository.withHttpOnlyFalse())
                .disable()
                .httpBasic()
                .authenticationEntryPoint(new HttpBasicServerAuthenticationEntryPoint())
                .authenticationManager(new UserDetailsRepositoryReactiveAuthenticationManager(userDetailsService()))
                .and()
                .formLogin()
                //.requiresAuthenticationMatcher(exchange -> Mono.just(exchange.getRequest())
                 //       .flatMap(m -> ServerWebExchangeMatcher.MatchResult.notMatch())
                 //       .switchIfEmpty(ServerWebExchangeMatcher.MatchResult.match()))
                //.loginPage("/login")
                //.authenticationSuccessHandler(new RedirectServerAuthenticationSuccessHandler("/"))
                //.authenticationFailureHandler(new RedirectServerAuthenticationFailureHandler("/error"))
                //.and()
                //.logout()
                //.logoutUrl("/logout")
                //.logoutSuccessHandler(logoutSuccessHandler("/login?logout"))
                .and()
                .build();
    }

    private ServerLogoutSuccessHandler logoutSuccessHandler(String url) {
        RedirectServerLogoutSuccessHandler successHandler = new RedirectServerLogoutSuccessHandler();
        successHandler.setLogoutSuccessUrl(URI.create(url));
        return successHandler;
    }

    @Bean
    public ReactiveUserDetailsService userDetailsService() {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        UserDetails user = User.withUsername("admin")
                .password(encoder.encode("admin123"))
                .roles()
                .build();
        return new MapReactiveUserDetailsService(user);
    }
}
