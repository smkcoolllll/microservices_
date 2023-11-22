package jwtAuth_.jwtAuth_.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class appConfig {

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user1 = User.builder().
                username("sam")
                .password(passwordEncoder().encode("sam@#")).roles("ADMIN").
                build();
        UserDetails user2=User.builder().username("jacky").password(passwordEncoder().encode("jacky@#")).roles("advUser").build();
        return new InMemoryUserDetailsManager(user1,user2);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
