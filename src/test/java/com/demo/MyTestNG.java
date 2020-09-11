package com.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.ConfigFileApplicationContextInitializer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test(groups = {"unittest"})
@EnableConfigurationProperties
@ConfigurationProperties
@ContextConfiguration(initializers = ConfigFileApplicationContextInitializer.class)
public class MyTestNG extends AbstractTestNGSpringContextTests {

    @Value("${com.test}")
    private String dummy;

    @Test
    void firstTest() {
        System.out.println("???? " + dummy);
        Assert.assertEquals("2", new Integer(2).toString());
    }
}
