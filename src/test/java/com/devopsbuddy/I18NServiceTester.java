package com.devopsbuddy;


import com.devopsbuddy.web.i18n.I18NService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class I18NServiceTester {

    @Autowired
    private I18NService i18NService;

    @Test
    public void test() {
        String  s = i18NService.getMessage("index.main.callout");
        System.out.println("XXXXXXXXXXXXX : "+s);
        Assert.assertNotNull(s);

    }
}
