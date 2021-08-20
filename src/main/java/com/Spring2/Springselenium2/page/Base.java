package com.Spring2.Springselenium2.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

public abstract class Base {

    @Autowired
    protected WebDriver driver;

    @Autowired
    protected WebDriverWait wait;

   //without this driver will be null
    @PostConstruct
    private void init(){
        PageFactory.initElements(this.driver,this);
    }




    public abstract boolean isAt();
}
