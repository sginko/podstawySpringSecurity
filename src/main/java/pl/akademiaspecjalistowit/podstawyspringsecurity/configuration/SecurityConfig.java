package pl.akademiaspecjalistowit.podstawyspringsecurity.configuration;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authz -> authz
                                .requestMatchers("/h2-console/**").permitAll()
                                .requestMatchers("/books").permitAll()
//                .requestMatchers("/books/new-book").hasAuthority("ADMIN")
                                .requestMatchers("/books/new-book").hasRole("ADMIN")
                                .requestMatchers("/students").hasRole("ADMIN")
                                .anyRequest().authenticated()
                )
                .formLogin(withDefaults());

        http.headers(headers -> headers.frameOptions(frameOptions -> frameOptions.disable())); //disable rame protection for h2-console
        http.csrf(csrf -> csrf.ignoringRequestMatchers("/h2-console/**"));

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    public UserDetailsService userDetailsService() {
//        UserDetails user = User.withDefaultPasswordEncoder()
//                .username("user")
//                .password("pwd")
//                .roles("USER")
//                .build();
//
//        UserDetails admin = User.withDefaultPasswordEncoder()
//                .username("admin")
//                .password("pwd")
//                .roles("ADMIN")
//                .build();
//        return new InMemoryUserDetailsManager(user, admin);
//    }
}
