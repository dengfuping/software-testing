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