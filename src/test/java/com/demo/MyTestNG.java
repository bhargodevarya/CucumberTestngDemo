package com.demo;

import org.testng.Assert;
import org.testng.annotations.Test;

@Test(groups = {"unittest"})
public class MyTestNG {

    @Test
    void firstTest() {
        Assert.assertEquals("2", new Integer(2).toString());
    }
}
