package com.cucumber.config;

import com.BaseConfig;
import com.utils.WebUtils;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.testng.Assert;

import java.io.IOException;

/**
 * Step class that executes the test.
 * Since we are using Spring, we can autowire dependencies and even read values directly from yml.
 * Remember to extend BaseConfig
 */
public class MyDummyStep extends BaseConfig {

    private static Logger logger = LoggerFactory.getLogger(MyDummyStep.class);

    @Autowired
    private WebUtils webUtils;

    @Given("^I have a property in yml file$")
    public void i_have_a_property_in_yml_file() {
        logger.info(">>>>>>> GIVEN <<<<<<<<<<<<<");
    }

    @When("^I read the props from the file$")
    public void afterReadingProps() {
        String url = webUtils.getUrl();
        logger.info(">>>>>>>>>>>>> " + url + " <<<<<<<<<<<<<<<");
        Assert.assertNotNull(url);
    }

    @Then("^I should be able to make a remote call and code is (\\d+)$")
    public void makeApiCall(int code) throws IOException {
        ResponseEntity<Users> response = new RestTemplate().getForEntity(webUtils.getUrl(), Users.class);
        logger.info("Response is >>>>>>> " + response);
        Assert.assertEquals(response.getStatusCode().value(), code);
        Assert.assertNotNull(response.getBody().getName());
    }
}
