package com.example1.insurancecompany.security;

import com.example1.insurancecompany.filter.JWTAuthenticationFilter;
import com.example1.insurancecompany.filter.JWTAuthorizationFilter;
import com.example1.insurancecompany.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

        private final CustomUserDetailsService customUserDetailsService;
        private final PasswordEncoder passwordEncoder;
        private final long expirationTime;
        private final String secretKey;

        public SecurityConfig(CustomUserDetailsService customUserDetailsService,
                              PasswordEncoder passwordEncoder,
                              @Value("${jwt.expirationTime}") long expirationTime,
                              @Value("${jwt.secretKey}") String secretKey) {
                this.customUserDetailsService = customUserDetailsService;
                this.passwordEncoder = passwordEncoder;
                this.expirationTime = expirationTime;
                this.secretKey = secretKey;
        }

        private static final String[] AUTH_WHITELIST = {
                "**/swagger-resources/**",
                "/swagger-ui.html",
                "/v2/api-docs",
                "/webjars/**"
        };

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
                auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder);
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
                http.csrf().disable();
                http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
                http.authorizeRequests().antMatchers(AUTH_WHITELIST).permitAll()
                        .and().httpBasic().authenticationEntryPoint(swaggerAuthenticationEntryPoint());
                http.authorizeRequests().antMatchers("/login").permitAll()
                        .anyRequest().permitAll()
                        .and().logout().logoutSuccessUrl("/login");
                http.addFilter(new JWTAuthenticationFilter(authenticationManagerBean(), expirationTime, secretKey));
                http.addFilterBefore(new JWTAuthorizationFilter(secretKey), UsernamePasswordAuthenticationFilter.class);
        }

        @Bean
        public BasicAuthenticationEntryPoint swaggerAuthenticationEntryPoint() {
                BasicAuthenticationEntryPoint entryPoint = new BasicAuthenticationEntryPoint();
                entryPoint.setRealmName("Swagger Realm");
                return entryPoint;
        }

        @Bean
        @Override
        public AuthenticationManager authenticationManagerBean() throws Exception {
                return super.authenticationManagerBean();
        }

}
