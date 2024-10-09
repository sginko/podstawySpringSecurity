package pl.akademiaspecjalistowit.podstawyspringsecurity.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;

import javax.sql.DataSource;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .cors(cors -> cors.configurationSource(request -> {
                    CorsConfiguration config = new CorsConfiguration();
                    config.addAllowedOrigin("http://localhost:63342");
                    config.addAllowedHeader("*");
                    config.addAllowedMethod("*");
                    config.setAllowCredentials(true);
                    return config;
                }))
                .csrf(csrf -> csrf.ignoringRequestMatchers("/h2-console/**", "/new-user"))
//                .csrf(AbstractHttpConfigurer::disable)
                .headers(headers -> headers.frameOptions(frameOptions -> frameOptions.disable()))
                .authorizeHttpRequests(authz -> authz
                                .requestMatchers("/h2-console/**").permitAll()
                                .requestMatchers("/books", "/books/check-password", "/new-user").permitAll()
                                .requestMatchers("/books/new-book").hasRole("ADMIN")
//                                .requestMatchers("/books/new-book").hasAuthority("ROLE_ADMIN")
                                .requestMatchers("/students").hasRole("ADMIN")
//                                .requestMatchers("/students").hasAuthority("ROLE_ADMIN")
                                .anyRequest().authenticated()
                )
                .formLogin(withDefaults())
                .httpBasic(withDefaults());
        return http.build();
    }

//    @Bean
//    public UserDetailsService userDetailsService(DataSource dataSource) {
//        return new JdbcUserDetailsManager(dataSource);
//    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public JdbcUserDetailsManager jdbcUserDetailsManager(DataSource dataSource) {
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
}
