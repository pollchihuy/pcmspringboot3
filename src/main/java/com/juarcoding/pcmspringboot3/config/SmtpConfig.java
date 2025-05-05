package com.juarcoding.pcmspringboot3.config;


import com.juarcoding.pcmspringboot3.security.Crypto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:smtpconfig.properties")
public class SmtpConfig {


    private static String emailUsername;
    private static String emailPassword;

    public static String getEmailPassword() {
        return emailPassword;
    }

    @Value("${email.password}")
    private void setEmailPassword(String emailPassword) {
        SmtpConfig.emailPassword = Crypto.performDecrypt(emailPassword);
    }

    public static String getEmailUsername() {
        return emailUsername;
    }

    @Value("${email.username}")
    private void setEmailUsername(String emailUsername) {
        this.emailUsername = Crypto.performDecrypt(emailUsername);
    }
}
