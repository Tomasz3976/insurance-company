package com.example1.insurancecompany.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

        private static final String[] AUTH_WHITELIST = {
                "**/swagger-resources/**",
                "/swagger-ui.html",
                "/v2/api-docs",
                "/webjars/**"
        };

        @Override
        protected void configure(HttpSecurity http) throws Exception {
                http.csrf().disable();
                http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
                http.authorizeRequests().antMatchers(AUTH_WHITELIST).permitAll()
                        .and().httpBasic().authenticationEntryPoint(swaggerAuthenticationEntryPoint());
                http.authorizeRequests().antMatchers("/login").permitAll();
        }

        @Bean
        public BasicAuthenticationEntryPoint swaggerAuthenticationEntryPoint() {
                BasicAuthenticationEntryPoint entryPoint = new BasicAuthenticationEntryPoint();
                entryPoint.setRealmName("Swagger Realm");
                return entryPoint;
        }

}
