package ro.agilehub.javacourse.car.hire.boot.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;

import java.util.Collection;

/**
 * This is the base class for configuring security related information for your application
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ServerSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * Here we configure in-memory authentication with 2 users.
     * The passwords are encoded using BCryptEncryptor (it's 123).
     * If you'd like to encode other passwords, make a main function with a new BCriptEncryptor().encode(str)
     *
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.inMemoryAuthentication()
                .withUser("john")
                .password("$2a$10$pjcUbYQPlRDqcL35cHevqe5f3iJLwazLgcPYn33PwXKfh9aK.l6ee")
                .authorities(new SimpleGrantedAuthority("CUSTOMER"))
                .and()
                .withUser("jack")
                .password("$2a$10$pjcUbYQPlRDqcL35cHevqe5f3iJLwazLgcPYn33PwXKfh9aK.l6ee")
                .authorities(new SimpleGrantedAuthority("MANAGER"));
    }

    /**
     * This just leaves the default authentication manager bean
     *
     * @return
     * @throws Exception
     */
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean()
            throws Exception {
        return super.authenticationManagerBean();
    }

    /**
     * This method allows you to configure the types of autentication
     * and authenticated resources
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                // add here the resources which you need to make public, like static content or authorization links
                .antMatchers("/swagger-ui.html", "/swagger-ui/*", "/v3/api-docs/*",
                        "/api.yaml", "/oauth/*", "/.well-known/*").permitAll()
                .anyRequest().authenticated()
                .and()
                // this enable http basic authentication.
                // this is needed because the OAuth password flow uses it,
                // sending the client id as the username and the client secret as the password
                .httpBasic()
                .and()
                // this adds an OAuth2 resource server
                .oauth2ResourceServer()
                // this configures the OAuth2 Resources Server to use JWT tokens
                // it also means you'll have to have the property below specified, as it's manadatory
                // under the latest Spring Security version to have a jwks URI configured
                // spring.security.oauth2.resourceserver.jwt.jwk-set-uri
                .jwt(jwt -> jwt.jwtAuthenticationConverter(getJwtAuthenticationConverter()));
    }

    private Converter<Jwt, AbstractAuthenticationToken> getJwtAuthenticationConverter() {
        JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
        jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(getJwtGrantedAuthoritiesConverter());
        return jwtAuthenticationConverter;
    }

    private Converter<Jwt, Collection<GrantedAuthority>> getJwtGrantedAuthoritiesConverter() {
        JwtGrantedAuthoritiesConverter converter = new JwtGrantedAuthoritiesConverter();
        converter.setAuthorityPrefix("");
        converter.setAuthoritiesClaimName("authorities");
        return converter;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
