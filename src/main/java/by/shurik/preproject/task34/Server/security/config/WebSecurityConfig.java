package by.shurik.preproject.task34.Server.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception {//для аутентификации

        auth.inMemoryAuthentication()
                .withUser("123")
                .password(bCryptPasswordEncoder().encode("123"))
                .roles("ADMIN");
    }

    /*
    Basic Authentication — юзер или рест клиент указывает свой логин и пароль для для получения доступа
    к рест сервису. Логин и пароль передаются по сети как незашифрованный текст кодированный простым Base64
     и может быть легко декодирован любым пользователем. При использовании такого метода, обязательно должен
     использоваться https протокол для передачи данных.
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic();
        http.csrf().disable();

    }
}
