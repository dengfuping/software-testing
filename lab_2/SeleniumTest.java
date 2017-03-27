package com.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@RunWith(Parameterized.class)
public class SeleniumTest {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    private String testName;
    private String testPwd;
    private String gitHubUrl;

    public SeleniumTest(String testName, String testPwd, String githubUrl) {
        this.testName = testName;
        this.testPwd = testPwd;
        this.gitHubUrl = githubUrl;
    }

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "http://121.193.130.195:8080";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getData() {
        Object[][] obj = new Object[117][];
        try {
            BufferedReader reader = new BufferedReader(new FileReader("G://文件夹//天大文件//课程//大三下//软件测试技术//实验//第2次实验//inputgit.csv"));
            reader.readLine();
            String line;
            int count = 0;
            while ((line = reader.readLine()) != null) {
                String item[] = line.split(",");
                String stuNum = item[0];
                String pwd = stuNum.substring(4);
                String githubUrl = item[2];
                obj[count] = new Object[]{stuNum, pwd, githubUrl};
                count++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Arrays.asList(obj);
    }

    @Test
    public void testMain() throws Exception {
        driver.get(baseUrl + "/");
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys(testName);
        driver.findElement(By.id("pwd")).clear();
        driver.findElement(By.id("pwd")).sendKeys(testPwd);
        driver.findElement(By.id("submit")).click();
        assertEquals(this.gitHubUrl, driver.findElement(By.xpath("//tbody[@id='table-main']/tr[3]/td[2]")).getText());
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
