package ro.agilehub.javacourse.car.hire.boot.security;

import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.KeyUse;
import com.nimbusds.jose.jwk.RSAKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

import java.security.KeyPair;
import java.security.interfaces.RSAPublicKey;

@Configuration
@EnableAuthorizationServer
public class AuthServerOAuth2Config extends AuthorizationServerConfigurerAdapter {

    @Autowired
    @Qualifier("authenticationManagerBean")
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
        oauthServer
                .tokenKeyAccess("permitAll()")
                .checkTokenAccess("isAuthenticated()");
    }

    /**
     * Configure the accepted cients and where they are stored.
     * We've used inMemory storage, but a database could be used as well for adding clients dynamically
     *
     * @param clients
     * @throws Exception
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients)
            throws Exception {
        clients.inMemory()
                .withClient("carhire.client.id")
                .secret(passwordEncoder.encode("secret"))
                .authorizedGrantTypes("password", "authorization_code", "refresh_token")
                .scopes("read", "write");
    }

    /**
     * This puts everything together:
     * where the tokens are stored
     * how they are converted (encrypted)
     * and also the underlying authentication manager
     *
     * @param endpoints
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints
                .tokenStore(tokenStore())
                .accessTokenConverter(accessTokenConverter())
                .authenticationManager(authenticationManager);
    }

    /**
     * This configures the use of JWT tokens (the tokens aren't stored anywhere)
     * Other options are in memory and in a database
     *
     * @return
     */
    @Bean
    public TokenStore tokenStore() {
        return new JwtTokenStore(accessTokenConverter());
    }

    /**
     * The access token converter encrypts the token using the specified prive-public key pair
     *
     * @return
     */
    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setKeyPair(keyPair());
        return converter;
    }

    /**
     * This configures the available token services
     * Here we configure again the tokenStore and mention that we support the refresh_token flow
     *
     * @return
     */
    @Bean
    @Primary
    public DefaultTokenServices tokenServices() {
        DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
        defaultTokenServices.setTokenStore(tokenStore());
        defaultTokenServices.setSupportRefreshToken(true);
        return defaultTokenServices;
    }

    /**
     * This builds a key pair  based on the carhire.jks file in the classpath
     *
     * @return
     */
    @Bean
    public KeyPair keyPair() {
        KeyStoreKeyFactory keyStoreKeyFactory = new KeyStoreKeyFactory(new ClassPathResource("carhire.jks"), "mycarhirepass".toCharArray());
        return keyStoreKeyFactory.getKeyPair("carhire");
    }

    /**
     * This builds a JWKSet bean (from nimbus), based on the public key from the key pair
     *
     * @return
     */
    @Bean
    public JWKSet jwkSet() {
        RSAKey.Builder builder = new RSAKey.Builder((RSAPublicKey) keyPair().getPublic())
                .keyUse(KeyUse.SIGNATURE)
                .algorithm(JWSAlgorithm.RS256)
                .keyID("carhire-key-id");
        return new JWKSet(builder.build());
    }

    /**
     * This is a helper main method to encrypt passwords
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder().encode("123"));
    }
}
