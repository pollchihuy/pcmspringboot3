package com.juarcoding.pcmspringboot3.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:otherconfig.properties")
public class OtherConfig {

    private static String enableLogFile;
    private static String enableAutomationTesting;
    private static String smtpEnable;
    private static Integer defaultPaginationSize;

    public static Integer getDefaultPaginationSize() {
        return defaultPaginationSize;
    }

    @Value("${default.pagination.size}")
    public static void setDefaultPaginationSize(Integer defaultPaginationSize) {
        OtherConfig.defaultPaginationSize = defaultPaginationSize;
    }

    public static String getSmtpEnable() {
        return smtpEnable;
    }

    @Value("${smtp.enable}")
    private void setSmtpEnable(String smtpEnable) {
        OtherConfig.smtpEnable = smtpEnable;
    }

    public static String getEnableAutomationTesting() {
        return enableAutomationTesting;
    }

    @Value("${enable.automation.testing}")
    private void setEnableAutomationTesting(String enableAutomationTesting) {
        OtherConfig.enableAutomationTesting = enableAutomationTesting;
    }

    public static String getEnableLogFile() {
        return enableLogFile;
    }

    @Value("${enable.log.file}")
    private void setEnableLogFile(String enableLogFile) {
        this.enableLogFile = enableLogFile;
    }
}
