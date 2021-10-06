//Примерный программный эквивалент
// файла spring-security-config.xml

//package my.boot;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//
//        return NoOpPasswordEncoder.getInstance();
//    }
//
//    @Override
//    public void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("admin")
//                .password("password")
//                .authorities("ROLE_ADMIN")
//                .and()
//                .withUser("user")
//                .password("password")
//                .authorities("ROLE_USER");
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//
//        http.authorizeRequests()
//                .antMatchers("/time").hasRole("USER")
//                .and()
//                .formLogin().permitAll()
//                .loginPage("/login.html")
//                .loginProcessingUrl("/perform-login")
//                .usernameParameter("usr")
//                .passwordParameter("pwd")
//                .defaultSuccessUrl("/time")
//        ;
//        http.csrf().disable();
//    }
//}