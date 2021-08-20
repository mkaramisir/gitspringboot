package com.Spring2.Springselenium2.googleTest;

import com.Spring2.Springselenium2.SpringBaseTestNGTest;
import com.Spring2.Springselenium2.page.google.GooglePage;
import com.Spring2.Springselenium2.util.Screenshotutil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureWebClient;
import org.springframework.context.annotation.Lazy;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class GoogleTest extends SpringBaseTestNGTest {


    @Lazy // means don't use it until told you to do so. It has to be component and autowired levels
    @Autowired
    private Screenshotutil screenshot;

    @Autowired
    private GooglePage googlePage;

    @Test
    public void googleTest() throws IOException {
        this.googlePage.goTo();
        Assert.assertTrue(this.googlePage.isAt());

        this.googlePage.getSearchComponent().search("spring boot");
        Assert.assertTrue(this.googlePage.getSearchResult().getCount()>2);
        this.screenshot.takeScreenShot();
    }

}
