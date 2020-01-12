package com.bus.server.microservicespringcloud;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 新版的Spring security 会默认开启防csrf攻击，所有的请求都必须携带crsf这个参数
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private HttpSecurity http;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        this.http = http;
        http.csrf().disable();
        super.configure(http);
    }
}
