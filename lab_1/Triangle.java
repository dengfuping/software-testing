package com.triangle;

public class Triangle {
    private int a, b, c;
    
    public Triangle() {
    	
    }

    public static String judgeTriangle(int a, int b, int c){
        if(a + b> c && a + c > b && b + c > a){
            if (a == b && a == c)
            	return "equilLateral";       // �ȱ�������
            else if ((a == b) && (a != c) || (a == c) && (a != b) || (b == c) && (b !=a )) 
            	return "isSosceles";        // ����������
            else 
            	return "scalene";          // ��ͨ������
        }
        else 
        	return "notTriangle";         // �޷�����������
    }
}