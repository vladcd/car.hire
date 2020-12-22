package ro.agilehub.javacourse.car.hire.boot.auditing;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DefaultAuditorAware implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication())
                .map(Authentication::getPrincipal)
                .map(Jwt.class::cast)
                .map(Jwt::getClaims)
                .flatMap(claims -> Optional.ofNullable(claims.get("user_name")))
                .map(Object::toString);
    }
}
