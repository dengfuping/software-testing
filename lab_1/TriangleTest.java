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
