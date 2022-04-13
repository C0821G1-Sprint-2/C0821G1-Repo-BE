package com.example.demo.config;
import com.example.demo.accessdenied.CustomAccessDeniedHandler;
import com.example.demo.jwt.JwtAuthenticationEntryPoint;
import com.example.demo.jwt.JwtFilter;
import com.example.demo.service.account.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;

    @Autowired
    private JwtFilter jwtFilter;

    @Autowired
    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsServiceImpl).passwordEncoder(passwordEncoder());
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();

        http.authorizeRequests()
                // Các trang không yêu cầu login
                .antMatchers("/api/public/**",
                        "/**/*.js", "/**/*.css","/api/equipment/equipment-list-body/**",
                        "/**/*.jpg", "/**/*.png")
                .permitAll()
                //phan quyen
                .and().authorizeRequests().antMatchers("/api/customer/**",
                "/api/equipment/**",
                "/api/financial/**",
                "/api/employee/update/**",
                "/api/employee/find/**"
                )
//                "/api/employee/search/**")
                .hasAnyRole("EMPLOYEE", "ADMIN")
                .and().authorizeRequests().antMatchers("/api/**").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and().cors()
                .and().exceptionHandling().accessDeniedHandler(accessDeniedHandler())
                .authenticationEntryPoint(jwtAuthenticationEntryPoint)
                // make sure we use stateless session; session won't be used to
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        // Add a filter to validate the tokens with every request
        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

    }

    @Bean
    public AccessDeniedHandler accessDeniedHandler(){
        return new CustomAccessDeniedHandler();
    }
}
