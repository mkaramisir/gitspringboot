package com.Spring2.Springselenium2.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;

@Lazy // all of the class will be lazy will not work until it called in the method
@Configuration
public class WebDriverConfig {
    @Value("${default.timeout:30}")
    private int timeout;

    @Bean
    public WebDriver chromeDriver(){
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();

    }
    @Primary
    @Bean
    public WebDriver firefoxDriver(){
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();

    }

    @Bean
    public WebDriverWait webdriverWait(WebDriver driver){
       return new WebDriverWait(driver,this.timeout);
    }

}
