package com.bliblifuture.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import javax.sql.DataSource;

@EnableWebSecurity
@Profile(value={"development"})
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(HttpMethod.OPTIONS, "/**")
                    .permitAll()
                .antMatchers("/api/users")
                    .hasAnyRole("ADMIN", "SUPER_ADMIN")
                .antMatchers("/api/stockopnames")
                    .hasRole("ADMIN")
                .antMatchers("/api/reports")
                    .hasRole("ADMIN")
                .antMatchers("/api/assignments")
                    .hasRole("ADMIN")
                .antMatchers("/api/worklist")
                    .hasRole("COUNTER")
                .antMatchers("/api/SKU")
                    .hasAnyRole("COUNTER","ADMIN")
                .antMatchers("/api/SKUs")
                    .hasAnyRole("COUNTER","ADMIN")
                .antMatchers("/api/skubystorage")
                    .hasAnyRole("COUNTER")
                .antMatchers("/api/unknownSKUs")
                    .hasAnyRole("COUNTER","ADMIN")
                .antMatchers("/api/updatesto")
                    .hasAnyRole("COUNTER","ADMIN")
                .antMatchers("/api/updatefinishtimestockopname")
                    .hasAnyRole("COUNTER")
                .antMatchers("/api/updatestarttimestockopname")
                    .hasAnyRole("COUNTER")
                .anyRequest().fullyAuthenticated()
                .and()
                .httpBasic()
                .and()
                .csrf().disable();
    }
}