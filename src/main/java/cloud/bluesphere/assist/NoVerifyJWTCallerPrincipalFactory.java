package cloud.bluesphere.assist;

import io.smallrye.jwt.auth.principal.*;
import org.jose4j.jwt.JwtClaims;
import org.jose4j.jwt.consumer.InvalidJwtException;

import javax.annotation.Priority;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * In our microservice architecture, token has already been verified by apache apisix, parse the token claims only
 */
@ApplicationScoped
@Alternative
@Priority(1)
public class NoVerifyJWTCallerPrincipalFactory extends JWTCallerPrincipalFactory {

  @Override
  public JWTCallerPrincipal parse(String token, JWTAuthContextInfo authContextInfo) throws ParseException {
    String json = new String(Base64.getUrlDecoder().decode(token.split("\\.")[1]), StandardCharsets.UTF_8);
    try {
      return new DefaultJWTCallerPrincipal(JwtClaims.parse(json));
    } catch (InvalidJwtException e) {
      throw new ParseException(e.getMessage());
    }
  }

}
