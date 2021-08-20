package com.Spring2.Springselenium2.util;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

@Lazy // post construct will not be active because of that
@Component
public class Screenshotutil {

    @Autowired
    private TakesScreenshot driver;

    @Value("${screenshot.path}")
    private Path path;

    @PostConstruct
    private void init (){
        for (int i=0;i<10;i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print("Sleeping");
        }
    }

    public void takeScreenShot() throws IOException {
       File sourceFile= this.driver.getScreenshotAs(OutputType.FILE);
        FileCopyUtils.copy(sourceFile,this.path.toFile());
    }
}
/*
dynamic file name
*  public void takeScreenShot(final String imgName) throws IOException {
       File sourceFile= this.driver.getScreenshotAs(OutputType.FILE);
        FileCopyUtils.copy(sourceFile,this.path.resolve(imgName).toFile());
*/
