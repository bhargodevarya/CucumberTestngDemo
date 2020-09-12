package com;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.ConfigFileApplicationContextInitializer;
import org.springframework.test.context.ContextConfiguration;

/**
 * Base config class that MUST be inherited by cucumber step def classes in order to get access to spring context
 */
@EnableConfigurationProperties
@ConfigurationProperties
@ContextConfiguration(initializers = ConfigFileApplicationContextInitializer.class, classes = Config.class)
@EnableAutoConfiguration
public class BaseConfig {
}
