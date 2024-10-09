package pl.akademiaspecjalistowit.podstawyspringsecurity.configuration;

import org.springframework.boot.CommandLineRunner;
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

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests(authz -> authz
//                        .requestMatchers("/h2-console/**", "/new-user").permitAll()
//                        .requestMatchers("/books/new-book").hasRole("ADMIN")
//                        .requestMatchers("/students").hasRole("ADMIN")
//                        .anyRequest().authenticated()
//                )
//                .httpBasic(withDefaults())
//                .csrf(csrf -> csrf.ignoringRequestMatchers("/h2-console/**", "/new-user"));
//
//        http.headers(headers -> headers.frameOptions(frameOptions -> frameOptions.disable()));
//
//        return http.build();
//    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authz -> authz
                                .requestMatchers("/h2-console/**").permitAll()
                                .requestMatchers("/books", "/books/check-password").permitAll()
                                .requestMatchers("/books/new-book").hasRole("ADMIN")
//                                .requestMatchers("/books/new-book").hasAuthority("ROLE_ADMIN")
                                .requestMatchers("/students").hasRole("ADMIN")
//                                .requestMatchers("/students").hasAuthority("ROLE_ADMIN")
                                .anyRequest().authenticated()
                )
                .formLogin(withDefaults());

        http.headers(headers -> headers.frameOptions(frameOptions -> frameOptions.disable()));

        http.csrf(csrf -> csrf.ignoringRequestMatchers("/h2-console/**"));

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }

//    @Bean
//    public CommandLineRunner run(PasswordEncoder passwordEncoder) {
//        return args -> {
//            String hashedPassword = passwordEncoder.encode("admin");
//            System.out.println("Hashed password: " + hashedPassword);
//        };
//    }

//    @Bean
//    public UserDetailsService userDetailsService() {
//        UserDetails admin = User.withUsername("admin")
//                .password(passwordEncoder().encode("admin"))
//                .roles("ADMIN")
//                .build();
//
//        return new InMemoryUserDetailsManager(admin);
//    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
