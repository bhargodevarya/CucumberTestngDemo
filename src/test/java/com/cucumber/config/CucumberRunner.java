package com.cucumber.config;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;

/**
 * Cucumber config class for configuration
 */
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/",
        plugin = {"pretty", "html:target/cucumber/dummy"},
        glue = "com.cucumber.config")
public class CucumberRunner extends AbstractTestNGCucumberTests {
}
