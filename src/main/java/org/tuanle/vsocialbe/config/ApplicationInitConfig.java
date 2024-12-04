package org.tuanle.vsocialbe.config;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.tuanle.vsocialbe.entity.Account;
import org.tuanle.vsocialbe.enums.Role;
import org.tuanle.vsocialbe.repositoty.AccountRepo;

import java.util.HashSet;

@Configuration
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ApplicationInitConfig {
    private static final Logger log = LoggerFactory.getLogger(ApplicationInitConfig.class);
    private PasswordEncoder passwordEncoder;

    @Bean
    ApplicationRunner applicationRunner(AccountRepo accountRepo) {
        return args -> {
            if(accountRepo.findByEmail("admin@gmail.com").isEmpty()){
//                var roles = new <Role>();
//                roles.add(Role.ADMIN);
                Account account = new Account();
                account.setUsername("admin");
                account.setEmail("admin@gmail.com");
                account.setPassword(passwordEncoder.encode("admin"));
                accountRepo.save(account);

                accountRepo.save(account);
                log.warn("Admin has been created with default password: admin, please change it/");
            }
        };
    }
}
