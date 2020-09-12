package com.demo;

import com.Config;
import com.cucumber.config.CucumberRunner;
import cucumber.api.testng.TestNGCucumberRunner;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.ConfigFileApplicationContextInitializer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Test(groups = {"unittest"})
@EnableConfigurationProperties
@ConfigurationProperties
@ContextConfiguration(initializers = ConfigFileApplicationContextInitializer.class, classes = Config.class)
@EnableAutoConfiguration
public class MyTestNG extends AbstractTestNGSpringContextTests {

    private static final Logger log = Logger.getLogger(MyTestNG.class);

    @Value("${com.test}")
    private String dummy;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    void runningCucumberTest() {
        new TestNGCucumberRunner(CucumberRunner.class).runCukes();
    }

    /**
     * Local Mysql should be running for this test to work. Details in the yml file
     */
    @Test
    public void runningTestngTest() {
        log.info("Reading values from pop file >> " + dummy);
        List<Employee> query = jdbcTemplate.query("SELECT * FROM employees WHERE emp_no = ?", new Object[]{10001}, new RowMapper<Employee>() {
            @Override
            public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
                int id = rs.getInt("emp_no");
                Date bd = rs.getDate("birth_date");
                String fname = rs.getString("first_name");
                String lname = rs.getString("last_name");
                String gender = rs.getString("gender");
                Date hdate = rs.getDate("hire_date");
                log.info(">>>>>>>>>>>>>>>>>>>> WE ARE HERE >>>> " + id + " " + bd);
                return new Employee(fname, lname);
            }
        });

        Assert.assertEquals("2", new Integer(2).toString());
        Assert.assertTrue(query.size() == 1);
        Assert.assertTrue(query.get(0).getFirstName().equals("Georgi"));
    }
}
