package com.infotel.plagiamax.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableWebSecurity
@EnableAutoConfiguration
//@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableGlobalMethodSecurity(securedEnabled = true)
/**
 * For external connection use :
 * 		- 127.0.0.1:1234/login (GET)
 * 		- in postman use x-www-form-urlencode with next fields :
 * 			- username
 * 			- password
 * 			- _csrf
 * @author tactfactory
 *
 */
public class SecurityConfig extends WebSecurityConfigurerAdapter  {

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {

		//httpSecurity.csrf().disable();
		httpSecurity
			.authorizeRequests()
				.antMatchers(HttpMethod.GET,"/team", "/team/**").permitAll()
				.antMatchers(HttpMethod.GET,"/match", "/match/**").permitAll()
				.antMatchers(HttpMethod.GET,"/category", "/category/**").permitAll()
				.antMatchers(HttpMethod.GET,"/competition", "/competition/**").permitAll()
				.antMatchers(HttpMethod.GET,"/matchbet", "/matchbet/**").permitAll()
				.anyRequest().authenticated()
			.and()
				.formLogin()
					.loginPage("/login")
					.usernameParameter("username").passwordParameter("password")
					.defaultSuccessUrl("/loginResult", true)
					.permitAll()
			.and()
				.logout()
					.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
					.deleteCookies("auth_code", "JSESSIONID").invalidateHttpSession(true)
					//.logoutSuccessUrl("/login")
			.and()
				.csrf()
					.ignoringAntMatchers("/team/**", "/team")
					.ignoringAntMatchers("/match/**")
					.ignoringAntMatchers("/category/**", "/category")
					.ignoringAntMatchers("/competition/**")
					.ignoringAntMatchers("/login")
			.and()
        		.httpBasic()
        	.and()
        		.cors();
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/user/register", "/user/register/**");
	}
	
	@Bean
	public AuthenticationManager customAuthenticationManager() throws Exception {
	  return authenticationManager();
	}
	
	@Bean
	public CorsFilter corsFilter() { 
	    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	    CorsConfiguration config = new CorsConfiguration();
	    config.setAllowCredentials(true);
	    config.addAllowedOrigin("*");
	    config.addAllowedHeader("*");
	    config.addAllowedMethod("*");
	    config.addExposedHeader("WWW-Authenticate");
	    source.registerCorsConfiguration("/**", config);
	    FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<CorsFilter>(new CorsFilter(source));
	    bean.setOrder(0);
	    return new CorsFilter(source);
	}
}