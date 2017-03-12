## 一、实验要求

（1）使用Eclipse安装Junit（4.12），Hamcrest（1.3）
（2）使用Eclipse安装Eclemma
（3）为三角形问题编写一个Java程序，并用Junit测试程序
（4）其中三角问题的描述为：函数三角形取三个整数a，b，c，它们是三角形边的长度; 判断三角形是等边，等腰或一般三角形。

## 二、实验步骤

### 1. 下载并安装 Junit 与 hamcrest

- 下载：在 [Junit 官网](http://junit.org/junit4/) 中下载 Junit 和 Hamcrest 的 Jar 包（需要注意的一点是，需要梯子才能进行下载）。
- 安装：在 Eclipse 中新建一个 Java 工程，选中新建的工程并右键点击，依次选择 Properties->Java Build Path->Libraries，点击“Add External JARs”按钮后选中刚刚下载的 Junit 和 Hamcrest 的 Jar 包即可。

![](http://p1.bqimg.com/567571/12504c8cc172254f.png)

### 2. 安装 Eclemma

在 Eclipse 中选择 Help->Eclipse Marketplace，然后搜索 EclEmma，并点击 Install 进行安装。重启 eclipse发现工具栏上出现 Coverage 图标，说明安装成功；

![](http://p1.bqimg.com/567571/fbc1f023668e7acc.png)

### 3. 代码编写

（1）在 src 目录下新建名为 com.triangle 的 package，然后在 package 新建名为 Triangle.java 和 TriangleTest.java 的源文件。
（2）判断三角形类型：

```java
package com.triangle;

public class Triangle {
    private int a, b, c;
    
    public Triangle() {
    	
    }

    public static String judgeTriangle(int a, int b, int c){
        if(a + b> c && a + c > b && b + c > a){
            if (a == b && a == c)
            	return "equilLateral";       // 等边三角形
            else if ((a == b) && (a != c) || (a == c) && (a != b) || (b == c) && (b !=a )) 
            	return "isSosceles";        // 等腰三角形
            else 
            	return "scalene";          // 普通三角形
        }
        else 
        	return "notTriangle";         // 无法构成三角形
    }
}
```

（3）简单测试用例：

```java
package com.triangle;

import static org.junit.Assert.*;

import org.junit.Test;

public class TriangleTest {
    @Test 
    public void test1(){
        assertEquals("equilLateral", Triangle.judgeTriangle(1, 1, 1));
    }  
    @Test 
    public void test2(){
        assertEquals("isSosceles",  Triangle.judgeTriangle(1, 2, 2));
    }    
    @Test 
    public void test3(){
        assertEquals("scalene",  Triangle.judgeTriangle(3, 4, 5));
    }    
    @Test 
    public void test4(){
        assertEquals("notTriangle",  Triangle.judgeTriangle(1, 2, 3));
    }    
    @Test 
    public void test5(){
        assertEquals("equilLateral",  Triangle.judgeTriangle(4, 4, 4));
    }    
    @Test 
    public void test6(){
        assertEquals("scalene",  Triangle.judgeTriangle(2, 3, 4));
    }
}

```

### 4. 测试运行

选择以 Coverage as 的方式运行程序，结果将以不同颜色显示代码段：

![](http://i1.piimg.com/567571/d5fb8e00d1eeb4d0.png)

![](http://p1.bpimg.com/567571/ff0b0557afffa22c.png)

其中，绿色表示代码被执行到，黄色表示代码部分执行到，红色表示代码没有被执行到。以下是测试用例的运行结果以及 Coverage 的比例：

![](http://i1.piimg.com/567571/62673836a7874416.png)

![](http://i1.piimg.com/567571/b7dc7eefb0bae40a.png)


