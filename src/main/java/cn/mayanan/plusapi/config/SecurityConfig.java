package cn.mayanan.plusapi.config;

import cn.mayanan.plusapi.security.CustomerAuthenticationEntryPoint;
import cn.mayanan.plusapi.utils.JwtAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

// 标注配置类，表示该类包含了spring配置
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private CustomerAuthenticationEntryPoint customerAuthenticationEntryPoint;
    // 注入 JwtAuthenticationFilter
    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()  // 禁用 CSRF
                .authorizeRequests()
                .antMatchers("/users/login").permitAll()  // 放行 /users/login
                .anyRequest().authenticated()  // 其他请求需要认证
//                .anyRequest().permitAll()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)  // 禁用 Session
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(customerAuthenticationEntryPoint);  // 自定义未认证处理

        // 添加 JWT 过滤器
        http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
    }
}

