## 实验要求

（1）安装 SeleniumIDE 插件

（2）学会使用 SeleniumIDE 录制脚本和导出脚本

（3）访问 [http://121.193.130.195:8080/](http://121.193.130.195:8080/) 使用学号登录系统（账户名为学号，密码为学号后6位），进入系统后可以看到该同学的 git 地址。

（4）编写 Selenium Java WebDriver 程序，测试 inputgit.csv 表格中的学号和 git 地址的对应关系是否正确。

## 实验过程

（1）安装 FireFox 浏览器，版本为 44.0。

（2）打开安装的 FireFox 浏览器，并进入 Selenium IDE 的官网，下载最新版本的 Selenium IDE 插件并添加到 FireFox 的组件库中。

![](http://i4.buimg.com/567571/651b6afc3cac5aac.png)

（3）打开 Selenium IDE 插件，并开启录制。在浏览器中输入地址 [http://121.193.130.195:8080/](http://121.193.130.195:8080/) 并进行访问，输入自己的学号和对应的密码后跳转到包含个人信息的页面。关闭录制，点击 “Options->Format->Java/Junit4/
WebDriver” 进行格式转换。

![](http://i2.muimg.com/567571/c112aa51b0e9c331.png)

（4）然后点击 “文件->Export Test Case As->Java/Junit4->WebDriver” 将该测试用例导出，得到Java示例代码。

![](http://i4.buimg.com/567571/51653115077ff69d.png)

（5）在idea中新建一个 lab_2 项目，目录结构如下所示：

![](http://i4.buimg.com/567571/723a4da673024d76.png)

（6）下载 Java 版本的 selenium，并将对应的 jar 包导入到项目中去：

![](http://i4.buimg.com/567571/2857a30cf44b4092.png)

（7）编写 Selenium 测试代码：

```java
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

```

## 实验结果

117个测试用例全部通过：

![](http://i2.muimg.com/567571/779600bfc843b2e9.png)
