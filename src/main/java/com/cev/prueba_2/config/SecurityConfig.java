package com.cev.prueba_2.config;

    import org.springframework.context.annotation.Bean;
    import org.springframework.context.annotation.Configuration;
    import org.springframework.http.HttpMethod;
    import org.springframework.security.config.annotation.web.builders.HttpSecurity;
    import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
    import org.springframework.security.core.userdetails.User;
    import org.springframework.security.core.userdetails.UserDetails;
    import org.springframework.security.core.userdetails.UserDetailsService;
    import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
    import org.springframework.security.provisioning.InMemoryUserDetailsManager;
    import org.springframework.security.web.SecurityFilterChain;
    import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean // Asignación de permisos a los usuarios
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers(HttpMethod.GET,"/**").hasAnyAuthority("ROLE_ADMIN", "ROLE_USER", "ROLE_SEMI") // Cualquier usuario puede acceder al get de todo
                .requestMatchers(HttpMethod.POST,"/cinema/**").hasAnyAuthority("ROLE_ADMIN", "ROLE_SEMI") // Sólo los usuarios semiAdmin y Admin pueden añadir cines
                .requestMatchers(HttpMethod.PUT,"/cinema/**").hasAnyAuthority("ROLE_ADMIN", "ROLE_SEMI") // Sólo los usuarios semiAdmin y Admin pueden modificara cines o vinculación de peliculas
                .anyRequest().hasAuthority("ROLE_ADMIN") // El resto como crear y modificar peliculas sólo lo puede hacer el usuario Admin, igual que con las Reviews
                .and().httpBasic();
        return http.build();

    }

    @Bean //Creación de los usuarios
    public UserDetailsService userDetailsService() {
        UserDetails admin = User.builder()
                .username("admin")
                .password(passwordEncoder().encode("admin"))
                .authorities("ROLE_ADMIN")
                .build();
        UserDetails user = User.builder()
                .username("user")
                .password(passwordEncoder().encode("user"))
                .authorities("ROLE_USER")
                .build();
        UserDetails semiAdmin = User.builder()
                .username("semiAdmin")
                .password(passwordEncoder().encode("semiAdmin"))
                .authorities("ROLE_SEMI")
                .build();


        return new InMemoryUserDetailsManager(admin, user, semiAdmin);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
