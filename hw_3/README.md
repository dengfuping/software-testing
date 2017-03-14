## 一、Use the following method printPrimes() for questions a–d

（a）为printPrimes()画控制流图。

![](http://i1.piimg.com/567571/98d66de59714b844.png)

（b）考虑测试用例t1=(n=3)和t2=（n=5)。即使这些测试用例游历printPrimes()方法中相同的主路径，它们不一定找出相同的错误，设计一个简单的错误，使得t2比t1更容易发现。
<strong>解答：</strong>
t2（n = 5）比t1（n = 3）较容易发生的为数组越界错误。当MAXPRIMES为4时，t2会越界。

（c）针对printPrimes(),找到一个测试用例，使得响应的测试路径访问连接while语句开始到for语句的边，而不用通过while循环体。
<strong>解答：</strong>
当n = 1时，即可作为满足题目要求的测试用例。

（d）针对printPrimes（）的图例列举每个节点覆盖，边覆盖和主路径覆盖的测试需求。
解答：
节点覆盖：
TR = {1,2,3,4,5,6,7,8,9,10,11,12,13};

边覆盖：
TR = {(1,2),(2,3),(2,10),(3,4),(4,5),(4,8),(5,6),(5,7),(6,8),(7,4),(8,2),(8,9),(9,2),(10,11),(11,12),(11,13),(12,11)};

主路径覆盖：
TR = {(1,2,3,4,8,9),(1,2,3,4,5,7),(1,2,3,4,5,6,8,9),(1,2,10,11,12),(1,2,10,11,13),(2,3,4,8,9,2),(2,3,4,8,2),(2,3,4,5,7),(2,3,4,5,6,8,9,2),(2,3,4,5,6,8,2),(2,10,11,12),(2,10,11,13),(3,4,5,6,8,9,2,3),(3,4,5,6,8,2,3),(3,4,8,9,2,3),(3,4,8,2,3),(3,4,5,6,8,9,2,10,11,12),(3,4,5,6,8,2,10,11,12),(3,4,5,6,8,9,2,10,11,13),(3,4,5,6,8,2,10,11,13),(3,4,8,9,2,10,11,12),(3,4,8,2,10,11,12),(3,4,8,9,2,10,11,13),(3,4,8,2,10,11,13),(4,5,7,4),(4,5,6,8,9,2,3,4),(4,5,6,8,2,3,4),(4,8,9,2,3,4),(4,8,2,3,4),(5,7,4,5),(5,6,8,9,2,3,4,5),(5,6,8,2,3,4,5),(6,8,9,2,3,4,5,6),(6,8,9,2,3,4,5,6),(6,8,9,2,3,4,5,7),(6,8,2,3,4,5,7),(7,4,5,7),(7,4,8,9,2,3),(7,4,8,2,3),(7,4,5,6,8,9,2,3),(7,4,5,6,8,2,3),(7,4,5,6,8,9,2,10,11,12),(7,4,5,6,8,9,2,10,11,13),(7,4,5,6,8,2,10,11,12),(7,4,5,6,8,2,10,11,13),(7,4,8,9,2,10,11,12),(7,4,8,9,2,10,11,13),(7,4,8,2,10,11,12),(7,4,8,2,10,11,13),(8,2,3,4,8),(8,9,2,3,4,8),(8,2,3,4,5,6,8),(8,9,2,3,4,5,6,8),(9,2,3,4,8,9),(9,2,3,4,5,6,8,9),(11,12,11),(12,11,12),(12,11,13)};


## 二、基于Junit及Eclemma(jacoco)实现一个主路径覆盖的测试

### 1.Primes 类代码：

```java
package com.primes;

public class Primes {
    private static final int MAXPRIMES = 100;

    public Primes() {
    	
    }    
    
    public String printPrimes (int n) { 
        String prime = new String();
        int curPrime;  
        int numPrimes; 
        boolean isPrime; 
        int [] primes = new int [MAXPRIMES]; 
        
        primes [0] = 2; 
        numPrimes = 1; 
        curPrime = 2; 
        while (numPrimes < n) { 
            curPrime++; 
            isPrime = true; 
            for (int i = 0; i <= numPrimes-1; i++) { 
                if (curPrime%primes[i]==0) { 
                    isPrime = false; 
                    break; 
                } 
            } 
            if (isPrime) { 
                primes[numPrimes] = curPrime; 
                numPrimes++; 
            } 
        } 
        
        for (int i = 0; i <= numPrimes-1; i++) {  
            prime += primes[i] + " ";
        } 
        return prime;
    } 
}

```

### 2.PrimesTest 测试类代码：

```java
package com.primes;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PrimesTest {
	private Primes primes;
    @Before
    public void setUp() throws Exception {
    	primes = new Primes();
    }

    @After
    public void tearDown() throws Exception {
    	
    }

    @Test
    public void test1() {
        assertEquals("2 3 5 ", primes.printPrimes(3));
    }
    
    @Test
    public void test2() {
        assertEquals("2 3 5 7 11 ", primes.printPrimes(5));
    }

}

```

### 3.测试运行的结果如下：

![](http://p1.bpimg.com/567571/1ff9b40fa8f12567.png)

![](http://p1.bpimg.com/567571/ef21caa47420023e.png)

![](http://p1.bqimg.com/567571/ae480e7fa6e64cca.png)

![](http://p1.bpimg.com/567571/4357eb8804cd59dc.png)