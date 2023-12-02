package pl.business.cat.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import com.vaadin.flow.spring.security.VaadinWebSecurity;

import pl.business.cat.login.user.BusinessUserService;
import pl.business.cat.view.LoginView;

@EnableWebSecurity 
@Configuration
@EnableMethodSecurity
public class SecurityConfig extends VaadinWebSecurity { 

	@Autowired
	private static BusinessUserService userDetailsService;
	
	public SecurityConfig(BusinessUserService user) {
		SecurityConfig.userDetailsService = user;
	}
	
	@Bean
	private static final BusinessUserService userDetailsService() {
		return userDetailsService;
	}
	@Bean
	public DaoAuthenticationProvider createDaoAuthentication() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		
		provider.setUserDetailsService((UserDetailsService) userDetailsService);
		provider.setPasswordEncoder(passwordEncoder());
		return provider;
	}
	@Bean
    private static final PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
    	//Authentication authen = SecurityContextHolder.getContext().getAuthentication();
        http.authorizeHttpRequests(auth ->{
                    	auth.requestMatchers(
                    			AntPathRequestMatcher.antMatcher(HttpMethod.GET, "/images/*.png")).permitAll();
                    	auth.requestMatchers((RequestMatcher) req ->{
                    				//req.getRequestURL().toString().split("/");
                    				AntPathRequestMatcher.antMatcher("/{name}/**");
									return false;
                    }).access(new PolicyUserAuthorizationManager("#name == authentication.name"));
        });            
        super.configure(http);
        setLoginView(http, LoginView.class);
        
	}
    
}