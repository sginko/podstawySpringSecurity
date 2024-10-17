package pl.akademiaspecjalistowit.podstawyspringsecurity.configuration;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@AllArgsConstructor
@Component
public class CustomOAuth2AuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    private final JdbcUserDetailsManager jdbcUserDetailsManager;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        OAuth2User oauth2User = (OAuth2User) authentication.getPrincipal();

        String username = oauth2User.getAttribute("login");

        if (!jdbcUserDetailsManager.userExists(username)) {
            jdbcUserDetailsManager.createUser(User
                    .withUsername(username)
                    .password("")
                    .roles("USER")
                    .build());

        }
        response.sendRedirect("http://localhost:8080/books");
    }
}
