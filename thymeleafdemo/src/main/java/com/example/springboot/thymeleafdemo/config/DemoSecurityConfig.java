package com.example.springboot.thymeleafdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

@Configuration
@ComponentScan("com.example.springboot.thymeleafdemo")
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        // add our users for in memory authentication

//        UserBuilder users = User.withDefaultPasswordEncoder();
//
//        auth.inMemoryAuthentication()
//                .withUser(users.username("John").password("123").roles("EMPLOYEE"))
//                .withUser(users.username("Max").password("123").roles("EMPLOYEE", "MANAGER"))
//                .withUser(users.username("Samara").password("123").roles("EMPLOYEE", "ADMIN"));
        auth.inMemoryAuthentication()
                .withUser("John").password("{noop}123").roles("EMPLOYEE")
                .and()
                .withUser("Max").password("{noop}123").roles("EMPLOYEE", "MANAGER")
                .and()
                .withUser("Samara").password("{noop}123").roles("EMPLOYEE", "ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/employees/showForm*").hasAnyRole("MANAGER", "ADMIN")
                .antMatchers("/employees/save*").hasAnyRole("MANAGER", "ADMIN")
                .antMatchers("/employees/delete").hasRole("ADMIN")
                .antMatchers("/employees/**").hasRole("EMPLOYEE")
                .antMatchers("/resources/**").permitAll()
                .and()
                .formLogin()
                .loginPage("/showMyLoginPage")
                .loginProcessingUrl("/authenticateTheUser")
                .permitAll()
                .and()
                .logout().permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/access-denied");

    }

//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }

}
